package com.kh.spring18.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.kh.spring18.component.RandomGenerator;
import com.kh.spring18.entity.CertDto;
import com.kh.spring18.repository.CertDao;

@Service
public class GmailService implements EmailService {

	// 의존성 주입 - 인증번호 생성
	@Autowired
	private RandomGenerator randomGenerator;
	
	// 의존성 주입 - 발급한 인증번호 등록/삭제/조회
	@Autowired
	private CertDao certDao;
	
	// 의존성 주입 - 이메일 전송
	@Autowired
	private JavaMailSender javaMailSender;

	// 추상 메소드 오버라이딩 - 인증번호 전송
	@Override
	public void sendCertMail(String email) {
		
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

	// 추상 메소드 오버라이딩 - 
	@Override
	public boolean checkCert(CertDto certDto) {
		if(certDao.check(certDto)) { // 인증 성공
			certDao.delete(certDto.getWho()); // certDto에서 who를 반환하여 인증번호 삭제
			return true;
		}
		return false;
	}
}
