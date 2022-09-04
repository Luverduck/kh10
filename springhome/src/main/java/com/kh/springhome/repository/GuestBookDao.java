package com.kh.springhome.repository;

import com.kh.springhome.entity.GuestBookDto;

public interface GuestBookDao {
 
	// 등록(insert)
	void insert(GuestBookDto guestBookDto);
}
