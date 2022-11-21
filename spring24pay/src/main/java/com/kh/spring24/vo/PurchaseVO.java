package com.kh.spring24.vo;

import java.util.List;

import lombok.Data;

@Data
public class PurchaseVO {
	// 체크된 구매 상품의 상품 번호와 수량을 List 형태로 저장
	private List<PurchaseItemVO> data;
}
