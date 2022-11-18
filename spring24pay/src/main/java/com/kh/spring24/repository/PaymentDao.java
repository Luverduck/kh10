package com.kh.spring24.repository;

import com.kh.spring24.entity.PaymentDetailDto;
import com.kh.spring24.entity.PaymentDto;

public interface PaymentDao {

	// 추상 메소드 - 결제 번호 반환
	int paymentSequence();
	
	// 추상 메소드 - 결제 상세 번호 반환
	int paymentDetailSequence();
	
	// 추상 메소드 - 결제 테이블에 등록
	void paymentInsert(PaymentDto paymentDto);
	
	// 추상 메소드 - 결제 상세 테이블에 등록
	void paymentDetailInsert(PaymentDetailDto paymentDetailDto);
}
