package com.kh.spring16.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.kh.spring16.entity.MusicDto;

public class MusicDaoImpl implements MusicDao {

	// 의존성 주입
	@Autowired
	private SqlSession sqlSession;
	
	// 추상 메소드 오버라이딩 - 등록(INSERT)
	@Override
	public void insert(MusicDto musicDto) {
		// music의 insert(등록) 실행
		sqlSession.insert("music.insert", musicDto);
	}

	// 추상 메소드 오버라이딩 - 전체 조회(SELECT)
	@Override
	public List<MusicDto> selectList() {
		// music의 list(전체 조회) 실행
		return sqlSession.selectList("music.list");
	}

	// 추상 메소드 오버라이딩 - 단일 조회(SELECT)
	@Override
	public MusicDto selectOne(int musicNo) {
		// music의 one(단일 조회) 실행
		return sqlSession.selectOne("music.one", musicNo);
	}

	// 추상 메소드 오버라이딩 - 수정(UPDATE)
	@Override
	public boolean edit(MusicDto musicDto) {
		// music의 update(수정) 실행
		int count = sqlSession.update("music.update", musicDto);
		return count > 0;
	}

	// 추상 메소드 오버라이딩 - 삭제(DELETE)
	@Override
	public boolean delete(int musicNo) {
		// music의 delete(삭제) 실행
		int count = sqlSession.delete("music.delete", musicNo);
		return count > 0;
	}
}
