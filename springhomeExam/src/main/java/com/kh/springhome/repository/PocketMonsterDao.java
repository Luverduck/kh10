package com.kh.springhome.repository;

import java.util.List;

import com.kh.springhome.entity.PocketMonsterDto;
import com.kh.springhome.vo.PocketMonsterCountVO;

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
	
	//
	List<PocketMonsterCountVO> selectCountList();
	
	// 추상 메소드 - 최근에 등록된 포켓몬
	List<PocketMonsterDto> pocketmonLatest();
	
	List<PocketMonsterDto> pocketmonLatest(Integer pocketmonEnd);
}
