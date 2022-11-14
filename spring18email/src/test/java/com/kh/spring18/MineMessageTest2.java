package com.kh.spring18;

import java.io.File;

import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

@SpringBootTest
public class MineMessageTest2 {

	// 의존성 주입 - 이메일 전송
	@Autowired
	private JavaMailSender javaMailSender;
	
	@Test
	public void test() throws MessagingException {
		
		// 1) MimeMessage의 인스턴스 생성
		MimeMessage message = javaMailSender.createMimeMessage();
				
		// 2) MimeMessageHelper의 인스턴스 생성
		// - 파일 첨부시 multipart를 true로 한다
		MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
		
		// 3) 정보 설정
		helper.setTo("eomhyunyoung@gmail.com");
		helper.setSubject("첨부파일 테스트");
		helper.setText("첨부파일을 확인해주세요");
		
		// ** 첨부파일 설정
		// - File 클래스의 인스턴스 생성
		File target = new File("D:\\", "attachmentTest.jpg");
		// - File 클래스의 인스턴스로 FileDataSource의 인스턴스 생성 후 DataSource로 업 캐스팅
		DataSource source = new FileDataSource(target);
		// - MimeMessageHelper에 해당 DataSource를 원본 파일명으로 첨부파일에 추가
		helper.addAttachment(target.getName(), source);
		
		// 4) Mime 메시지 전송
		javaMailSender.send(message);
	}
}
