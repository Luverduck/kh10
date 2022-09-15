package com.kh.spring12.repository;

import com.kh.spring12.entity.PocketMonsterDto;

public interface PocketMonsterDao {

	// Dao의 추상 메소드 - 등록
	void insert(int no, String name, String type);
	void inser(PocketMonsterDto pocketMonsterDto);
}
