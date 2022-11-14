package com.kh.spring18.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.spring18.entity.CertDto;
import com.kh.spring18.service.EmailService;

@Controller
public class AsyncController {

	// 의존성 주입 - 이메일 전송
	@Autowired
	private EmailService emailService;
	
	// 인증 페이지 Mapping
	@RequestMapping("/async1")
	public String async1() {
		// 인증 페이지(async.jsp)로 연결 
		return "async1";
	}
	
	// 인증메일 전송 및 DB 등록 Mapping
	@PostMapping("/async2")
	@ResponseBody
	public void async2(@RequestParam String who) {
		// 인증메일 전송 및 해당 인증번호에 대한 정보 등록
		emailService.sendCertMail(who);
	}
	
	// 인증번호 검사
	@PostMapping("/async3")
	@ResponseBody
	public boolean async3(@ModelAttribute CertDto certDto) {
		// 해당 인증번호가 존재하며 5분 이내 인증번호인지 검사 및 결과 반환
		return emailService.checkCert(certDto);
	}
}
