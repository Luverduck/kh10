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

	@Autowired
	private GuestBookDao guestBookDao;
	
	// 1. 등록 (insert)
	// 1-1. 등록 Mapping
	@GetMapping("/insert")
	public String insert() {
		// 등록 페이지 (insert.jsp)로 연결
//		return "/WEB-INF/views/guestbook/insert.jsp";
		return "guestbook/insert";
	}

	// 1-2. 등록 Mapping에 DTO 전달 및 DB 처리
	// DB에서 등록(insert) 처리 후 등록 완료 Mapping으로 이동
	@PostMapping("/insert")
	public String insert(@ModelAttribute GuestBookDto guestBookDto) {
		// 1) DB에서 등록(insert) 실행
		guestBookDao.insert(guestBookDto);
		// 2) 등록 처리 후 등록 완료(insert_success) Mapping으로 강제이동(redirect) (새로고침 시 데이터 중복 입력하는 것을 방지)
//		return "redirect:/guestBook/insert_success";
		return "redirect:insert_success";
	}

	// 1-3. 등록 완료 Mapping
	@GetMapping("/insert_success")
	public String insertSuccess() {
		// 등록 완료 페이지(insertResult.jsp)로 연결
//		return "/WEB-INF/views/guestbook/insertSuccess.jsp";
		return "guestbook/insertSuccess";
	}
	
	// 2. 조회 (select) - isSearch가 true일 경우 검색어 조회. false일 경우 전체 조회
	// 조회 Mapping
	@GetMapping("/list")
	public String list(Model model, @RequestParam(required = false) String type, @RequestParam(required = false) String keyword) {
		// 조회 유형 판정
		boolean isSearch = type != null && keyword != null;
		// 1) Model의 변수명과 값 설정
		if(isSearch) {	// true일 경우 검색어 조회 selectList(String type, String keyword)의 결과값으로 설정
			model.addAttribute("list", guestBookDao.selectList(type, keyword));
		}
		else {	// false일 경우 전체 조회 selectList()의 결과값으로 설정
			model.addAttribute("list", guestBookDao.selectList());
		}
		// 2) Model을 view에 전달 (list.jsp에서 전달받은 Model을 표시할 형식을 정의) 
		return "guestbook/list";
	}
	
	// 2-1. 단일 조회 (detail)
	// 단일 조회 Mapping
	@GetMapping("/detail")
	public String detail(Model model, @RequestParam int no) {
		// 1) Model의 변수명과 값 설정 - 단일 조회 detail()의 결과값으로 설정
		model.addAttribute("guestBookDto", guestBookDao.detail(no));
		// 2) Model을 view에 전달 (detail.jsp에서 전달 받은 Model을 표시할 형식을 정의)
		return "guestbook/detail";
	}
	
	// 3. 수정 (update)
	// 3-1. 수정 Mapping
	@GetMapping("/edit")
	public String edit(Model model, @RequestParam int no) {
		// 1) Model의 변수명과 값 설정 - 단일조회 detail()의 결과값으로 설정
		model.addAttribute("guestBookDto", guestBookDao.detail(no));
		// 2) PostMapping으로 이동
		return "guestbook/edit";
	};
	
	// 3-2. 수정 Mapping에 DTO 전달 및 DB 처리 
	@PostMapping("/edit")
	public String edit(@ModelAttribute GuestBookDto guestBookDto, RedirectAttributes attr) {
		// 1) DB에서 수정(update) 실행 결과(boolean, 실행 결과가 0보다 큰지)를 반환
		boolean result = guestBookDao.update(guestBookDto);
		// 2) 수정(update) 처리 후 결과에 따라 서로 다른 Mapping으로 이동
		if(result) {	// true라면 해당 번호(no) 방명록의 단일 조회 Mapping으로 이동
			attr.addAttribute("no", guestBookDto.getNo());
			return "redirect:detail";
		}
		else {	// false라면 수정 실패(edit_fail) Mapping으로 이동
			return "redirect:edit_fail";
		}
	}
	
	// 3-3. 수정 실패 Mapping
	@GetMapping("/edit_fail")
	public String editFail() {
		// 수정 실패 페이지(editFail.jsp)으로 이동
//		return "/WEB-INF/views/guestbook/editFail";
		return "guestbook/editFail";
	}
	
	// 4. 삭제 (delete)
	// 삭제 Mapping
	@GetMapping("/delete")
	public String delete(@RequestParam int no) {
		// 1) DB에서 삭제(delete) 실행 결과(boolean, 실행 결과가 0보다 큰지)를 반환
		boolean result = guestBookDao.delete(no);
		// 2) 삭제(delete) 처리 후 결과에 따라 서로 다른 Mapping으로 이동
		if(result) {	// true라면 조회(list) Mapping으로 이동
			return "redirect:list";
		}
		else {	// false라면 수정 실패 Mapping으로 이동
//			return "/WEB-INF/views/pocketmon/editFail.jsp";
			return "redirect:edit_fail";
		}
	}
}
