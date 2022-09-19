package com.kh.springhome.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardListSearchVO {

	// 필드
	private String type;
	private String keyword;
	
	// 전체 조회인지 검색 조회인지 판별 (boolean)
	public boolean isSearch() {
		return type != null && keyword != null;
	}
}
