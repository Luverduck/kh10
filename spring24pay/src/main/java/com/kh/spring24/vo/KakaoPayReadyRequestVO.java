package com.kh.spring24.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// 카카오페이 준비 요청에 필요한 데이터
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class KakaoPayReadyRequestVO {
	private String partner_order_id; // 가맹점 주문번호
	private String partner_user_id; // 가맹점 회원 id
	private String item_name; // 상품명
	private int total_amount; // 상품 총액
}
