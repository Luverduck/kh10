package com.kh.spring18;

import java.text.DecimalFormat;
import java.text.Format;
import java.util.Random;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import com.kh.spring18.entity.CertDto;

@SpringBootTest
public class CreateCertTest {

	// DB 접근을 위한 SqlSession 의존성 주입
	@Autowired
	private SqlSession sqlSession;
	
	// 이메일 전송을 위한 JavaMailSender 의존성 주입
	@Autowired
	private JavaMailSender javaMailSender;
	
	// 테스트용 이메일
	String email = "eomhyunyoung@gmail.com";
	
	@Test
	public void test() {
		// 목표 : 랜덤인증번호 생성 -> 이메일 발송 -> 데이터베이스 등록
		
		// (1) 랜덤인증번호 생성
		Random r = new Random();
		int number = r.nextInt(1000000);
		System.out.println("number = " + number);
		
		// 인증번호를 6자리로 고정하도록
		Format f = new DecimalFormat("000000");
		String serial = f.format(number);
		
		// (2) 이메일 발송
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(email);
		message.setSubject("[KH정보교육원] 이메일 인증번호입니다");
		message.setText("인증번호 : " + serial);
		javaMailSender.send(message);
		
		// (3) 데이터베이스 등록
		// 이전에 해당 이메일로 보냈던 인증번호 데이터 삭제
		sqlSession.delete("cert.delete", email);
		// 인증번호 보내기
		CertDto certDto = CertDto.builder().who(email).serial(serial).build();
		sqlSession.insert("cert.insert", certDto);
	}
	
	
}
