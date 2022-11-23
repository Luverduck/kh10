package com.kh.spring25.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.spring25.entity.AttachmentDto;

@Repository
public class AttachmentDaoImpl implements AttachmentDao {

	// 의존성 주입
	@Autowired
	private SqlSession sqlSession;

	// 추상 메소드 오버라이딩 - 시퀀스 번호 반환
	@Override
	public int sequence() {
		return sqlSession.selectOne("attachment.sequence");
	}

	// 추상 메소드 오버라이딩 - 첨부파일 테이블에 데이터 저장
	@Override
	public void save(AttachmentDto attachmentDto) {
		sqlSession.insert("attachment.save", attachmentDto);
	}
	
	// 추상 메소드 오버라이딩 - 첨부파일 번호로 첨부파일 조회
	@Override
	public AttachmentDto find(int attachmentNo) {
		return sqlSession.selectOne("attachment.find", attachmentNo);
	}
}
