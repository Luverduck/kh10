package com.kh.springhome.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ReplyListVO {

	// 필드
	private int replyNo;
	private String replyWriter;
	private int replyOrigin;
	private Date replyWritetime;
	private String replyContent;
	// DB의 char(1)을 논리로 변환
	private boolean replyBlind;
	private String memberNick;
	private String memberGrade;
}
