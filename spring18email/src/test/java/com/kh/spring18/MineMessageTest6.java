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
		helper.setSubject("Jsoup 변환 테스트");
		
		// ** Spring 프로젝트 내 Resource 파일 읽기
		ClassPathResource resource = new ClassPathResource("email/template3.html");
		
		// ** 해당 Resource 파일의 내용을 StringBuffer로 연결
		StringBuffer buffer = new StringBuffer();
		try(Scanner sc = new Scanner(resource.getFile())){ // scanner 자동 close
			while(sc.hasNextLine()) {
				buffer.append(sc.nextLine());
			}
		}
		String text = buffer.toString();
		
		// StringBuffer로 생성한 문자열을 HTML로 분석(parse)
		Document doc = Jsoup.parse(text);
		
		// doc에서 'user-name'이라는 id를 가진 요소를 선택
		Element element = doc.getElementById("user-name"); 
		
		// 선택한 요소에 해당 문자열을 설정(대체)
		element.text("eomhyunyoung"); 
		
		// doc에서 'user-url'이라는 id를 가진 요소를 선택
		Element link = doc.getElementById("return-url");
		
		// http로 시작하는 전체 주소 자동 생성 도구
		// (주의) 서버에서 실행될 때만 정상적으로 구동(테스트에서는 80번 포트로 인식, 실제로는 프로젝트가 실행되는 포트 번호로 인식됨)
		String url = ServletUriComponentsBuilder.fromCurrentContextPath()
												.path("/async1")
												.toUriString();
		
		// 선택한 요소에 해당 이름의 속성(attribute)과 값을 설정
		link.attr("href", url);
		
		// 내용(text)에 들어갈 값 및 html 적용여부 설정
		helper.setText(doc.toString(), true);
		
		// 4) Mime 메시지 전송
		javaMailSender.send(message);
	}
}
