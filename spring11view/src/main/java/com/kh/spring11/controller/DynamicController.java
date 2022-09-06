package com.kh.spring11.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dynamic")
public class DynamicController {

	@GetMapping("/test01")
	public String test01() {
		return "dynamic/test01";
	}
	
	@GetMapping("/test02")
	public String test02() {
		return "dynamic/test02";
	}
	
	
//	Controller에서 View로 데이터(model)을 보낼 수 있다
//	현재 구조에서 할 수 있는 방법은 매개 변수에 Model 타입의 객체를 선언하는 것	
	@GetMapping("/test03")
	public String test03(Model model) {
		// model에 데이터 추가는 다음과 같이 한다
		// model.addAttribute("이름", 값);	Map의 구조(key-value)
		// 이름은 문자열, 값은 아무거나 가능
		model.addAttribute("name", "피카츄");
		model.addAttribute("score", 80);
		return "dynamic/test03";
	}
	
	@GetMapping("/test04")
	public String test04(Model model) {
		// model에 데이터 추가는 다음과 같이 한다
		// model.addAttribute("이름", 값);	Map의 구조(key-value)
		// 이름은 문자열, 값은 아무거나 가능
		model.addAttribute("name", "피카츄");
		model.addAttribute("score", 80);
		return "dynamic/test04";
	}
}
