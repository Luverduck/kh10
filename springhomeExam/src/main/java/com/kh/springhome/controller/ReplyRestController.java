package com.kh.springhome.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.springhome.entity.ReplyDto;
import com.kh.springhome.repository.ReplyDao;
import com.kh.springhome.vo.ReplyListVO;

@RestController
@RequestMapping("/rest/reply")
public class ReplyRestController {

	// 의존성 주입
	@Autowired
	private ReplyDao replyDao;
	
	// 등록(insert)
	//- 필요 정보를 받아서 등록한 뒤 사용자에게 목록을 전송
	@PostMapping("/insert")
	public List<ReplyListVO> insert(
			@ModelAttribute ReplyDto replyDto,
			HttpSession session) {
		String memberId = (String)session.getAttribute("loginId");
		replyDto.setReplyWriter(memberId);
		replyDao.replyWrite(replyDto);
		
		return replyDao.replyList(replyDto.getReplyOrigin());
	}
	
	//삭제(delete)
	@PostMapping("/delete")
	public List<ReplyListVO> delete(@ModelAttribute ReplyDto replyDto) {
		replyDao.replyDelete(replyDto.getReplyNo());
		return replyDao.replyList(replyDto.getReplyOrigin());
	}
}
