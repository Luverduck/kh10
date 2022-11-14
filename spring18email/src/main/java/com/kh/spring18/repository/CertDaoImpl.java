package com.kh.spring18.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.spring18.entity.CertDto;

@Repository
public class CertDaoImpl implements CertDao {

	// 의존성 주입
	@Autowired
	private SqlSession sqlSession;

	// 추상 메소드 - 인증번호 등록
	@Override
	public void insert(CertDto certDto) {
		sqlSession.insert("cert.insert", certDto);
	}

	// 추상 메소드 - 인증번호 삭제
	@Override
	public boolean delete(String who) {
		int count = sqlSession.delete("cert.delete", who);
		return count > 0;
	}
	
	// 추상 메소드 - 인증번호 조회(5분 이내 발급된 인증번호인지)
	@Override
	public boolean check(CertDto certDto) {
		CertDto result = sqlSession.selectOne("cert.check", certDto);
		return result != null;
	}

	// 추상 메소드 오버라이딩
	@Override
	public void clear() {
		sqlSession.delete("cert.clear");
	}
}
