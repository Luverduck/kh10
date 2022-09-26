package com.kh.springhome.controller;

import java.io.File;
import java.io.IOException;

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

import com.kh.springhome.entity.MemberDto;
import com.kh.springhome.entity.PasswordDto;
import com.kh.springhome.repository.MemberDao;
 
@Controller
@RequestMapping("/member")
public class MemberController {

	@Autowired
	private MemberDao memberDao;
	
	// 1. 등록 (insert)
	// 1-1. 등록 Mapping
	@GetMapping("/insert")
	public String insert() {
		// 등록 페이지 (insert.jsp)로 연결
//		return "/WEB-INF/views/member/insert";
		return "member/insert";
	}
	
	// 1-2. 등록 Mapping에 DTO 전달 및 DB 처리
	// DB에서 등록(insert) 처리 후 등록 완료 Mapping으로 이동
	@PostMapping("/insert")
	public String insert(@ModelAttribute MemberDto memberDto, @RequestParam MultipartFile memberProfile) throws IllegalStateException, IOException {
		// 1) DB에서 등록(insert) 실행
		memberDao.insert(memberDto);
		
		// 첨부 파일 여부에 따라 저장
		if( ! memberProfile.isEmpty()) {		// 첨부 파일이 없다면 -> .isEmpty() 또는 .size()
			// (+추가) 첨부 파일을 받아서 저장
			File directory = new File("C:\\Users\\hyeul\\upload\\member");
			directory.mkdirs();
			File target = new File(directory, memberDto.getMemberId());	// 파일명을 회원 아이디로
			memberProfile.transferTo(target);
		}
		
		// 2) 등록 처리 후 등록 완료(insert_success) Mapping으로 강제이동(redirect) (새로고침 시 데이터 중복 입력하는 것을 방지)
		return "redirect:insert_success";
	}
	
	// 1-3. 등록 완료 Mapping
	@GetMapping("/insert_success")
	public String insertSuccess() {
		// 등록 완료 페이지(insertResult.jsp)로 연결
//		return "/WEB-INF/views/member/insertSuccess";
		return "member/insertSuccess";
	}
	
	// 2. 조회 (select) - isSearch가 true일 경우 검색어 조회. false일 경우 전체 조회
	// 조회 Mapping
	@GetMapping("/list")
	public String SelectList(Model model, @RequestParam(required = false) String type, @RequestParam(required = false) String keyword) {
		// 조회 유형 판정
		boolean isSearch = type != null && keyword != null;
		// 1) Model의 변수명과 값 설정
		if(isSearch) {	// true일 경우 검색어 조회 selectList(String type, String keyword)의 결과값으로 설정
			model.addAttribute("list", memberDao.selectList(type, keyword));
		}
		else {	// false일 경우 전체 조회 selectList()의 결과값으로 설정
			model.addAttribute("list", memberDao.selectList());
		}
		// 2) Model을 view에 전달 (list.jsp에서 전달받은 Model을 표시할 형식을 정의) 
		return "member/list";
	}
	
	// 2-1. 단일 조회 (detail)
	// 단일 조회 Mapping
	@GetMapping("/detail")
	public String detail(Model model, @RequestParam String memberId) {
		// DB에서 단일 조회 selectOne() 실행 후 결과를 PocketMonsterDto 타입의 인스턴스 dto에 저장
		MemberDto memberDto = memberDao.selectOne(memberId);
		// 1) Model의 변수명과 값 설정 - 단일조회 selectOne()의 결과값으로 설정
		model.addAttribute("memberDto", memberDto);
		// 2) Model을 view에 전달 (detail.jsp에서 전달 받은 Model을 표시할 형식을 정의)
		return "member/detail";
	}
	
	// 3. 수정 (update)
	// 3-1. 수정 Mapping
	@GetMapping("/edit")
	public String edit(Model model, @RequestParam String memberId) {
		// 1) Model의 변수명과 값 설정 - 단일조회 selectOne()의 결과값으로 설정
		model.addAttribute("memberDto", memberDao.selectOne(memberId));
		// 2) PostMapping으로 이동
		return "member/edit";
	}
	
	// 3-2. 수정 Mapping에 DTO 전달 및 DB 처리 
	@PostMapping("/edit")
	public String edit(@ModelAttribute MemberDto memberDto, RedirectAttributes attr) {
		// DB에서 수정(update) 실행 결과(boolean, 실행 결과가 0보다 큰지)에 따라 서로 다른 Mapping으로 이동
		if(memberDao.update(memberDto)) {	// true라면 해당 아이디(memberId) 회원의 단일 조회 Mapping으로 이동
			attr.addAttribute("memberId", memberDto.getMemberId());
			return "redirect:detail";
		}
		else {	// false라면 수정 실패(edit_fail) Mapping으로 이동
			return "redirect:edit_fail";
		}
	}
	
