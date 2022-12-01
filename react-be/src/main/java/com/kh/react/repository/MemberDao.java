package com.kh.react.repository;

import com.kh.react.entity.MemberDto;

public interface MemberDao {

	// 추상 메소드 - 회원 조회
	MemberDto login(MemberDto memberDto);
	
	// 추상 메소드 - 회원 아이디로 단일 조회
	MemberDto get(String memberId);
}
