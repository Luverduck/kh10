package com.kh.springhome.entity;

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
public class ReplyDto {

	// 필드
	int replyNo;
	String replyWriter;
	int replyOrigin;
	Date replyWritetime;
	String replyContent;
}
