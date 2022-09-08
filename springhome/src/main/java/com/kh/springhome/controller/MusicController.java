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

import com.kh.springhome.entity.MusicDto;
import com.kh.springhome.repository.MusicDao;

@Controller
@RequestMapping("/music")
public class MusicController {

	@Autowired
	private MusicDao musicDao;
	
	// 1) 등록(insert) 페이지로 연결
	@GetMapping("/insert")
	public String insert() {
//		return "/WEB-INF/views/music/insert.jsp";
		return "music/insert";
	}
	
	// 2) 등록 처리 후 등록 성공 페이지로 연결
	@PostMapping("/insert")
	public String insert(@ModelAttribute MusicDto musicDto) {
		musicDao.insert(musicDto);
// 		insert_success 주소로 redirect 하기 (새로고침 시 데이터를 중복 입력하는 것을 방지)
		return "redirect:insert_success";
	}
	
	// 3) 등록 성공 페이지 (insertSuccess)
	@GetMapping("/insert_success")
	public String insertSuccess() {
//		return "/WEB-INF/views/music/insertSuccess";
		return "music/insertSuccess";
	}
	
	// 조회 (select)
	@GetMapping("/list")
	public String list(
						Model model, 
						@RequestParam(required = false) String type, 
						@RequestParam(required = false) String keyword) {
		boolean isSearch = type != null && keyword != null;
		if(isSearch) {
			model.addAttribute("list", musicDao.selectList(type, keyword));
		}
		else {
			model.addAttribute("list", musicDao.selectList());
		}
		return "music/list";
	}
	
	// 상세 조회 (detail)
	@GetMapping("/detail")
	public String detail(Model model, @RequestParam int musicNo) {
		model.addAttribute("musicDto", musicDao.selectOne(musicNo));
		return "music/detail";
	}
	
	// 수정 (update)
	@GetMapping("/edit")
	public String edit(Model model, @RequestParam int musicNo) {
		model.addAttribute("musicDto", musicDao.selectOne(musicNo));
		return "music/edit";
	}
	
	@PostMapping("/edit")
	public String edit(@ModelAttribute MusicDto musicDto, RedirectAttributes attr) {
		boolean result = musicDao.update(musicDto);
		if(result) {
//			return "redirect:detail?musicNo="+musicDto.getMusicNo();
			attr.addAttribute("musicNo", musicDto.getMusicNo());
			return "redirect:detail";
		}
		else {
			return "redirect:edit_fail";
		}
	}
	
	@GetMapping("/edit_fail")
	public String editFail() {
//		다른 폴더의 view를 사용할 수도 있따
//		return "guestbook/editFail";
		return "music/editFail";
	}
	
	// 삭제
	@GetMapping("/delete")
	public String delete(@RequestParam int musicNo) {
		if(musicDao.delte(musicNo)) {
			return "redirect:list";
		}
		else {
			return "music/editFail";
		}
	}
}
