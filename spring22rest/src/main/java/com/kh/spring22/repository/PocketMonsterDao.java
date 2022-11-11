package com.kh.spring22.repository;

import java.util.List;

import com.kh.spring22.entity.PocketMonsterDto;

public interface PocketMonsterDao {

	// 추상 메소드 - 조회
	List<PocketMonsterDto> list();
	
	// 추상 메소드 - 단일 조회
	PocketMonsterDto find(int no);
	
	// 추상 메소드 - 등록
	void insert(PocketMonsterDto dto);
	
	// 추상 메소드 - 수정
	boolean edit(PocketMonsterDto dto);
	
	// 추상 메소드 - 삭제
	boolean delete(int no);
}
