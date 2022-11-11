package com.kh.spring21.repository;

import com.kh.spring21.entity.SecomDto;

public interface SecomDao {

	// 추상 메소드 - 회원 가입
	void join(SecomDto secomDto);
	
	// 추상 메소드 - 단일 조회
	SecomDto find(String id);
	
	// 추상 메소드 - 로그인
	boolean login(SecomDto secomDto);
}
