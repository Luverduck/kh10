package com.kh.spring09.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.spring09.entity.GuestBookDto;
import com.kh.spring09.repository.GuestBookDao;

@Controller
public class GuestBookController {

	@Autowired
	private GuestBookDao guestBookDao;
	
	// 등록
	@RequestMapping("/insert")
	@ResponseBody
	public String insert(@ModelAttribute GuestBookDto dto) {
		guestBookDao.insert(dto);
		return "등록 완료!";
	}
	
	// 수정
	@RequestMapping("/update")
	@ResponseBody
	public String update(@ModelAttribute GuestBookDto dto) {
		// result가 0보다 큰지(boolean)을 반환하라고 했으므로
		boolean result = guestBookDao.update(dto);
		if(result) {
			return "변경 성공";
		}
		else {
			return "없는 번호";
		} 
	}
	
	// 삭제
	@RequestMapping("/delete")
	@ResponseBody
	public String delete(@RequestParam int no) {
		boolean result = guestBookDao.delete(no);
		// guestBookDao.delete(no)의 결과가 true이면
		if(result) {
			return "삭제 완료";
		}
		else {
			return "없는 번호";
		}
	}
	
	// 조회 : 목록 및 검색 기능
	@RequestMapping("/list")
	@ResponseBody
	public String list(@RequestParam(required = false) String type,
						@RequestParam(required = false) String keyword) {
		// 타입(type)도 있고(!=null) 검색어(keyword)도 있으면(!=null) 검색으로 본다
		boolean search = type != null && keyword != null;
		List<GuestBookDto> list;
		if(search) {
			// 검색
			list = guestBookDao.selectList(type, keyword);
		}
		else {
			// 목록 (select *)
			list = guestBookDao.selectList();
		}
		
		return list.toString();
	}
	
	// 상세 조회
	@RequestMapping("/detail")
	@ResponseBody
	public String detail(@RequestParam int no) {
		GuestBookDto dto = guestBookDao.selectOne(no);
		if(dto == null) {
			return "없는 번호";
		}
		else {
			return dto.toString();
		}
	}
}
