package com.kh.springhome.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	
	// 상세 조회
	@GetMapping("/detail")
	public String detail(Model model, @RequestParam int no) {
		GuestBookDto guestBookDto = guestBookDao.detail(no);
		model.addAttribute("guestBookDto", guestBookDto);
		return "guestbook/detail";
	}
	
	// 수정	
	@GetMapping("/edit")
	public String edit(Model model, @RequestParam int no) {
		model.addAttribute("guestBookDto", guestBookDao.detail(no));
//		return "/WEB-INF/views/guestbook/edit.jsp";
		return "guestbook/edit";
	};
	
	@PostMapping("/edit")
	public String edit(
						@ModelAttribute GuestBookDto guestBookDto, 
						RedirectAttributes attr	// redirect 전용 저장소(Model의 자식 클래스)
						) {
		boolean result = guestBookDao.update(guestBookDto);
		if(result) {
//			return "redirect:detail?no=" + guestBookDto.getNo();	// 비추천(직접 작성)
			attr.addAttribute("no", guestBookDto.getNo());			// 추천(Spring 도구 활용)
			return "redirect:detail";
		}
		else {
			return "redirect:edit_fail";
		}
	}
	
	// 수정 실패시
	@GetMapping("/edit_fail")
	public String editFail() {
//		return "/WEB-INF/views/guestbook/editFail";
		return "guestbook/editFail";
	}
	
	// 삭제
	@GetMapping("/delete")
	public String delete(@RequestParam int no) {
		boolean result = guestBookDao.delete(no);
		if(result) {
			return "redirect:list";
		}
		else {
//			return "/WEB-INF/views/pocketmon/editFail.jsp";
			return "redirect/editFail";
		}
	}
}
