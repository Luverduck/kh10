package com.kh.springhome.repository;

import java.util.List;

import com.kh.springhome.entity.ReplyDto;

public interface ReplyDao {

	// 추상 메소드 - 댓글 작성
	void replyWrite(ReplyDto replyDto);
	
	// 추상 메소드 - 댓글 목록
	List<ReplyDto> replyList(int replyOrigin);
	
	// 추상 메소드 - 댓글 수정
	boolean replyUpdate(ReplyDto replyDto);
	
	// 추상 메소드 - 댓글 삭제
	boolean replyDelete(int replyNo);
	
	// 추상 메소드 - 댓글 작성자 검사를 위한 작성자 반환
	String replyWriterReturn(int replyNo);
}
