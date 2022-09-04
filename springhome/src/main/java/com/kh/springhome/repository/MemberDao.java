package com.kh.springhome.repository;

import com.kh.springhome.entity.MemberDto;

public interface MemberDao {

	// MemberDao의 추상 메소드 (입력 메소드)
	void insert(MemberDto memberDto);
}