	// 3-3. 수정 실패 Mapping
	@GetMapping("/edit_fail")
	public String editFail() {
		// 수정 실패 페이지(editFail.jsp)으로 이동
		return "member/editFail";
	}
	
	// 4. 삭제 (delete)
	// 삭제 Mapping
	@GetMapping("/delete")
	public String delete(@RequestParam String memberId) {
		// DB에서 삭제(delete) 실행 결과(boolean, 실행 결과가 0보다 큰지)에 따라 서로 다른 Mapping으로 이동
		if(memberDao.delete(memberId)) {	// true라면 조회(list) Mapping으로 이동
			return "redirect:list";
		}
		else {	// false라면 수정 실패 Mapping으로 이동
			return "member/editFail";
		}
	}
	
	// 5. 로그인
	// 5-1. 로그인 페이지 Mapping
	@GetMapping("/login")
	public String login() {
//		return "/WEB-INF/views/member/login.jsp";
		return "member/login";
	}
	
	// 5-2. 로그인 Mapping에 DTO 전달
	// inputDto는 사용자가 입력한 정보, findDto는 DB 조회 결과
	// 입력한 inputDto의 memberId, memberPw와 DB 조회 결과인 findDto의 memberId, memberPw를 비교
	@PostMapping("/login")
	public String login(@ModelAttribute MemberDto inputDto, HttpSession session) {
		MemberDto findDto = memberDao.selectOne(inputDto.getMemberId());
		if(findDto == null) {	// a) 아이디 일치 여부
			return "redirect:login?error";	// redirect는 언제나 get방식
		}
		boolean passwordMatch = inputDto.getMemberPw().equals(findDto.getMemberPw());
		if(passwordMatch) {	// c) 아이디와 비밀번호 모두 일치
			// Session에 loginId에 memberId, memberGrade 값을 저장
			session.setAttribute("loginId", inputDto.getMemberId());
			session.setAttribute("mg", findDto.getMemberGrade());
			// 로그인 시간 갱신
			memberDao.updateLoginTime(inputDto.getMemberId());
			// 메인 Mapping으로 강제 이동
			return "redirect:/";
		}
		else {	// b) 아이디는 일치하지만 비밀번호 불일치
			// 로그인 에러 Mapping으로 강제 이동
			return "redirect:login?error";
		}
	}
	
