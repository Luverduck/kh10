package com.kh.spring22.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.spring22.entity.PocketMonsterDto;

@Repository
public class PocketMonsterDaoImpl implements PocketMonsterDao {

	//의존성 주입
	@Autowired
	private SqlSession sqlSession;

	// 추상 메소드 오버라이딩 - 조회
	@Override
	public List<PocketMonsterDto> list() {
		return sqlSession.selectList("pocketmon.list");
	}
	
	// 추상 메소드 오버라이딩 - 단일 조회
	@Override
	public PocketMonsterDto find(int no) {
		return sqlSession.selectOne("pocketmon.get", no);
	}

	// 추상 메소드 오버라이딩 - 등록
	@Override
	public void insert(PocketMonsterDto dto) {
		sqlSession.insert("pocketmon.insert", dto);
	}

	// 추상 메소드 오버라이딩 - 수정
	@Override
	public boolean edit(PocketMonsterDto dto) {
		int count = sqlSession.update("pocketmon.edit", dto);
		return count > 0;
	}

	// 추상 메소드 오버라이딩 - 삭제
	@Override
	public boolean delete(int no) {
		int count  = sqlSession.delete("pocketmon.delete", no);
		return count > 0;
	}
}
