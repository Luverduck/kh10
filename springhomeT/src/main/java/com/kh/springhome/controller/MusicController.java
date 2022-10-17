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
	
	@GetMapping("/insert")
	public String insert() {
//		return "/WEB-INF/views/music/insert.jsp";
		return "music/insert";
	}
	@PostMapping("/insert")
	public String insert(@ModelAttribute MusicDto musicDto) {
		musicDao.insert(musicDto);
		return "redirect:insert_success";
	}
	@GetMapping("/insert_success")
	public String insertSuccess() {
//		return "/WEB-INF/views/music/insertSuccess.jsp";
		return "music/insertSuccess";
	}
	
	@RequestMapping("/list")
	public String list(Model model,
			@RequestParam(required = false) String type, 
			@RequestParam(required = false) String keyword) {
		boolean isSearch = type != null && keyword  != null;
		if(isSearch) {
			model.addAttribute("list", musicDao.selectList(type, keyword));
		}
		else {
			model.addAttribute("list", musicDao.selectList());
		}
		return "music/list";
	}
	
	@GetMapping("/detail")
	public String detail(Model model, @RequestParam int musicNo) {
		MusicDto musicDto = musicDao.selectOne(musicNo);
		model.addAttribute("musicDto", musicDto);
//		return "/WEB-INF/views/music/detail.jsp";
		return "music/detail";
	}
	
//	수정 기능
	@GetMapping("/edit")
	public String edit(Model model, @RequestParam int musicNo) {
		model.addAttribute("musicDto", musicDao.selectOne(musicNo));
		return "music/edit";
	}
	
	@PostMapping("/edit")
	public String edit(@ModelAttribute MusicDto musicDto,
									RedirectAttributes attr) {
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
//		return "/WEB-INF/views/guestbook/editFail.jsp";
		return "guestbook/editFail";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam int musicNo) {
		boolean result = musicDao.delete(musicNo);
		if(result) {
			return "redirect:list";
		}
		else {
			return "guestbook/editFail";
		}
	}
}