	// 6. 로그아웃 
	// 로그아웃 Mapping
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		// 1) Session에 저장된 loginId 삭제
		session.removeAttribute("loginId");
		session.removeAttribute("mg");
		// session.invalidate(); - 세션 파괴(비추천 - 방문자 수 카운트시 문제 발생)
		// 2) 메인 Mapping으로 강제 이동
		return "redirect:/";
	}
	
	// 7. 마이페이지 - 현재 로그인한 회원의 정보를 화면에 출력
	// 마이페이지 Mapping
	@GetMapping("/mypage")
	public String mypage(Model model, @ModelAttribute MemberDto memberDto, HttpSession session) { 
		// 0) Session에 저장된 MemberId(loginId)를 반환
		// .getAttribute(attributeName) : Session에 저장된 loginId라는 key에 저장된 value를 반환
		// - Session의 데이터는 Object 형태로 저장되므로 꺼내려면 down casting 필요
		String memberId = (String) session.getAttribute("loginId");
		// 1) Model의 변수명과 값 설정 - MemberId와 일치하는 단일 조회 selectOne()의 결과값으로 설정
		model.addAttribute("memberDto", memberDao.selectOne(memberId));	
		// 2) Model을 view에 전달 (전달 받은 Model은 mypage.jsp에서 표시 형식을 정의)
		
		// ## 내가 작성한 게시글
		model.addAttribute("myBoardList", memberDao.myBoard(memberId));
		
		return "/member/mypage";
		// (참고) 기존에 만든 detail에 전달
		// 2) Model을 view에 전달 (전달 받은 Model은 detail.jsp에서 표시 형식을 정의)
		// return "member/detail";
	}	
	
	// 8. 비밀번호 변경 (me)
	// 8-1. 비밀번호 변경 Mapping
	@GetMapping("/password")
	public String changePassword() {
		return "/member/password";
	}
	
	// 8-2. 비밀번호 변경 Mapping에 DB처리 
	// PasswordDto는 view로부터 전달받는 비밀번호 변경을 위한 Dto 
	// - pwNow(현재 비밀번호), pwChange(변경 비밀번호), pwChangeCheck(비밀번호 확인)으로 구성
	@PostMapping("/password")
	public String changePassword(HttpSession session, @ModelAttribute PasswordDto passwordDto) {
		// 1) 현재 비밀번호 확인을 위해 Session에 저장된 아이디에 해당하는 MemberDto 및 비밀번호 반환
		String memberId = (String) session.getAttribute("loginId");
		MemberDto memberDto = memberDao.selectOne(memberId);
		String memberPw = memberDto.getMemberPw();
		// 2) 다음 여부를 모두 만족하는 경우 비밀번호 변경
		//   i) memberDto의 비밀번호(memberPw)와 passwordDto의 현재 비밀번호(pwNow)가 일치하는지
		//   ii) passwordDto의 변경 비밀번호(pwChange)와 비밀번호 확인(pwChangeCheck)가 일치하는지
		if(memberPw.equals(passwordDto.getPwNow()) && passwordDto.getPwChange().equals(passwordDto.getPwChangeCheck())) {
			// i)와 ii)를 모두 만족하는 경우 memberDto에서 비밀번호만 passwordDto의 변경 비밀번호(pwChange)로 변경
			memberDto.setMemberPw(passwordDto.getPwChange());
			// 비밀번호 부분만 수정한 memberDto를 매개변수로 하여 수정(update) 메소드 실행 
			memberDao.update(memberDto);
			// 수정(update) 메소드 실행 후 비밀번호 변경 완료 Mapping으로 강제 이동(redirect)
			return "redirect:password_change";
		}
		else {
			// 그외 경우는 비밀번호 변경 Mapping으로 강제 이동(redirect)
			return "redirect:password";
		}
	}
	
	// 8-3. 비밀번호 변경 완료 Mapping
	@GetMapping("/password_change")
	public String changePasswordSuccess() {
		return "/member/passwordSuccess";
	}
	
	// 9. 개인정보 변경
	// 9-1. 개인정보 변경 Mapping
	@GetMapping("/information")
	public String information(HttpSession session, Model model) {
		// 1) 자신의 아이디를 획득(HttpSession)
		String memberId = (String) session.getAttribute("loginId");
		
		// 2) 아이디로 정보를 조회
		MemberDto memberDto = memberDao.selectOne(memberId);
		
		// 3) 조회한 정보를 화면으로 전달
		model.addAttribute("memberDto", memberDto);
		
		// 4) 연결될 화면 주소 반환
//			return "/WEB-INF/view/member/information.jsp";
		return "/member/information";
	}
	
	// 9-2. 개인정보 변경 Mapping에 DB처리
	@PostMapping("/information")
	public String information(HttpSession session, @ModelAttribute MemberDto inputDto) {
		// memberDto에 memberId가 없다 -> Session에서 memberId 반환 후 추가 설정
		String memberId = (String) session.getAttribute("loginId");
		inputDto.setMemberId(memberId);
		
		// 1) 비밀번호 검사
		MemberDto memberDto = memberDao.selectOne(memberId);
		boolean passwordMatch = inputDto.getMemberPw().equals(memberDto.getMemberPw());
		
		if(passwordMatch) {
			// 2) 비밀번호 검사를 통과했다면 정보를 변경하도록 처리
			memberDao.changeInformation(inputDto);
			return "redirect:mypage";
		}
		else {	// 비밀번호가 틀린 경우
			return "redirect:information?error";
		}
	}
	
	// 9-3. 정보 변경 실패 Mapping
	@GetMapping("/information_fail")
	public String informationFail() {
		return "redirect:editFail";
	}
	
	// 10. 회원 탈퇴
	// 10-1. 회원 탈퇴 Mapping
	@GetMapping("/goodbye")
	public String goodbye() {
		return "/member/goodbye";
	}
	
	// 10-2. 회원 탈퇴 Mapping에서 DB 처리
	@PostMapping("/goodbye")
	public String goodbye(HttpSession session, @RequestParam String memberPw, @RequestParam String memberPwCheck) {
		String memberId = (String) session.getAttribute("loginId");
		MemberDto memberDto = memberDao.selectOne(memberId);
		boolean passwordMatch = memberDto.getMemberPw().equals(memberPw) && memberPw.equals(memberPwCheck);
		if(passwordMatch) {
			// 회원 탈퇴
			memberDao.delete(memberId);
			// Session의 모든 정보 삭제
			session.removeAttribute("loginId");
			session.removeAttribute("mg");
			return "redirect:goodbye_result";
		}
		else {
			return "redirect:goodbye?error";
		}
	}
	// 10-3. 회원 탈퇴 성공 페이지
	@GetMapping("/goodbye_result")
	public String goodbyeResult() {
		return "/member/goodbyeResult";
	}
}
