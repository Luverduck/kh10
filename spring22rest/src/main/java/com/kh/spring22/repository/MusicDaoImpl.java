package com.kh.spring22.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.spring22.entity.MusicDto;

@Repository
public class MusicDaoImpl implements MusicDao {

	// 의존성 주입
	@Autowired
	private SqlSession sqlSession;

	// 추상 메소드 오버라이딩 - 조회
	@Override
	public List<MusicDto> list() {
		return sqlSession.selectList("music.list");
	}

	// 추상 메소드 오버라이딩 - 단일 조회
	@Override
	public MusicDto find(int musicNo) {
		return sqlSession.selectOne("music.get", musicNo);
	}

	// 추상 메소드 오버라이딩 - 등록
	@Override
	public void insert(MusicDto musicDto) {
		sqlSession.insert("music.insert", musicDto);
	}

	// 추상 메소드 오버라이딩 - 수정
	@Override
	public boolean edit(MusicDto musicDto) {
		int count = sqlSession.update("music.edit", musicDto);
		return count > 0;
	}

	// 추상 메소드 오버라이딩 - 삭제
	@Override
	public boolean delete(int musicNo) {
		int count = sqlSession.delete("music.delete", musicNo);
		return count > 0;
	}
}
