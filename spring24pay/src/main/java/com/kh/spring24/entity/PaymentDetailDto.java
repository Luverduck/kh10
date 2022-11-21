package com.kh.spring24.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentDetailDto {
	private int paymentDetailNo; // 세부 결제 번호
	private int paymentNo; // 결제 번호
	private int productNo; // 상품 번호
	private String productName; // 상품명
	private int productPrice; // 상품 가격
	private int qty; // 상품 수량
	private String paymentDetailStatus; // 상품 결제 상품
}
