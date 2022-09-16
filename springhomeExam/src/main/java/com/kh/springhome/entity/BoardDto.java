package com.kh.springhome.entity;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BoardDto {

	// 필드
	int boardNo;
	String boardWriter;
	String boardTitle;
	String boardContent;
	Date boardWritetime;
	Date boardUpdatetime;
	int boardRead;
	int boardLike;
	String boardHead;	
}
