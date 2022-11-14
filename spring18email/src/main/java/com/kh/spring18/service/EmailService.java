package com.kh.spring18.service;

import com.kh.spring18.entity.CertDto;

public interface EmailService {

	// 추상 메소드 - 인증번호 발급 및 등록
	void sendCertMail(String email);
	
	// 추상 메소드 - 인증번호 검사
	boolean checkCert(CertDto certDto);
}
