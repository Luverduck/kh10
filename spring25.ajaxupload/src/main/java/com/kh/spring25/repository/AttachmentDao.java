package com.kh.spring25.repository;

import com.kh.spring25.entity.AttachmentDto;

public interface AttachmentDao {

	// 추상 메소드 - 시퀀스 번호 반환
	int sequence();
	
	// 추상 메소드 오버라이딩 - 첨부파일 테이블에 데이터 저장
	void save(AttachmentDto attachmentDto);
	
	// 추상 메소드 오버라이딩 - 첨부파일 번호로 첨부파일 조회
	AttachmentDto find(int attachmentNo);
}
