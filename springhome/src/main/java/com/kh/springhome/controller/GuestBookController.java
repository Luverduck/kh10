package com.kh.springhome.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.springhome.entity.GuestBookDto;
import com.kh.springhome.repository.GuestBookDao;

@Controller
@RequestMapping("/guestbook")
public class GuestBookController {

	//
	@Autowired
	private GuestBookDao guestBookDao;
	
	// 입력 페이지
	@GetMapping("/insert")
	public String insert() {
//		return "입력 페이지";
//		return "/WEB-INF/views/guestbook/insert.jsp";
		return "guestbook/insert";
	}

	// 
	@PostMapping("/insert")
	public String insert(@ModelAttribute GuestBookDto guestBookDto) {
		guestBookDao.insert(guestBookDto);
		// 상대 경로
		return "redirect:insert_success";
		
		// 절대 경로
		//return "redirect:/guestBook/insert_success";
	}

	@GetMapping("/insert_success")
	public String insertSuccess() {
//		return "완료 페이지";
//		return "/WEB-INF/views/guestbook/insertSuccess.jsp";
		return "guestbook/insertSuccess";
	}
	
	@GetMapping("/list")
	public String list(
						Model model, 
						@RequestParam(required = false) String type, 
						@RequestParam(required = false) String keyword) {
		boolean isSearch = type != null && keyword != null;
		if(isSearch) {
			model.addAttribute("list", guestBookDao.selectList(type, keyword));
		}
		else {
			model.addAttribute("list", guestBookDao.selectList());
		}
		return "guestbook/list";
	}
}
