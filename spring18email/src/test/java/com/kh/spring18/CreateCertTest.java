package com.kh.spring18;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import com.kh.spring18.component.RandomGenerator;
import com.kh.spring18.entity.CertDto;
import com.kh.spring18.repository.CertDao;

@SpringBootTest
public class CreateCertTest {

	// DB 접근을 위한 SqlSession 의존성 주입
	@Autowired
	private SqlSession sqlSession;
	
	// 이메일 전송을 위한 JavaMailSender 의존성 주입
	@Autowired
	private JavaMailSender javaMailSender;
	
	// 난수 발생을 위한 의존성 주입
	@Autowired
	private RandomGenerator randomGenerator;
	
	// 인증번호 등록을 위한 의존성 주입
	@Autowired
	private CertDao certDao;
	
	// 테스트용 이메일
	String email = "eomhyunyoung@gmail.com";
	
	@Test
	public void test() {
		// 목표 : 랜덤인증번호 생성 -> 이메일 발송 -> 데이터베이스 등록
		
		// (1) 6자리 랜덤인증번호 생성 -> @Component로 모듈화
		String serial = randomGenerator.generateSerial(6);
		
		// (2) 이메일 발송
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(email);
		message.setSubject("[KH정보교육원] 이메일 인증번호입니다");
		message.setText("인증번호 : " + serial);
		javaMailSender.send(message);
		
		// (3) 데이터베이스 등록
		// 이전에 해당 이메일로 보냈던 인증번호 데이터 삭제
		certDao.delete(email);
		
		// 인증번호 보내기
		CertDto certDto = CertDto.builder().who(email).serial(serial).build();
		certDao.insert(certDto);
	}
}
