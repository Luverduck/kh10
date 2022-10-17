package com.kh.springhome.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kh.springhome.entity.MemberDto;
import com.kh.springhome.repository.MemberDao;

// CrossOrigin 어노테이션을 붙이면 외부의 접근이 허용된다
// ()로 옵션을 부여하여 특정 Origin만 허용할 수 있다
// origins : origin의 배열
@CrossOrigin(origins = {"http://127.0.0.1:5500"}) // origin(프로토콜 + 호스트 + 포트 번호)가 달라도 접속을 허용

//화면 없이 사용자 요청을 처리해서 데이터만 전송하는 컨트롤러 (= RestController
@RestController // @Controller + @ResponseBody
@RequestMapping("/rest/member")
public class MemberRestController {

	// 의존성 주입
	@Autowired
	private MemberDao memberDao;
	
	@GetMapping("/id")
	public String id(@RequestParam String memberId) {
		
		// 입력받은 아이디로 단일조회
		MemberDto memberDto = memberDao.selectOne(memberId);
		
		if(memberDto == null) { // DB에 해당 아이디가 없는 경우
			return "NNNNY";	// 사용할 수 있는 아이디
		}
		else { // DB에 해당 아이디가 있는 경우
			return "NNNNN"; // 사용할 수 없는 아이디
		}
	}
}
