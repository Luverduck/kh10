package com.kh.spring18.configuration;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

// 설정은 @Configuration으로 등록한다
@Configuration
public class EmailConfiguration {

	@Autowired
	private EmailProperties emailProperties;
	
	@Bean
	public JavaMailSender javaMailSender() {
		
		// 도구 생성 및 정보 설정
		// - Spring 클래스
		JavaMailSenderImpl sender = new JavaMailSenderImpl();
		sender.setHost(emailProperties.getHost()); // 이메일 전송 대행업체의 HOST 명칭 (gmail 전용)
		sender.setPort(emailProperties.getPort()); // 이메일 전송 대행업체의 PORT
		sender.setUsername(emailProperties.getUsername()); // 이메일 전송 대행업체 로그인 ID
		sender.setPassword(emailProperties.getPassword()); // 이메일 전송 대행업체 로그인 PW(앱 비밀번호)
		
		// 추가 정보 설정
		// - Java 클래스
		Properties props = new Properties(); //Map<String, String> 형태의 저장소
		props.setProperty("mail.smtp.auth", "true"); //인증 여부 설정(필수)
		props.setProperty("mail.smtp.debug", "true"); //디버깅 사용 여부 설정(선택)
		props.setProperty("mail.smtp.starttls.enable", "true"); //TLS 사용 여부(필수)
		props.setProperty("mail.smtp.ssl.protocols", "TLSv1.2"); //TLS 버전 설정(필수)
		props.setProperty("mail.smtp.ssl.trust", "smtp.gmail.com"); //신뢰할 수 있는 대상으로 추가(필수)
		
		sender.setJavaMailProperties(props);
		
		// 설정된 sender 반환 - JavaMailSenderImpl을 만들어서 JavaMailSender 형태로 반환 (업 캐스팅)
		return sender;
	}
}
