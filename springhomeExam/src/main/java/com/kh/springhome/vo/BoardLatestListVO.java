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
public class BoardLatestListVO {

	// 필드
	private int boardNo;
	private String boardWriter;
	private String boardTitle;
	private Date boardWritetime;
	private int boardRead;
}
