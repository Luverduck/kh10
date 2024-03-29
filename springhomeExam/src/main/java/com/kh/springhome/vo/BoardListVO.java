package com.kh.springhome.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class BoardListVO {
	
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
	private int boardGroup, boardParent, boardDepth;
	private int replyCount;
}
