package com.kh.spring18;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

@SpringBootTest
public class MineMessageTest2 {

	@Autowired
	private JavaMailSender javaMailSender;
	
	@Test
	public void test() throws MessagingException, FileNotFoundException, IOException {
		// 1. 메세지 생성
		MimeMessage message = javaMailSender.createMimeMessage();
				
		// 2. 헬퍼퍼 생성 - 파일 첨부시 multipart 부분을 true로 한다
		MimeMessageHelper helper = new MimeMessageHelper(message, false, "UTF-8");
		
		// 3. 정보 설정
		helper.setTo("eomhyunyoung@gmail.com");
		helper.setSubject("HTML 템플릿 테스트");
		
		ClassPathResource resource = new ClassPathResource("email/template.html");
		
		StringBuffer buffer = new StringBuffer();
		try(Scanner sc = new Scanner(resource.getFile())){ // scanner 자동 close
			while(sc.hasNextLine()) {
				buffer.append(sc.nextLine());
			}
		}
		
		helper.setText(buffer.toString(), true); // html 모드 true
		
		// 4. 전송
		javaMailSender.send(message);
	}
}
