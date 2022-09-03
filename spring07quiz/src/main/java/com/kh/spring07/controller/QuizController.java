package com.kh.spring07.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.spring07.entity.GuestBookDto;

@Controller
@RequestMapping("/guest-book")
public class QuizController {
	
	// jdbcTemplate
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	// 1. 등록(/insert)
	@RequestMapping("/insert")
	@ResponseBody
	public String insert(@ModelAttribute GuestBookDto guestBookDto) {
		// 참고 : @ModelAttribute는 객체의 필드에 자동 매핑을 수행한다
		String sql = "insert into guest_book(no, name, memo) values(guest_book_seq.nextval, ?, ?)";
		Object[] param = new Object[] {guestBookDto.getName(), guestBookDto.getMemo()};
		int result = jdbcTemplate.update(sql, param);
		if(result > 0) {
			return "등록 완료";
		}
		else {
			return "올바른 정보를 입력해주세요";
		}
	}
	
	/*
	@RequestMapping("/insert")
	@ResponseBody
	//public String insert(@RequestParam int no, @RequestParam String name, @RequestParam String memo) {
		String sql = "insert into guest_book(no, name, memo) values(?, ?, ?)";
		Object[] param = new Object[] {no, name, memo};
		int result = jdbcTemplate.update(sql, param);
		if(result > 0) {
			return "등록 완료";
		}
		else {
			return "올바른 정보를 입력해주세요";
		}
	}
	*/
	
	// 2. 조회(/list)
	@RequestMapping("/list")
	@ResponseBody
	public String list() {
		String sql = "select * from guest_book order by no asc";
		List<GuestBookDto> list = jdbcTemplate.query(sql, GuestBookDto.getMapper());
		StringBuffer buffer = new StringBuffer();
		for(GuestBookDto guestBookDto : list) {
			buffer.append(guestBookDto);
			buffer.append("<br>");
		}
		return buffer.toString();
	}
		
	// 3. 검색(/search) 
	// - 사용자가 원하는 항목을 type이라는 이름으로 전송하면 해당 항목을 검색
	// - type(제목만, 내용만 등..), keyword(검색어)
	@RequestMapping("/search4")
	@ResponseBody
	public String search(@RequestParam String type, @RequestParam String keyword) {
		
		String sql = "select * from guest_book where instr(#1, ?) > 0 order by no asc";
		sql = sql.replace("#1", type);
		// #1은 오라클에서 나올 수 없는 문자
		
		Object[] param = new Object[] {keyword};
		
		List<GuestBookDto> list = jdbcTemplate.query(sql, GuestBookDto.getMapper(), param);
		
		StringBuffer buffer = new StringBuffer();
		for(GuestBookDto guestBookDto : list) {
			buffer.append(guestBookDto);
			buffer.append("<br>");
		}
		return buffer.toString();
	}
	
	/*
	@RequestMapping("/search3")
	@ResponseBody
	public String search(@RequestParam String type, @RequestParam String keyword) {
		
		String sql = "select * from guest_book where instr(" + type + ", ?) > 0 order by no asc";
		
		
		Object[] param = new Object[] {keyword};
		
		List<GuestBookDto> list = jdbcTemplate.query(sql, GuestBookDto.getMapper(), param);
		
		StringBuffer buffer = new StringBuffer();
		for(GuestBookDto guestBookDto : list) {
			buffer.append(guestBookDto);
			buffer.append("<br>");
		}
		return buffer.toString();
	}
	*/
	
	/*
	@RequestMapping("/search2")
	@ResponseBody
	public String search(@RequestParam String type, @RequestParam String keyword) {
		
		String sql;	// 상황에 따라 다른 SQL문을 적용
		if(type.equals("name")) {
			sql = "select * from guest_book where instr(name, ?) > 0 order by no asc";
		}
		else {
			sql = "select * from guest_book where instr(memo, ?) > 0 order by no asc";
		}
		
		Object[] param = new Object[] {keyword};
		
		List<GuestBookDto> list = jdbcTemplate.query(sql, GuestBookDto.getMapper(), param);
		
		StringBuffer buffer = new StringBuffer();
		for(GuestBookDto guestBookDto : list) {
			buffer.append(guestBookDto);
			buffer.append("<br>");
		}
		return buffer.toString();
	}
	*/
	
