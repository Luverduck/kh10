package com.kh.springhome.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.springhome.entity.MemberDto;
import com.kh.springhome.repository.MemberDao;

@Controller
@RequestMapping("/member")
public class MemberController {

	@Autowired
	private MemberDao memberDao;
	
	@GetMapping("/insert")
	public String insert() {
//		return "/WEB-INF/views/member/insert";
		return "member/insert";
	}
	
	@PostMapping("/insert")
	public String insert(@ModelAttribute MemberDto memberDto) {
		memberDao.insert(memberDto);
//		insert_success 메핑으로 redirect(강제 이동)
		return "redirect:insert_success";
	}
	
	@GetMapping("/insert_success")
	public String insertSuccess() {
//		return "/WEB-INF/views/member/insertSuccess";
		return "member/insertSuccess";
	}
	
	@GetMapping("/list")
	public String SelectList(
								Model model, 
								@RequestParam(required = false) String type, 
								@RequestParam(required = false) String keyword) {
		boolean isSearch = type != null && keyword != null;
		if(isSearch) {
			model.addAttribute("list", memberDao.selectList(type, keyword));
		}
		else {
			model.addAttribute("list", memberDao.selectList());
		}
		// return "목록 페이지 주소";
		// return "/WEB-INF/views/member/list.jsp";
		return "member/list";
	}
}
