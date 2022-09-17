package com.kh.springhome.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.springhome.entity.BoardDto;
import com.kh.springhome.repository.BoardDao;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardDao boardDao;
	
	// 1. 게시글 작성 
	@GetMapping("/write")
	public String write() {		
//		return "/WEB-INF/views/board/write.jsp";
		return "board/write";
	}
	
	@PostMapping("/write")
	public String write(HttpSession session, @RequestParam String boardTitle, @RequestParam String boardContent, @RequestParam String boardHead) {
		String boardWriter = (String)session.getAttribute("loginId");
		boardDao.write(boardWriter, boardTitle, boardContent, boardHead);
		return "redirect:write_success";
	}
	
	@GetMapping("/write_success")
	public String writeSuccess() {
		return "redirect:list";
	}
	
	// 2. 게시글 수정
	// 1) 수정 페이지 Mapping
	@GetMapping("/edit")
	public String edit(Model model, @RequestParam int boardNo) {
		model.addAttribute("boardDto", boardDao.selectOne(boardNo));
		return "board/edit";
	}
	
	// 2) 수정 Mapping에 DTO 전달 및 DB 처리 
	@PostMapping("/edit")
	public String edit(@ModelAttribute BoardDto boardDto, RedirectAttributes attr) {
		boardDao.update(boardDto);
		attr.addAttribute("boardNo", boardDto.getBoardNo());
		return "redirect:detail";
	}
	
	/*
	@PostMapping("/edit")
	public String edit(@ModelAttribute BoardDto boardDto, RedirectAttributes attr) {
		boolean result = boardDao.update(boardDto);
		try {
			if(result) {
				attr.addAttribute("boardNo", boardDto.getBoardNo());
				return "redirect:detail";
			}
			else {
				throw new Exception();
			}
		}
		catch(Exception e) {
			return "redirect:edit?bookNo=" + boardDto.getBoardNo();
		}
	}
	*/
	
	// 3. 게시글 삭제
	@GetMapping("/delete")
	public String delete(@RequestParam int boardNo) {
		boardDao.delete(boardNo);
		return "redirect:list";
	}
		
	// 4. 게시글 목록
	// - 전체 목록 / 검색 목록
	@GetMapping("/list")
	public String selectList(Model model, @RequestParam(required = false) String type, @RequestParam(required = false) String keyword) {
		// 목록 판정 - 검색 목록을 표시할 것인지 true/false
		boolean searchTF = type != null && keyword != null;
		if(searchTF) {	// 검색 목록이라면
			model.addAttribute("list", boardDao.selectList(type, keyword));
		}
		else {	// 검색 목록이 아니라면 (전체 목록이라면)
			model.addAttribute("list", boardDao.selectList());
		}
		return "board/list";
	}
	
	// 5. 게시글 상세
	@GetMapping("/detail")
	public String selectOne(Model model, @RequestParam int boardNo) {
		boardDao.readCount(boardNo);
		model.addAttribute("boardDto", boardDao.selectOne(boardNo));
		return "board/detail";
	}
}
