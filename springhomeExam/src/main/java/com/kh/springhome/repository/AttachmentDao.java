package com.kh.springhome.repository;

import java.util.List;

import com.kh.springhome.entity.AttachmentDto;

public interface AttachmentDao {

	// 다음 시퀀스 번호 생성
	int sequence();
	
	void insert(AttachmentDto attachmentDto);
	
	List<AttachmentDto> selectList();
	
	AttachmentDto selectOne(int attachmentNo);
	
	boolean delete(int attachmentNo);
	
	// 추상 메소드 - 해당 게시글의 첨부파일 관련
	List<AttachmentDto> selectBoardAttachmentList(int boardNo);
}
