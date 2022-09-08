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
	
	@GetMapping("/detail")
	public String detail(Model model, @RequestParam String memberId) {
		// 조회 결과(memberDto)
		MemberDto memberDto = memberDao.selectOne(memberId);
		// model.addAttribute("memberDto", 조회 결과);
		model.addAttribute("memberDto", memberDto);
		// return "/WEB-INF/views/member/detail.jsp";
		return "member/detail";
	}
	
	// 수정
	@GetMapping("/edit")
	public String edit(Model model, @RequestParam String memberId) {
		model.addAttribute("memberDto", memberDao.selectOne(memberId));
		return "member/edit";
	}
	
	@PostMapping("/edit")
	public String edit(@ModelAttribute MemberDto memberDto, RedirectAttributes attr) {
		if(memberDao.update(memberDto)) {
			attr.addAttribute("memberId", memberDto.getMemberId());
			return "redirect:detail";
		}
		else {
			return "redirect:edit_fail";
		}
	}
	
	@GetMapping("/edit_fail")
	public String editFail() {
		return "member/editFail";
	}
	
	// 삭제
	@GetMapping("/delete")
	public String delete(@RequestParam String memberId) {
		if(memberDao.delete(memberId)) {
			return "redirect:list";
		}
		else {
			return "member/editFail";
		}
	}
}
