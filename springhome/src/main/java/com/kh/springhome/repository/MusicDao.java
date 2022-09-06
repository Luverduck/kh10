package com.kh.springhome.repository;

import java.util.List;

import com.kh.springhome.entity.MusicDto;

public interface MusicDao {

	// DAO의 추상 메소드 - 등록(insert)
	void insert(MusicDto musicDto);
	
	// DAO의 추상 메소드 - 조회(selectList)
	List<MusicDto> selectList();
	List<MusicDto> selectList(String type, String keyword);
}
