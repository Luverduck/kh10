package com.kh.springhome.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberMyReplyVO {

	// 필드
	int boardNo;
	String boardHead;
	String boardTitle;
	String boardWriter;
	Date boardWritetime;
	int boardGroup;
	int boardParent;
	int boardDepth;
	String replyContent;
	Date replyWritetime;
	int rn;
}
