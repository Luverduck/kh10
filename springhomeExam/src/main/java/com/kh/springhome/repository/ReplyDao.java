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
	
	// 추상 메소드 - 댓글 정보
	ReplyDto selectOne(int replyNo);

	// 추상 메소드 - 댓글 블라인드
	boolean updateBlind(int replyNo, boolean blind);
}
