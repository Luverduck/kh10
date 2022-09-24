package com.kh.springhome.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.springhome.repository.BoardDao;
import com.kh.springhome.repository.GuestBookDao;
import com.kh.springhome.repository.MemberDao;
import com.kh.springhome.repository.MusicDao;
import com.kh.springhome.repository.PocketMonsterDao;

@Controller
// 공용 주소를 부여하지 않고 첫 페이지를 처리하도록 설정
public class HomeController {
	
	@Autowired
	private BoardDao boardDao;
	
	@Autowired
	private GuestBookDao guestBookDao;
	
	@Autowired
	private PocketMonsterDao pocketMonsterDao;
	
	@Autowired
	private MusicDao musicDao;
	
	@Autowired
	private MemberDao memberDao;

	@RequestMapping("/")
	public String home(Model model) {

		model.addAttribute("boardList", boardDao.boardLatest());
		
		model.addAttribute("guestBookList", guestBookDao.guestBookLatest());
		
		model.addAttribute("pocketMonsterList", pocketMonsterDao.pocketmonLatest());
		
		model.addAttribute("musicList", musicDao.musicLatest());
		
		model.addAttribute("memberList", memberDao.writeCount());
		
		return "home";
	}
}
