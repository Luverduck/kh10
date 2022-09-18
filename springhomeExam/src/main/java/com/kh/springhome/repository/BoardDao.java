package com.kh.springhome.repository;

import java.util.List;

import com.kh.springhome.entity.BoardDto;
import com.kh.springhome.entity.CurrentBoardNoVO;

public interface BoardDao {

	// 1. 추상 메소드 - 게시글 작성
	void write(String boardWriter, String boardTitle, String boardContent, String boardHead);
	
	// 1-1. 추상 메소드 - 현재 게시글 번호
	CurrentBoardNoVO currentNo();
	
	// 2. 추상 메소드 - 게시글 수정
	void update(BoardDto boardDto);
	
	// 3. 추상 메소드 - 게시글 삭제
	void delete(int boardNo);
	
	// 4. 추상 메소드 - 게시글 목록
	// - 전체 목록
	List<BoardDto> selectList();
	// - 검색 목록
	List<BoardDto> selectList(String type, String keyword);
	
	// 5. 추상 메소드 - 게시글 상세
	BoardDto selectOne(int boardNo);
	
	// 5-1. 추상 메소드 - 조회수 증가
	void readCount(int boardNo);
}
