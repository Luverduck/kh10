package com.kh.spring18;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@SpringBootTest
public class EmailTest2 {

	// configuration에 설정되어있는 JavaMailSender 의존성 주입
	@Autowired
	private JavaMailSender sender;
	
	@Test
	public void test() {
		// 메세지 작성
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo("hyeuler1992@gmail.com"); // 수신인
		//message.setCc(""); // 참조
		//message.setBcc(""); // 숨은 참조
		
		message.setSubject("테스트 이메일"); // 메일 제목
		message.setText("메롱"); // 메일 내용
		
		// 전송
		sender.send(message);
	}
}
