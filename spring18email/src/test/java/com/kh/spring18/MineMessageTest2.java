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

	@Autowired
	private JavaMailSender javaMailSender;
	
	@Test
	public void test() throws MessagingException {
		// 1. 메세지 생성
		MimeMessage message = javaMailSender.createMimeMessage();
				
		// 2. 헬퍼 생성 - 파일 첨부시 multipart 부분을 true로 한다
		MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
		
		// 3. 정보 설정
		helper.setTo("eomhyunyoung@gmail.com");
		helper.setSubject("첨부파일 테스트");
		helper.setText("첨부파일을 확인해주세요");
		
		// 이메일 첨부는 DataSource라는 형태로 해야한다
		File target = new File("D:\\", "attachmentTest.jpg");
		DataSource source = new FileDataSource(target); // activation에 있는 것으로 import
		helper.addAttachment(target.getName(), source); // 원본 파일명으로 전송
		
		// 4. 전송
		javaMailSender.send(message);
	}
}
