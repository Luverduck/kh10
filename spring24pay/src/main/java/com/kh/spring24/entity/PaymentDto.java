package com.kh.spring24.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentDto {
	private int paymentNo; // 결제 번호
	private String memberId; // 결제 회원 ID
	private String itemName; // 상품명
	private int totalAmount; // 상품 가격 총액
	private Date approveAt; // 결제 승인 시각
	private String paymentStatus; // 결제 상태
	private String tid; // 결제 고유 번호
}
