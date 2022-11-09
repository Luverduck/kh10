package com.kh.spring18;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.spring18.service.EmailService;

@SpringBootTest
public class CreateTest3 {

	@Autowired
	private EmailService emailService;
	
	String email = "eomhyunyoung@gmail.com"; // 사용자가 입력할 정보
	
	@Test
	public void test() {
		emailService.sendCertMail(email);
	}
}
