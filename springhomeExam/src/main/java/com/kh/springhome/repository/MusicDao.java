package com.kh.springhome.repository;

import java.util.List;

import com.kh.springhome.entity.MusicDto;
import com.kh.springhome.vo.MusicYearCountVO;

public interface MusicDao {

	// DAO의 추상 메소드 - 등록(insert)
	void insert(MusicDto musicDto);
	
	// DAO의 추상 메소드 - 조회(selectList)
	List<MusicDto> selectList();
	List<MusicDto> selectList(String type, String keyword);
	
	// Dao의 추상 메소드 - 상세 조회(detail)
	MusicDto selectOne(int musicNo);
	
	// Dao의 추상 메소드 - 수정(update)
	boolean update(MusicDto musicDto);
	
	// Dao의 추상 메소드 - 삭제(delete)
	boolean delte(int musicNo);
	
	// Dao의 추상 메소드 - Top 10
	List<MusicDto> selectTopTen();
	
	// Dao의 추상 메소드 - Top N
	List<MusicDto> selectTopN(int limit);
	
	// Dao의 추상 메소드 - Top N to N
	List<MusicDto> selectTopNtoN(int begin, int end);
	
	// Dao의 추상 메소드 - 연도별 발매수
	List<MusicYearCountVO> releaseByYear();
	
	// Dao의 추상 메소드 - 연도별 발매수 + 순위
	List<MusicYearCountVO> releaseByYearWithRank();
}
