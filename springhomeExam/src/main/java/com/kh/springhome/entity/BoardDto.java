package com.kh.springhome.entity;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class BoardDto {

	// 필드
	private int boardNo;
	private String boardWriter;
	private String boardTitle;
	private String boardContent;
	private Date boardWritetime;
	private Date boardUpdatetime;
	private int boardRead;
	private int boardLike;
	private String boardHead;	
	
	// 계층형 게시판 데이터 추가
	// (참고) boardParent는 null일 수 있지만 JDBC에서 0으로 변환해준다
	private int boardGroup, boardParent, boardDepth;

	// DB에 INSERT 할 때 0 대신 null이 등록되도록 변환해서 반환하는 메소드
	public Integer getBoardParentInteger() {
		if(boardParent == 0) return null;
		else return boardParent;
	}
}
