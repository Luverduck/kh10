package com.kh.spring13.repository;

import java.util.List;

import com.kh.spring13.entity.AttachmentDto;

public interface AttachmentDao {

	// 다음 시퀀스 번호 생성
	int sequence();
	
	void insert(AttachmentDto attachmentDto);
	
	List<AttachmentDto> selectList();
	
	AttachmentDto selectOne(int attachmentNo);
	
	boolean delete(int attachmentNo);
}
