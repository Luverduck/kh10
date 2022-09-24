package com.kh.springhome.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberWriteCountVO {

	// 필드
	private String memberId;
	private int boardCount;
	private int boardRank;
}
