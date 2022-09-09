package com.kh.springhome.controller;

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

import com.kh.springhome.entity.MemberDto;
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
	public String insert(@ModelAttribute MemberDto memberDto) {
		// 1) DB에서 등록(insert) 실행
		memberDao.insert(memberDto);
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
	
	// 5-2. 등록 Mapping에 DTO 전달 및 DB 처리
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
			// Session에 loginId에 memberId 값을 저장
			session.setAttribute("loginId", inputDto.getMemberId());
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
		// 2) 메인 Mapping으로 강제 이동
		return "redirect:/";
	}
	
	// 7. 마이 페이지 
	// 7-1. 마이페이지 Mapping
	@GetMapping("/mypage")
	public String mypage(Model model, @ModelAttribute MemberDto memberDto, HttpSession session) { 
		// 0) Session에 저장된 MemberId(loginId)를 반환
		// .getAttribute(attributeName) : Session에 저장된 loginId라는 key에 저장된 value를 반환
		String MemberId = (String) session.getAttribute("loginId");
		// 1) Model의 변수명과 값 설정 - MemberId와 일치하는 단일 조회 selectOne()의 결과값으로 설정
		model.addAttribute("memberDto", memberDao.selectOne(MemberId));
		// 2) Model을 view에 전달 (mypage.jsp에서 전달 받은 Model을 표시할 형식을 정의)
		return "member/mypage";
	}
	
	// 7-2. 마이페이지 
	
	
	// footer의 각 항목으로 이동하기 위한 redirect 모음
	// - 포켓몬스터
	@GetMapping("/pocketmon/list")
	public String footPocketmon() {
		return "redirect:../../pocketmon/list";
	} 
	// - 방명록
	@GetMapping("/guestbook/list")
	public String footGuestbook() {
		return "redirect:../../guestbook/list";
	}
	// - 음원 관리
	@GetMapping("/music/list")
	public String footMusic() {
		return "redirect:../../music/list";
	}
	// - 로그인
	@GetMapping("/member/login")
	public String footLogin() {
		return "redirect:../../member/login";
	}
	// - 회원가입
	@GetMapping("/member/insert")
	public String footJoin() {
		return "redirect:../../member/insert";
	}
	// - 로그아웃
	@GetMapping("/member/logout")
	public String footLogout() {
		return "redirect:../../member/logout";
	}
	// - 회원목록
	@GetMapping("member/list")
	public String footList() {
		return "redirect:../../member/list";
	}
	// - 마이페이지
	@GetMapping("/member/mypage")
	public String footMypage() {
		return "redirect:../../member/mypage";
	}
}
