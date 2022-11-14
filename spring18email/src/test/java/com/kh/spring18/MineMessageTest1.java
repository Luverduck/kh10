package com.kh.spring18;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

@SpringBootTest
public class MineMessageTest1 {

	// 의존성 주입 - 이메일 전송
	@Autowired
	private JavaMailSender javaMailSender;
	
	@Test
	public void test() throws MessagingException {
		
		// 1) MimeMessage의 인스턴스 생성
		MimeMessage message = javaMailSender.createMimeMessage();
				
		// 2) MimeMessageHelper의 인스턴스 생성
		// - 생성자의 매개변수는 순서대로 MimeMessage, 
		MimeMessageHelper helper = new MimeMessageHelper(message, false, "UTF-8");
		
		// 3) 정보 설정
		helper.setTo("eomhyunyoung@gmail.com");
		helper.setSubject("마임메세지 테스트");
		// html 태그를 적용하지 않을 경우
		// helper.setText("<h1>안녕</h1>");
		// html 태그를 적용할 경우
		helper.setText("<h1>안녕</h1>", true);
		
		// 4) Mime 메시지 전송
		javaMailSender.send(message);
	}
}
