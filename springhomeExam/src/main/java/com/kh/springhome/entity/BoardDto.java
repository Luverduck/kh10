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
	private int boardNo;
	private String boardWriter;
	private String boardTitle;
	private String boardContent;
	private Date boardWritetime;
	private Date boardUpdatetime;
	private int boardRead;
	private int boardLike;
	private String boardHead;	
}
