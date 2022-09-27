package com.kh.springhome.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.springhome.entity.AttachmentDto;
import com.kh.springhome.entity.BoardDto;
import com.kh.springhome.entity.MemberBoardLikeDto;
import com.kh.springhome.entity.ReplyDto;
import com.kh.springhome.error.TargetNotFoundException;
import com.kh.springhome.repository.AttachmentDao;
import com.kh.springhome.repository.BoardDao;
import com.kh.springhome.repository.MemberBoardLikeDao;
import com.kh.springhome.repository.ReplyDao;
import com.kh.springhome.vo.BoardListSearchVO;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardDao boardDao;
	
	@Autowired
	private ReplyDao replyDao;
	
	@Autowired
	private MemberBoardLikeDao likeDao;
	
	@Autowired
	private AttachmentDao attachmentDao;
	
	// 파일 업로드를 위한 설정
	private final File directory = new File("C:\\Users\\hyeul\\upload");
	
	@PostConstruct	// 최초 실행 시 딱 한번만 실행되는 메소드를 의미하는 어노테이션
	public void prepare() {
		directory.mkdirs();	
	}
	
	// 1. 게시글 작성 (다음 시퀀스 번호를 뽑아서 게시글 작성)
	// 1) 등록 페이지 Mapping
	@GetMapping("/write")
	public String write() {
		return "board/write";
	}
	
	// 2) 등록 Mapping에 DTO 전달 및 DB 처리 
	@PostMapping("/write")
	public String write(HttpSession session, 
						@ModelAttribute BoardDto boardDto, 
						RedirectAttributes attr, 
						@RequestParam List<MultipartFile> attachment) throws IllegalStateException, IOException {
		String boardWriter = (String)session.getAttribute("loginId");
		boardDto.setBoardWriter(boardWriter);
		
		// 등록될 글의 번호를 미리 생성
		int boardNo = boardDao.sequence();
		boardDto.setBoardNo(boardNo);
		
		// 등록을 하기 전에 "새 글"인지 "답글"인지 파악해서 그에 맞는 계산을 수행
		if(boardDto.getBoardParent() == 0) {	// 새 글이라면 (부모글의 번호가 0이면)
			boardDto.setBoardGroup(boardNo);
			boardDto.setBoardParent(0);
			boardDto.setBoardDepth(0);
		}
		else {	// 답글이라면 (부모글의 번호가 0이 아니면)
			BoardDto parentDto = boardDao.selectOne(boardDto.getBoardParent());
			boardDto.setBoardGroup(parentDto.getBoardGroup());
			boardDto.setBoardDepth(parentDto.getBoardDepth() + 1);
		}
		
		boardDao.write(boardDto);
		
//		(+추가) 게시글이 등록된 다음 파일이 있다면 해당 파일을 등록(attachment) 및 연결(board_attachment)
		// - 파일을 첨부하지 않았을 때 어떤 값이 들어오는지?
		System.out.println("첨부파일 수 = " + attachment.size());
		// - 첨부 파일이 없어도 리스트에는 1개의 객체가 들어있다
		for(MultipartFile file : attachment) {
			System.out.println("file = " + file.isEmpty());
		}
		
		for(MultipartFile file : attachment) {
			if(!file.isEmpty()) {
				System.out.println("첨부파일 발견");
				
				// DB 등록
				// 1) 다움 시퀀스 번호 반환
				int attachmentNo = attachmentDao.sequence();
				attachmentDao.insert(AttachmentDto.builder()
													.attachmentNo(attachmentNo)
													.attachmentName(file.getOriginalFilename())
													.attachmentType(file.getContentType())
													.attachmentSize(file.getSize())
												.build());
				
				// 파일 저장
				File target = new File(directory, String.valueOf(attachmentNo));
				System.out.println(target.getAbsolutePath());
				file.transferTo(target);
				
				// + 연결 테이블에 연결 정보를 저장(게시글 번호, 첨부파일 번호)
				boardDao.connectAttachment(boardNo, attachmentNo);
			}
		}
		
		attr.addAttribute("boardNo", boardNo);
		return "redirect:detail";
	}
	
	// 2. 게시글 수정
	// 1) 수정 페이지 Mapping
	@GetMapping("/edit")
	public String edit(Model model, @RequestParam int boardNo) {
		BoardDto boardDto = boardDao.selectOne(boardNo);
		if(boardDto == null) {// 상세 조회 결과가 없는 경우 내가 만든 예외 발생
			throw new TargetNotFoundException();
		}
		model.addAttribute("boardDto", boardDao.selectOne(boardNo));
		return "board/edit";
	}
	
	// 2) 수정 Mapping에 DTO 전달 및 DB 처리 
	@PostMapping("/edit")
	public String edit(@ModelAttribute BoardDto boardDto, RedirectAttributes attr) {
		boolean result = boardDao.update(boardDto);
		if(result) {// 성공했다면 상세페이지로 이동
			attr.addAttribute("boardNo", boardDto.getBoardNo());
			return "redirect:detail";
		}
		else {
			throw new TargetNotFoundException();
		}
	}
	
	// 3. 게시글 삭제
	@GetMapping("/delete")
	public String delete(@RequestParam int boardNo) {
		boolean result = boardDao.delete(boardNo);
		if(result) {// 삭제 성공
			return "redirect:list";	
		}
		else {// 구문은 실행되었지만 바뀐게 없는 경우 (강제 예외 처리)
			throw new TargetNotFoundException();
		}
		
	}

	// <참고> ModelAttribute로 수신한 데이터는 자동으로 Model에 첨부된다
	// - 옵션에 name을 작성하면 해당하는 이름으로 model에 첨부
	// 4. 게시글 목록
	// - 전체 목록 / 검색 목록
	@GetMapping("/list")
	public String selectList(Model model, 
								// @RequestParam(required = false) String type, 
								// @RequestParam(required = false) String keyword
								@ModelAttribute(name = "vo") BoardListSearchVO vo
							) {		
		/*
		// 목록 판정 - 검색 목록을 표시할 것인지 true/false
		//boolean searchTF = type != null && keyword != null;
		//if(searchTF) {	// 검색 목록이라면
		//	model.addAttribute("list", boardDao.selectList(type, keyword));
		//}
		 
		// vo의 isSearch() 메소드 사용
		if(vo.isSearch()) {
			//model.addAttribute("list", boardDao.selectList(vo.getType(), vo.getKeyword()));
			model.addAttribute("list", boardDao.selectList(vo));
		}
		else {	// 검색 목록이 아니라면 (전체 목록이라면)
			model.addAttribute("list", boardDao.selectList());
		}
		*/
		// 페이지 네비게이터를 위한 게시글 수를 구한다
		int count = boardDao.count(vo);
		vo.setCount(count);
		model.addAttribute("list", boardDao.selectList(vo));
		return "board/list";
	}
	
	// 5. 게시글 상세
	@GetMapping("/detail")
	public String selectOne(Model model, @RequestParam int boardNo, HttpSession session) {
		//model.addAttribute("boardDto", boardDao.selectOne(boardNo));
		
// 		(+ 추가) 조회수 방지 처리
// 		(1) 세션에 내가 읽은 개시글의 번호를 저장할 수 있는 저장소를 구현
//			-> 후보 : int[], List<Integer>, Set<Integer> -> Set에는 중복 방지 기능이 있음
//			-> 현재 필요한 것은 게시글을 읽은 적이 있는가(중복 확인)
//			-> 세션에 저장할 이름을 history로 지정
//		(2) 현재 history라는 이름이 없을지 모르므로 꺼내서 없으면 생성
		Set<Integer> history = (Set<Integer>) session.getAttribute("history");
		if(history == null) {//history가 없다면 신규 생성
			history = new HashSet<>();
		}

//		(3) 현재 글 번호를 읽은적이 있는지 검사
		// 중복 검사 - 현재 글 번호의 글을 읽은 적이 있는지
		if(history.add(boardNo)) {//추가된 경우 - 처음 읽는 번호면
			model.addAttribute("boardDto", boardDao.read(boardNo));	// 조회수 증가 + 게시글 상세
		}
		else {//추가가 안된 경우 - 읽은 적이 있는 번호면
			model.addAttribute("boardDto", boardDao.selectOne(boardNo));	// 게시글 상세
		}
		
//		(4) 갱신된 저장소를 세션에 다시 저장
		session.setAttribute("history", history);
		
		// (+추가) 댓글 목록 - 댓글 목록(전체 조회 결과)을 model에 추가
		model.addAttribute("replyList", replyDao.replyList(boardNo));
		
		// (추가) 좋아요 기록이 있는지 조회하여 첨부
		String MemberId = (String) session.getAttribute("loginId");
		if(MemberId != null) {
			MemberBoardLikeDto likeDto = new MemberBoardLikeDto();
			likeDto.setMemberId(MemberId);
			likeDto.setBoardNo(boardNo);
			model.addAttribute("isLike", likeDao.check(likeDto));
		}
		
		// (추가) 현재 글의 좋아요 갯수를 첨부
//		model.addAttribute("likeCount", likeDao.count(boardNo));
		
		// (추가) 게시글에 대한 첨부파일을 조회하여 첨부
		model.addAttribute("attachmentList", attachmentDao.selectBoardAttachmentList(boardNo));
		
		return "board/detail";
	}

	// 여기서부터는 댓글 관련 Controller
	// 1. 댓글 작성
	@PostMapping("/reply/write")
	public String replyWrite(@ModelAttribute ReplyDto replyDto, RedirectAttributes attr, HttpSession session) {
		String replyWriter = (String) session.getAttribute("loginId");
		replyDto.setReplyWriter(replyWriter);
		replyDao.replyWrite(replyDto);
		attr.addAttribute("boardNo", replyDto.getReplyOrigin());
		// return "redirect:../detail"		// 상대 경로
		return "redirect:/board/detail";	// 절대 경로
	}

	// 3. 댓글 수정
	@PostMapping("/reply/edit")
	public String replyEdit(RedirectAttributes attr, @ModelAttribute ReplyDto replyDto) {
		replyDao.replyUpdate(replyDto);
		attr.addAttribute("boardNo", replyDto.getReplyOrigin());
		return "redirect:/board/detail";
	}
	
	// 4. 댓글 삭제
	@GetMapping("/reply/delete")
	public String replyDelete(RedirectAttributes attr, @RequestParam int replyNo, @RequestParam int replyOrigin) {
		replyDao.replyDelete(replyNo);
		attr.addAttribute("boardNo", replyOrigin);
		return "redirect:/board/detail";
	}
	
	// 5. 댓글 블라인드
	@GetMapping("/reply/blind")
	public String replyBlind(RedirectAttributes attr, @RequestParam int replyNo, @RequestParam int replyOrigin) {
		// replyBlind를 조회하기 위함
		ReplyDto replyDto = replyDao.selectOne(replyNo);
		replyDao.updateBlind(replyNo, !replyDto.isReplyBlind());
/*		if(replyDto.isReplyBlind()) {
			replyDao.updateBlind(replyNo, false);
		}
		else {
			replyDao.updateBlind(replyNo, false);
		}*/
		
		attr.addAttribute("boardNo", replyOrigin);
		return "redirect:/board/detail";
	}
	
	// 여기서부터는 좋아요
	@GetMapping("/like")
	public String boardLike(@RequestParam int boardNo, HttpSession session, RedirectAttributes attr) {
		
		String memberId = (String) session.getAttribute("loginId");
		MemberBoardLikeDto dto = new MemberBoardLikeDto();
		dto.setMemberId(memberId);
		dto.setBoardNo(boardNo);
		
		// 좋아요 증가 / 감소
		if(likeDao.check(dto)) {	// 좋아요를 한 상태이면
			likeDao.delete(dto);
		}
		else {	// 좋아요를 한 적이 없는 상태이면
			likeDao.insert(dto);
		}
		
		// 좋아요 총 갯수 갱신
		likeDao.refresh(boardNo);
		
		attr.addAttribute("boardNo", boardNo);
		return "redirect:/board/detail";
	}
}
