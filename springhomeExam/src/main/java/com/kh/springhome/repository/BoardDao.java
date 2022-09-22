package com.kh.springhome.repository;

import java.util.List;

import com.kh.springhome.entity.BoardDto;
import com.kh.springhome.vo.BoardListSearchVO;

public interface BoardDao {

	// 1-1. 추상 메소드 - 시퀀스 번호 반환 메소드
	int sequence();
	
	// 1. 추상 메소드 - 게시글 작성 : 시퀀스 번호를 대입하여 등록하는 메소드
	void write(BoardDto boardDto);
	
	// 2. 추상 메소드 - 게시글 수정
	boolean update(BoardDto boardDto);
	
	// 3. 추상 메소드 - 게시글 삭제
	boolean delete(int boardNo);
	
	// 4. 추상 메소드 - 게시글 목록
	// - 전체 목록
	List<BoardDto> selectList();
	// - 검색 목록
	//List<BoardDto> selectList(String type, String keyword);
	
	// 4-1. 통합 검색 메소드
	List<BoardDto> selectList(BoardListSearchVO vo);
	List<BoardDto> list(BoardListSearchVO vo);
	List<BoardDto> search(BoardListSearchVO vo);
	
	// 검색과 목록의 총 데이터 개수를 구하는 메소드
	int count(BoardListSearchVO vo);
	int searchCount(BoardListSearchVO vo);
	int listCount(BoardListSearchVO vo);
	
	// 5. 추상 메소드 - 게시글 상세
	BoardDto selectOne(int boardNo);
	
	// #. 추상 메소드 - 조회수 증가
	boolean updateReadcount(int boardNo);
	
	// 5-1. 추상 메소드 - 게시글 상세 + 조회수 증가
	BoardDto read(int boardNo);
	
	// #. 추상 메소드 - DB 전부 삭제 (TEST용)
	void clear();
}
