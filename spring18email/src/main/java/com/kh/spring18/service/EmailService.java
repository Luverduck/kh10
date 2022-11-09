package com.kh.spring18.service;

public interface EmailService {

	// 추상 메소드 - 인증번호 전송
	void sendCertMail(String email);
}
