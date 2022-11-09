package com.kh.spring18.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.spring18.entity.CertDto;
import com.kh.spring18.service.EmailService;

@Controller
public class TestController {
	
	@Autowired
	private EmailService emailService;

	// 이메일 인증 메일 발송 Mapping
	@RequestMapping("/test1")
	public String test1() {
		// 이메일 입력 페이지(test1)로 연결
		return "test1";
	}
	
	// 이메일 인증번호 입력 Mapping
	@RequestMapping("/test2")
	public String test2(@RequestParam String who, Model model) {
		// 이메일 전송
		emailService.sendCertMail(who);
		// 이메일을 Model에 첨부
		model.addAttribute("who", who);
		// 인증번호 입력 페이지(test2)로 연결
		return "test2";
	}
	
	// 이메일 인증번호 등록 및 인증확인 Mapping
	@RequestMapping("/test3")
	public String test3(@ModelAttribute CertDto certDto, RedirectAttributes attr) {
		boolean result = emailService.checkCert(certDto);
		if(result) {
			return "redirect:test4";
		}
		else {
			attr.addAttribute("who", certDto.getWho());
			return "redirect:test2?error";
		}
	}
	
	// 이메일 인증 성공 Mapping
	@RequestMapping("/test4")
	public String test4() {
		return "test4";
	}
}
