package com.kh.springhome.controller;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.springhome.entity.BoardDto;
import com.kh.springhome.entity.BoardListSearchVO;
import com.kh.springhome.error.TargetNotFoundException;
import com.kh.springhome.repository.BoardDao;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardDao boardDao;
	
	// 1. 게시글 작성 (다음 시퀀스 번호를 뽑아서 게시글 작성)
	// 1) 등록 페이지 Mapping
	@GetMapping("/write")
	public String write() {
		return "board/write";
	}
	
	// 2) 등록 Mapping에 DTO 전달 및 DB 처리 
	@PostMapping("/write")
	public String write(HttpSession session, @ModelAttribute BoardDto boardDto, RedirectAttributes attr) {
		String boardWriter = (String)session.getAttribute("loginId");
		boardDto.setBoardWriter(boardWriter);
		int boardNo = boardDao.write(boardDto);
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
		
		if(history == null) {	// history가 없다면 신규 생성
			history = new HashSet<>();
		}
		
		// 중복 검사 - 현재 글 번호의 글을 읽은 적이 있는지
		if(history.contains(boardNo) == true) {	// 추가된 경우 - 처음 읽는 번호면
			model.addAttribute("boardDto", boardDao.read(boardNo));	// 게시글 상세 + 조회수 증가
		}
		else {	// 그렇지 않은 경우 - 읽은 적이 있는 번호면
			model.addAttribute("boardDto", boardDao.selectOne(boardNo)); // 게시글 상세
		}
		
		return "board/detail";
	}
}