package com.kh.springhome.repository;

import java.util.List;

import com.kh.springhome.entity.GuestBookDto;

public interface GuestBookDao {
 
	// 등록(insert)
	void insert(GuestBookDto guestBookDto);
	
	// 조회(select)
	List<GuestBookDto> selectList();
	List<GuestBookDto> selectList(String type, String keyword);
	
	// 상세 조회(detail)
	GuestBookDto detail(int no);
	
	// 수정 (update)
	boolean update(GuestBookDto guestBookDto);
}
