package com.kh.spring11.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/hello")
//	@ResponseBody	// 이제 화면을 사용할 예정
	public String hello() {
		//return "hello.jsp의 위치";
		return "hello";
	}

	@RequestMapping("/hello1")
	public String hello1() {
		return "hello1";
	}
	
	@RequestMapping("/test")
	public String test() {
		return "test";
	}
}