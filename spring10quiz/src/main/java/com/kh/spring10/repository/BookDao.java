package com.kh.spring10.repository;

import java.util.List;

import com.kh.spring10.entity.BookDto;

public interface BookDao {

	// 1. 등록(insert)
	boolean insert(BookDto bookDto);
	
	// 2. 수정(update)
	boolean update(BookDto bookDto);
	
	// 3. 삭제(delete)
	boolean delete(int bookSerial);
	
	// 4. 조회(select)
	// - List에 포함된 BookDto 객체를 모두 조회
	List<BookDto> selectList();
	List<BookDto> selectList(String type, String keyword);
	
	// 5. 상세 조회
	// - BookDto 객체 하나만 조회
	BookDto selectOne(int bookSerial);
}
