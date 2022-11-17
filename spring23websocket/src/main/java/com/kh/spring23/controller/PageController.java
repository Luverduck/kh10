package com.kh.spring23.controller;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.spring23.entity.MemberDto;

/*
	웹소켓 접속을 위한 JSP를 연결해주는 컨트롤러
*/
@Controller
@RequestMapping("/page")
public class PageController {
	
	// 의존성 주입
	@Autowired
	private SqlSession sqlSession;
	
	// 홈 Mapping
	@GetMapping("/home")
	public String home() {
		return "home";
	}
	
	// 로그인 Mapping
	@PostMapping("/login")
	public String login(@ModelAttribute MemberDto memberDto, HttpSession session) {
		// 입력받은 회원 아아디로 단일 조회
		MemberDto findDto = sqlSession.selectOne("member.get", memberDto.getMemberId());
		// 입력한 아이디를 갖는 회원이 없을 경우
		if(findDto == null) {
			// 홈 Mapping으로 강제 이동(redirect)
			return "redirect:home";
		}
		
		// 입력한 비밀번호가 조회한 회원 정보의 비밀번호와 일치하는지 여부
		boolean judge = memberDto.getMemberPw().equals(findDto.getMemberPw());
		
		// 입력한 비밀번호가 조회한 회원 정보의 비밀번호와 일치한다면
		if(judge) {
			// HttpSession에 해당 회원의 아이디, 닉네임, 회원등급 저장
			session.setAttribute("loginId", findDto.getMemberId());
			session.setAttribute("loginNick", findDto.getMemberNick());
			session.setAttribute("loginAuth", findDto.getMemberGrade());
		}
		// 홈 Mapping으로 강제 이동(redirect)
		return "redirect:home";
	}
	
	// 로그아웃 Mapping
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		// 세션 무효화
		session.invalidate();
		// 홈 페이지(home.jsp)로 연결
		return "redirect:home";
	}

	@GetMapping("/basic")
	public String basic() {
		return "basic";
	}
	
	@GetMapping("/multiple")
	public String multiple() {
		return "multiple";
	}
	
	@GetMapping("/message")
	public String message() {
		return "message";
	}
	
	@GetMapping("/json")
	public String json() {
		return "json";
	}
	
	@GetMapping("/sockjs")
	public String sockjs() {
		return "sockjs";
	}
	
	@GetMapping("/member")
	public String member() {
		return "member";
	}
	
	@GetMapping("/group/{room}")
	public String group(@PathVariable String room, Model model) {
		model.addAttribute("room", room);
		return "group";
	}
}