	// 중복 코드가 심함
	/*
	@RequestMapping("/search1")
	@ResponseBody
	public String search(@RequestParam String type, @RequestParam String keyword) {
		if(type.equals("name")){
			String sql = "select * from guest_book where instr(name, ?) > 0 order by no asc";
			Object[] param = new Object[] {keyword};
			
			List<GuestBookDto> list = jdbcTemplate.query(sql, GuestBookDto.getMapper(), param);
			
			StringBuffer buffer = new StringBuffer();
			for(GuestBookDto guestBookDto : list) {
				buffer.append(guestBookDto);
				buffer.append("<br>");
			}
			return buffer.toString();
			
		}
		else if(type.equals("memo")) {
			String sql = "select * from guest_book where instr(memo, ?) > 0 order by no asc";
			Object[] param = new Object[] {keyword};
			
			List<GuestBookDto> list = jdbcTemplate.query(sql, GuestBookDto.getMapper(), param);
			
			StringBuffer buffer = new StringBuffer();
			for(GuestBookDto guestBookDto : list) {
				buffer.append(guestBookDto);
				buffer.append("<br>");
			}
			return buffer.toString();
		}
		else {
			return "잘못된 검색";
		}
	}
	*/
	
	/*
	@RequestMapping("/search")
	@ResponseBody
	public String search(@RequestParam String keyword) {
		String sql = "select * from guest_book where instr(name, ?) > 0 or instr(memo, ?) > 0";
		Object[] param = new Object[] {keyword, keyword};
		List<GuestBookDto> list = jdbcTemplate.query(sql, GuestBookDto.getMapper(), param);
		StringBuffer buffer = new StringBuffer();
		for(GuestBookDto guestBookDto : list) {
			buffer.append(guestBookDto);
			buffer.append("<br>");
		}
		return buffer.toString();
	}
	*/
	
	// 4. 상세(/detail)
	@RequestMapping("/detail")
	@ResponseBody
	public String detail(@RequestParam int no) {
		String sql = "select * from guest_book where no = ?";
		Object[] param = new Object[] {no};
		GuestBookDto guestBookDto = jdbcTemplate.query(sql, GuestBookDto.getExtractor(), param);
		if(guestBookDto != null) {
			return guestBookDto.toString();
		}
		else {
			return "없는 번호";
		}
	}
		
	// 5. 수정(/update)
	@RequestMapping("/update")
	@ResponseBody
	public String update(@ModelAttribute GuestBookDto guestBookDto) {
		String sql = "update guest_book set name = ?, memo = ? where no = ?";
		Object[] param = new Object[] {guestBookDto.getName(), guestBookDto.getMemo(), guestBookDto.getNo()};
		int result = jdbcTemplate.update(sql, param);
		if(result > 0) {
			return "수정 성공";
		}
		else {
			return "존재하지 않는 번호";
		}
	}
	
	/*
	@RequestMapping("/update")
	@ResponseBody
	public String update(@RequestParam int no) {
		String sql = "update guest_book set name = ?, memo = ? where no = ?";
		Object[] param = new Object[] {no};
		int result = jdbcTemplate.update(sql, param);
		if(result > 0) {
			return "수정 완료";
		}
		else {
			return "없는 번호";
		}
	}
	*/
		
	// 6. 삭제(/delete)
	@RequestMapping("/delete")
	@ResponseBody
	public String delete(@RequestParam int no) {	// 입력이 1개이므로 @RequestParam가 유리하다 <-> @ModelAttribute도 가능하긴 함
		String sql = "delete guest_book where no = ?";
		Object[] param = new Object[] {no};
		int result = jdbcTemplate.update(sql, param);
		if(result > 0) {
			return "삭제 완료";
		}
		else {
			return "없는 번호";
		}
	}
}
