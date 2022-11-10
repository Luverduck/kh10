package com.kh.spring18;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@SpringBootTest
public class MineMessageTest6 {

	@Autowired
	private JavaMailSender javaMailSender;
	
	@Test
	public void test() throws MessagingException, FileNotFoundException, IOException {
		// 1. 메세지 생성
		MimeMessage message = javaMailSender.createMimeMessage();
				
		// 2. 헬퍼 생성 - 파일 첨부시 multipart 부분을 true로 한다
		MimeMessageHelper helper = new MimeMessageHelper(message, false, "UTF-8");
		
		// 3. 정보 설정
		helper.setTo("eomhyunyoung@gmail.com");
		helper.setSubject("Jsoup 변환 테스트");
		
		ClassPathResource resource = new ClassPathResource("email/template3.html");
		
		StringBuffer buffer = new StringBuffer();
		try(Scanner sc = new Scanner(resource.getFile())){ // scanner 자동 close
			while(sc.hasNextLine()) {
				buffer.append(sc.nextLine());
			}
		}
		
		// Jsoup 라이브러리를 사용하여 ID와 Address를 설정한 뒤 전송
		String text = buffer.toString();
		// 불러온 문자열을 HTML로 파싱(해석)
		Document doc = Jsoup.parse(text);
		doc.getElementById("user-name");
		
		Element element = doc.getElementById("user-name"); //id = user-name인 항목 선택
		
		element.text("eomhyunyoung"); // 선택한 대상에 text를 설정
		
		Element link = doc.getElementById("return-url");
		
		// http부터 시작하는 전체 주소 자동 생성 도구
		// (주의) 서버에서 실행될 때만 정상적으로 구동(테스트에서는 80번 포트로 인식, 실제로는 프로젝트가 실행되는 포트 번호로 인식됨)
		String url = ServletUriComponentsBuilder.fromCurrentContextPath()
												.path("/async1")
												.toUriString();
		
		link.attr("href", url);
		
		helper.setText(doc.toString(), true); // html 모드 true
		
		// 4. 전송
		javaMailSender.send(message);
	}
}
