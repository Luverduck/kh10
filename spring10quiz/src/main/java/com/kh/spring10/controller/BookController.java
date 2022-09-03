package com.kh.spring10.controller;

import java.util.List;
	
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.spring10.entity.BookDto;
import com.kh.spring10.repository.BookDao;


@Controller
@RequestMapping("/book")
public class BookController {
	
	// DAO 
	@Autowired
	private BookDao bookDao;
	
	// 1. 등록(insert)
	@RequestMapping("/insert")
	@ResponseBody
	public String insert(@ModelAttribute BookDto bookDto) {
		boolean result = bookDao.insert(bookDto);
		if(result) {
			return "등록 완료";
		}
		else {
			return "올바른 정보를 입력하세요";
		}
	}
	
	// 2. 수정(update)
	@RequestMapping("/update")
	@ResponseBody
	public String update(@ModelAttribute BookDto bookDto) {
		if(bookDao.update(bookDto)) {
			return "변경 완료";
		}
		else {
			return "없는 번호";
		}
		/*
		boolean result = bookDao.update(bookDto);
		if(result) {
			return "변경 완료";
		}
		else {
			return "없는 번호";
		}
		*/
	}
	
	// 3. 삭제(delete)
	@RequestMapping("/delete")
	@ResponseBody
	public String delete(@RequestParam int bookSerial) {
		if(bookDao.delete(bookSerial)) {
			return "삭제 성공";
		}
		else {
			return "없는 번호";
		}
		/*
		boolean result = bookDao.delete(bookSerial);
		if(result) {
			return "삭제 성공";
		}
		else {
			return "없는 번호";
		}
		*/
	}
	
	// @RequestParam : 반드시 있어야 한다(required = true)를 기본값으로 가짐
	// @ModelAttribute : 없어도 된다(required = false)를 기본값으로 가짐
			
	// 4. 조회(select)
	@RequestMapping("/list")
	@ResponseBody		// 검색어가 필수가 아니도록(required = false)
	public String list(@RequestParam(required = false) String type, @RequestParam(required = false) String keyword) {
		// 만약 검색이면(search = true) 해당 키워드가 포함된 항목 검색(search) or 검색이 아니면(search=false) 모든 항목 출력(list)
		boolean search = type != null && keyword != null;
		List<BookDto> list;
		if(search) {	// 검색이면
			list = bookDao.selectList(type, keyword);
		}
		else {			// 검색이 아니면(목록이면)
			list = bookDao.selectList();
		}
		return list.toString();
	}
			
	// 5. 상세 조회
	@RequestMapping("/detail")
	@ResponseBody
	public String detail(@RequestParam int bookSerial) {
		BookDto bookDto = bookDao.selectOne(bookSerial);
		if(bookDto == null) {
			return "없는 번호";
		}
		else {
			return bookDto.toString();
		}
	}
}
