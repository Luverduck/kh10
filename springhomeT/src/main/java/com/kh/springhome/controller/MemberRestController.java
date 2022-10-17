package com.kh.springhome.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kh.springhome.entity.MemberDto;
import com.kh.springhome.repository.MemberDao;

//화면 없이 사용자 요청을 처리해서 데이터만 전송하는 컨트롤러

//CrossOrigin 어노테이션을 붙이면 외부의 접근이 허용된다
@CrossOrigin(origins = {"http://127.0.0.1:5500"})
@RestController//@Controller + @ResponseBody
@RequestMapping("/rest/member")
public class MemberRestController {

	@Autowired
	private MemberDao memberDao;
	
	@GetMapping("/id")
	public String id(@RequestParam String memberId) {
		MemberDto memberDto = memberDao.selectOne(memberId);
		if(memberDto == null) {
			return "NNNNY";//사용할 수 있는 아이디인 경우(아이디 없음)
		}
		else {
			return "NNNNN";//사용할 수 없는 아이디인 경우(아이디 존재)
		}
	}
	
	@RequestMapping("/nick")
	public String nick(@RequestParam String memberNick) {
		MemberDto memberDto = memberDao.findByNickname(memberNick);
		if(memberDto == null) {
			return "NNNNY";//사용할 수 있는 닉네임인 경우(닉네임 없음)
		}
		else {
			return "NNNNN";//사용할 수 없는 닉네임인 경우(닉네임 있음)
		}
	}
	
}







