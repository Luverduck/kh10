package com.kh.springhome.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.springhome.repository.MusicDao;
import com.kh.springhome.repository.PocketMonsterDao;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private PocketMonsterDao pocketMonsterDao;
	
	@Autowired
	private MusicDao musicDao;
	
	@GetMapping("/home")
	public String home() {
		return "admin/home";
	}
	
	@GetMapping("/pocketmon")
	public String pocketmon(Model model) {
		model.addAttribute("list", pocketMonsterDao.selectCountList());
		return "admin/pocketmon";
	}
	
	@GetMapping("/music/play")
	public String musicPlay(Model model) {
		model.addAttribute("list", musicDao.selectTopten());
		return "admin/musicTopTen";
	}
	
	@GetMapping("/music/release")
	public String musicRelease(Model model) {
		model.addAttribute("list", musicDao.selectCountList());
		return "admin/musicReleaseTime";
	}
}
