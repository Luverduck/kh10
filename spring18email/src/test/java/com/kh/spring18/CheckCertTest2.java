package com.kh.spring18;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.spring18.entity.CertDto;
import com.kh.spring18.repository.CertDao;

@SpringBootTest
public class CheckCertTest2 {

	// DB 접근을 위한 의존성 주입
	@Autowired
	private CertDao certDao;
	
	// 테스트를 위한 인증번호 정보
	String email = "abcd@gmail.com";
	String serial = "849892";
	
	@Test
	public void test() {
		
		// 주어진 정보(email, serial)로 certDto 설정
		CertDto certDto = CertDto.builder().who(email).serial(serial).build();
		
		// 설정된 certDto로 인증번호 조회(5분 이내 발급된 인증번호인지)
		boolean result = certDao.check(certDto);
		
		// 5분 이내 발급된 인증번호인지 여부 판정
		if(result) { // 5분 이내 발급된 인증번호라면(인증 성공)
			System.out.println("인증 성공");
			certDao.delete(email);
		}
		else { // 그렇지 않다면(인증 실패)
			System.out.println("인증 실패");
		}
	}
}
