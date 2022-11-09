package com.kh.spring18;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.spring18.entity.CertDto;
import com.kh.spring18.service.EmailService;

@SpringBootTest
public class CheckCertTest3 {

	@Autowired
	private SqlSession sqlSession;
	
	@Autowired
	private EmailService emailService;
	
	String email = "eomhyunyoung@gmail.com";
	String serial = "849892";
	
	@Test
	public void test() {
		
		CertDto certDto = CertDto.builder().who(email).serial(serial).build();
		
		// delete 과정이 EmailService의 checkCert 안에 포함되어 있음
		boolean result = emailService.checkCert(certDto);
		
		if(result) { // 인증 성공
			System.out.println("인증 성공");
		}
		else {
			System.out.println("인증 실패");
		}
	}
	
}
