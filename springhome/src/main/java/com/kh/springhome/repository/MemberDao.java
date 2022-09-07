package com.kh.springhome.repository;

import java.util.List;

import com.kh.springhome.entity.MemberDto;

public interface MemberDao {

	// MemberDao의 추상 메소드 (입력 메소드)
	void insert(MemberDto memberDto);
	
	// MemberDao의 추상 메소드 (조회 메소드)
	List<MemberDto> selectList();
	List<MemberDto> selectList(String type, String keyword);
	
	// MemberDao의 추상 메소드 (상세 조회 메소드)
	MemberDto selectOne(String memberId);
	
	// MemberDao의 추상 메소드 (수정 메소드)
	boolean update(MemberDto memberDto);
}
