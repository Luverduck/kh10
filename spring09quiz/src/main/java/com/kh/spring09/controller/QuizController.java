package com.kh.spring09.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.spring09.entity.BookDto;

@Controller
@RequestMapping("/book")
public class QuizController {

	// jdbcTemplate
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	// 1. 등록(/insert)
	@RequestMapping("/insert")
	@ResponseBody
	public String insert(@ModelAttribute BookDto bookDto) {
		String sql = "insert into book(book_serial, book_name, book_writer, book_publisher, book_price, book_genre, creation_time) values(book_seq.nextval, ?, ?, ?, ?, ?, sysdate)";
		Object[] param = new Object[] {bookDto.getBookName(), bookDto.getBookWriter(), bookDto.getBookPublisher(), bookDto.getBookPrice(), bookDto.getBookGenre()};
		int result = jdbcTemplate.update(sql, param);
		if(result > 0) {
			return "등록 성공";
		}
		else {
			return "올바른 정보를 입력해주세요";
		}
	}
	
	// 2. 조회(/list)
	@RequestMapping("/list")
	@ResponseBody
	public String list() {
		String sql = "select * from book order by book_serial asc";
		List<BookDto> list = jdbcTemplate.query(sql, BookDto.getMapper());
		StringBuffer buffer = new StringBuffer();
		for(BookDto bookDto : list) {
			buffer.append(bookDto);
			buffer.append("<br>");
		}
		return buffer.toString();
	}
		
	// 3. 검색(/search)
	@RequestMapping("/search")
	@ResponseBody
	public String search(@RequestParam String type, @RequestParam String keyword) {
		String sql = "select * from book where instr(#1, ?) > 0 order by book_serial asc";
		sql = sql.replace("#1", type);
		Object[] param = new Object[] {keyword};
		List<BookDto> list = jdbcTemplate.query(sql, BookDto.getMapper(), param);
		StringBuffer buffer = new StringBuffer();
		for(BookDto bookDto : list) {
			buffer.append(bookDto);
			buffer.append("<br>");
		}
		return buffer.toString();
	}
		
	// 4. 상세(/detail)
	@RequestMapping("/detail")
	@ResponseBody
	public String detail(@RequestParam int bookSerial) {
		String sql = "select * from book where book_serial = ?";
		Object[] param = new Object[] {bookSerial};
		BookDto bookDto = jdbcTemplate.query(sql, BookDto.getExtractor(), param);
		if(bookDto != null) {
			return bookDto.toString();
		}
		else {
			return "없는 번호";
		}
	}
		
	// 5. 수정(/update)
	@RequestMapping("/update")
	@ResponseBody
	public String update(@ModelAttribute BookDto bookDto) {
		String sql = "update book set book_name = ?, book_writer = ?, book_publisher = ?, book_price = ?, book_genre = ? where book_serial = ?";
		Object[] param = new Object[] {bookDto.getBookName(), bookDto.getBookWriter(), bookDto.getBookPublisher(), bookDto.getBookPrice(), bookDto.getBookGenre(), bookDto.getBookSerial()};
		int result = jdbcTemplate.update(sql, param);
		if(result > 0) {
			return "수정 성공";
		}
		else {
			return "번호 없음";
		}
	}
		
	// 6. 삭제(/delete)
	@RequestMapping("/delete")
	@ResponseBody
	public String delete(@RequestParam int bookSerial) {
		String sql = "delete book where book_serial = ?";
		Object[] param = new Object[] {bookSerial};
		int result = jdbcTemplate.update(sql, param);
		if(result > 0) {
			return "삭제 성공";
		}
		else {
			return "번호 없음";
		}
	}
}
