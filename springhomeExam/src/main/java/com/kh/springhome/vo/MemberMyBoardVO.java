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
public class MemberMyBoardVO {

	// 필드
	int boardNo;
	String memberId;
	String boardTitle;
	Date boardWritetime;
	int boardRead;
	int boardLike;
}
