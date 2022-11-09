package com.kh.spring18;

import java.text.DecimalFormat;
import java.text.Format;
import java.util.Random;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import com.kh.spring18.component.RandomGenerator;
import com.kh.spring18.entity.CertDto;
import com.kh.spring18.repository.CertDao;

@SpringBootTest
public class CreateCertTest2 {

	@Autowired
	private JavaMailSender javaMailSender;
	
	@Autowired
	private RandomGenerator randomGenerator;
	
	@Autowired
	private CertDao certDao;
	
	String email = "hwang8243@gmail.com";//사용자가 입력할 정보
	
	@Test
	public void test() {
		//목표 : (1) 랜덤인증번호생성 -> (2) 이메일발송 -> (3) 데이터베이스 등록
		
		//(1)
		Random r = new Random();
		int number = r.nextInt(1000000);
		System.out.println("number = " + number);
		
		Format f = new DecimalFormat("000000");
		String serial = f.format(number);
		
		//(2)
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(email);
		message.setSubject("[KH정보교육원] 이메일 인증번호입니다");
		message.setText("인증번호 : " + number);
		javaMailSender.send(message);
		
		//(3)
		certDao.delete(email);
		CertDto certDto = CertDto.builder().who(email).serial(serial).build();
		certDao.insert(certDto);
	}
	
}