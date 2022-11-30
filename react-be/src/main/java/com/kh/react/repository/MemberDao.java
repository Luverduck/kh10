package com.kh.react.repository;

import com.kh.react.entity.MemberDto;

public interface MemberDao {

	// 추상 메소드 - 회원 단일 조회
	MemberDto login(MemberDto memberDto);
}
