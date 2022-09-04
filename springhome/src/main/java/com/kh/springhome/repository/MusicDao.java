package com.kh.springhome.repository;

import com.kh.springhome.entity.MusicDto;

public interface MusicDao {

	// DAO의 추상 메소드
	void insert(MusicDto musicDto);
}
