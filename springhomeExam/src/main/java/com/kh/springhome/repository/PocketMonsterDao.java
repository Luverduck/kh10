package com.kh.springhome.repository;

import java.util.List;

import com.kh.springhome.entity.PocketMonsterDto;

public interface PocketMonsterDao {

	// 등록
	void insert(PocketMonsterDto pocketMonsterDto);

	// 조회
	List<PocketMonsterDto> selectList();

	// 상세조회
	PocketMonsterDto selectOne(int no);

	// 수정
	boolean update(PocketMonsterDto dto);
	
	// 삭제
	boolean delete(int no);
}
