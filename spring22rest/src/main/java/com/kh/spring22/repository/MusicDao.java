package com.kh.spring22.repository;

import java.util.List;

import com.kh.spring22.entity.MusicDto;

public interface MusicDao {

	// 추상 메소드 - 조회
	List<MusicDto> list();
	
	// 추상 메소드 - 단일 조회
	MusicDto find(int musicNo);
	
	// 추상 메소드 - 등록
	void insert(MusicDto musicDto);
	
	// 추상 메소드 - 수정
	boolean edit(MusicDto musicDto);
	
	// 추상 메소드 - 삭제
	boolean delete(int musicNo);
}
