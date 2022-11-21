package com.kh.spring24.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor 
@AllArgsConstructor 
@Builder	
public class KakaoPayApproveRequestVO {
	private String tid; // 결제 고유 번호
	private String partner_order_id; // 가맹점 주문 번호
	private String partner_user_id; // 가맹점 회원 ID
	private String pg_token; // 결제 승인 요청 인증토큰
}