package com.kh.spring09.repository;

import java.util.List;

import com.kh.spring09.entity.GuestBookDto;

// DAO(Data Access Object)의 목차(추상체)
public interface GuestBookDao {
	// 형태
	
	// 등록 기능의 형태를 작성 
	// 방법
	// 1) void insert(String name, String memo);
	// 2) void insert(GuestBookDto dto);		--> DTO를 사용하는 방식
	
	// 등록
	void insert(GuestBookDto dto);
	
	// 수정 -> 정보를 주면 수정이 되거나(true) 안되거나(false)
	boolean update(GuestBookDto dto);
	
	// 삭제
	boolean delete(int no);
	
	// 조회
	List<GuestBookDto> selectList();	// 목록 기능
	List<GuestBookDto> selectList(String type, String keyword);	// 검색 기능
	
	// 상세 조회 -> 3번 방명록 정보를 보여주세요 -> 방명록 1개 정보 (GuestBookDto)
	GuestBookDto selectOne(int no);
	
}
