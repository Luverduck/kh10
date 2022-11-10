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

	@Autowired
	private JavaMailSender javaMailSender;
	
	@Test
	public void test() throws MessagingException {
		// 1. 메세지 생성
		MimeMessage message = javaMailSender.createMimeMessage();
				
		// 2. 헬퍼 생성
		MimeMessageHelper helper = new MimeMessageHelper(message, false, "UTF-8");
		
		// 3. 정보 설정
		helper.setTo("eomhyunyoung@gmail.com");
		helper.setSubject("마임메세지 테스트");
		// html 태그를 쓰지 않을 경우
		// helper.setText("<h1>안녕</h1>");
		// html 태그를 쓸 경우
		helper.setText("<h1>안녕</h1>", true);
		
		// 4. 전송
		javaMailSender.send(message);
	}
}
