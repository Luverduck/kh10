package com.kh.springhome.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardWriterListVO {

	// 필드
	String memberId;
	int boardCount;
	int boardRank;
}
