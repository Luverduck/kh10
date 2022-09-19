package com.kh.springhome.repository;

import java.util.List;

import com.kh.springhome.entity.BoardDto;
import com.kh.springhome.entity.BoardListSearchVO;
import com.kh.springhome.entity.CurrentBoardNoVO;

public interface BoardDao {
/*	현재 시퀀스로 게시글 등록을 할 경우 동시에 게시글 등록을 할 때 문제가 생길 수 있다
	// 1. 추상 메소드 - 게시글 작성
	void write(String boardWriter, String boardTitle, String boardContent, String boardHead);
	
	// 1-1. 추상 메소드 - 현재 게시글 번호
	CurrentBoardNoVO currentNo();
*/	
	// 1-2. 추상 메소드 - 다음 시퀀스 번호를 뽑아서 게시글 작성
	int write(BoardDto boardDto);
		
	
	// 2. 추상 메소드 - 게시글 수정
	boolean update(BoardDto boardDto);
	
	// 3. 추상 메소드 - 게시글 삭제
	boolean delete(int boardNo);
	
	// 4. 추상 메소드 - 게시글 목록
	// - 전체 목록
	List<BoardDto> selectList();
	// - 검색 목록
	//List<BoardDto> selectList(String type, String keyword);
	List<BoardDto> selectList(BoardListSearchVO vo);
	
	// 5. 추상 메소드 - 게시글 상세
	BoardDto selectOne(int boardNo);
	
	// 5-1. 추상 메소드 - 조회수 증가
	void readCount(int boardNo);
	
	// #. 추상 메소드 - DB 전부 삭제 (TEST용)
	void clear();
}
