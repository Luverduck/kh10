package com.kh.spring24.vo;

import java.util.List;

import com.kh.spring24.entity.PaymentDetailDto;
import com.kh.spring24.entity.PaymentDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// 한 건의 대표 결제정보와 그에 따른 상세 결제 정보를 가지는 VO
@Data 
@NoArgsConstructor 
@AllArgsConstructor 
@Builder
public class PaymentVO {
	private PaymentDto paymentDto; // 결제 정보
	private List<PaymentDetailDto> paymentDetailList; // 결제 정보에 엮인 세부 결제 정보 집합
}
