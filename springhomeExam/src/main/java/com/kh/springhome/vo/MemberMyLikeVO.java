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
public class MemberMyLikeVO {

	// 필드
	int boardNo;
	String boardHead;
	String boardTitle;
	Date boardWritetime;
	int boardRead;
	int boardLike;
	int boardGroup;
	int boardParent;
	int boardDepth;
	int rank;
	
	//DB에 INSERT 할 때 0 대신 null이 등록되도록 값을 변환해서 반환하는 메소드
		public Integer getBoardParentInteger() {
			if(boardParent == 0) 
				return null;
			else 
				return boardParent;
		}
}
