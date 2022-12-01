package com.kh.react.restcontroller;

import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.react.entity.MemberDto;
import com.kh.react.repository.MemberDao;
import com.kh.react.vo.MemberLoginVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
// 외부에서 ajax로 전송되는 요청의 쿠키를 수신하도록 설정 + 대상 명시
// (주의) 이 경우에 origins에 와일드카드(*) 사용 금지
@CrossOrigin
(
		origins = "http://localhost:3000",
		allowCredentials = "true" // 인증 정보를 받는 설정
)
@RestController
@RequestMapping("/member")
public class MemberRestController {

	@Autowired
	private MemberDao memberDao;
	
	/*
		사용자가 전송한 JSON을 토대로 로그인을 판정
		- 로그인 성공 : 회원 정보(memberDto) + 토큰(token)
		- 로그인 실패 : 클라이언트에게 404 ERROR 전송
	*/
	@PostMapping("/login")
	public ResponseEntity<MemberLoginVO> login(@RequestBody MemberDto memberDto, HttpSession session) {
		// 회원 단일 조회
		MemberDto findDto = memberDao.login(memberDto);
		
		// 조회 결과가 없으면
		if(findDto == null) {
			return ResponseEntity.notFound().build(); // 404
		}
		
		// 그렇지 않은 경우 응답객체 반환
		// 토큰 생성
		String token = UUID.randomUUID().toString();
		
		// HttpSession에 토큰 저장
		session.setAttribute("memberId", findDto.getMemberId());
		session.setAttribute("token", token);
		
		return ResponseEntity.ok(MemberLoginVO.builder()
				.member(findDto) // DB의 회원 정보
				.token(token) // 인증용 토큰
				.build());
	};
	
	// 토큰을 이용하여 판정 후 회원 정보를 반환하는 컨트롤러
	@GetMapping("/refresh/{token}")
	public ResponseEntity<MemberLoginVO> refresh(@PathVariable String token, HttpSession session) {
		// 1. 세션에서 사용자에게 발급해 둔 토큰을 불러온다
		// 2. 사용자가 경로변수로 넘긴 토큰과 비교한다
		// 3. 토큰이 일치하면 사용자의 아이디에 해당하는 정보를 불러와서 전송
		// 4. 토큰이 일치하지 않으면 404 error를 전송
		
		// 1. 
		String serverToken = (String)session.getAttribute("token");
		
		// 2. 
		if(!token.equals(serverToken)) { // 3.
			return ResponseEntity.notFound().build(); // 404
		}
		
		String memberId = (String)session.getAttribute("memberId");
		MemberDto findDto = memberDao.get(memberId);
		
		String refreshToken = UUID.randomUUID().toString();
		session.setAttribute("memberId", findDto.getMemberId());
		session.setAttribute("token", refreshToken);
		
		return ResponseEntity.ok(MemberLoginVO.builder()
				.member(findDto)//DB의 회원정보
				.token(refreshToken)//인증용 토큰
				.build());
	}
}
