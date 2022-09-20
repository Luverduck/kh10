package com.kh.springhome.vo;

import lombok.Data;

@Data
public class BoardListSearchVO {
	// 검색 분류와 검색어
	private String type, keyword;
	
	public boolean isSearch() {
		return type != null && keyword != null;
	}
	
	// 현재 페이지 번호 (없을 경우 1로 설정)
	private int p = 1;
	private int size = 10;
	
	public int endRow() {
		return p * size;
	}
	
	public int startRow() {
		return endRow() - (size - 1);
	}
}