package com.kh.spring24.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor 
@AllArgsConstructor 
@Builder
public class KakaoPayCancelRequestVO {
	private String tid; // 결제 고유 번호
	private int cancel_amount; // 취소 금액
	private int cancel_tax_free_amount; // 취소 비과세 금액
}
