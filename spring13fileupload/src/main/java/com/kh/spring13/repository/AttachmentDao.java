package com.kh.spring13.repository;

import java.util.List;

import com.kh.spring13.entity.AttachmentDto;

public interface AttachmentDao {

	// 추상 메소드 - 첨부파일 번호를 위한 다음 시퀀스 번호 반환
	int sequence();
	
	// 추상 메소드 - 첨부파일 업로드 기록 등록
	void insert(AttachmentDto attachmentDto);
	
	// 추상 메소드 - 첨부파일 업로드 기록 전체조회
	List<AttachmentDto> selectList();
	
	// 추상 메소드 - 첨부파일 업로드 기록 단일조회
	AttachmentDto selectOne(int attachmentNo);
	
	// 추상 메소드 - 첨부파일 업로드 기록 삭제
	boolean delete(int attachmentNo);
}
