package com.kh.spring16.repository;

import java.util.List;

import com.kh.spring16.entity.MusicDto;

public interface MusicDao {

	// 추상 메소드 - 등록(INSERT)
	public void insert(MusicDto musicDto);
	
	// 추상 메소드 - 전체 조회(SELECT)
	List<MusicDto> selectList();
	
	// 추상 메소드 - 단일 조회(SELECT)
	MusicDto selectOne(int musicNo);
	
	// 추상 메소드 - 수정(UPDATE)
	boolean edit(MusicDto musicDto);
	
	// 추상 메소드 - 삭제(DELETE)
	boolean delete(int musicNo);
}
