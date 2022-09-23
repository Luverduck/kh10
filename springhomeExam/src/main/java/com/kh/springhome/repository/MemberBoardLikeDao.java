package com.kh.springhome.repository;

import com.kh.springhome.entity.MemberBoardLikeDto;

public interface MemberBoardLikeDao {

	// 추상 메소드 - 좋아요 등록
	void insert(MemberBoardLikeDto dto);
	
	// 추상 메소드 - 좋아요 삭제
	void delete(MemberBoardLikeDto dto);
//	MemberBoardLikeDto selectOne(MemberBoardLikeDto dto);
	
	// 추상 메소드 - 좋아요 여부 조회
	boolean check(MemberBoardLikeDto dto);
	
	// 추상 메소드 - 좋아요 여부
	int count(int boardNo);
	
	// 추상 메소드 - 좋아요 총 갯수 갱신
	void refresh(int boardNo);
}
