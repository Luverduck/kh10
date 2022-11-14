package com.kh.spring22.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/view")
public class ViewContoller {

	@RequestMapping("/pocketmon")
	public String pocketmon() {
		return "pocketmon";
	}
	
	@RequestMapping("/music")
	public String music() {
		return "music";
	}
}
