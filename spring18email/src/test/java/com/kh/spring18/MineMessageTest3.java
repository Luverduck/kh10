package com.kh.spring18;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

@SpringBootTest
public class MineMessageTest3 {

	// 의존성 주입 - 이메일 전송
	@Autowired
	private JavaMailSender javaMailSender;
	
	@Test
	public void test() throws MessagingException, FileNotFoundException, IOException {
		
		// 1) MimeMessage의 인스턴스 생성
		MimeMessage message = javaMailSender.createMimeMessage();
				
		// 2) MimeMessageHelper의 인스턴스 생성
		MimeMessageHelper helper = new MimeMessageHelper(message, false, "UTF-8");
		
		// 3) 정보 설정
		helper.setTo("eomhyunyoung@gmail.com");
		helper.setSubject("HTML 템플릿 테스트");
		
		// ** Spring 프로젝트 내 Resource 파일 읽기
		ClassPathResource resource = new ClassPathResource("email/template2.html");
		
		// ** 해당 Resource 파일의 내용을 StringBuffer로 연결
		StringBuffer buffer = new StringBuffer();
		try(Scanner sc = new Scanner(resource.getFile())){
			while(sc.hasNextLine()) {
				buffer.append(sc.nextLine());
			}
		}
		
		// 내용(text)에 들어갈 값 및 html 적용여부 설정
		helper.setText(buffer.toString(), true);
		
		// 4) Mime 메시지 전송
		javaMailSender.send(message);
	}
}
