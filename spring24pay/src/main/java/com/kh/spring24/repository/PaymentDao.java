package com.kh.spring24.repository;

import java.util.List;

import com.kh.spring24.entity.PaymentDetailDto;
import com.kh.spring24.entity.PaymentDto;

public interface PaymentDao {

	// 추상 메소드 - 결제 번호 반환
	int paymentSequence();
	
	// 추상 메소드 - 결제 정보 등록
	void paymentInsert(PaymentDto paymentDto);
	
	// 추상 메소드 - 세부 결제 번호 반환
	int paymentDetailSequence();
	
	// 추상 메소드 - 세부 결제 정보 등록
	void paymentDetailInsert(PaymentDetailDto paymentDetailDto);
	
	List<PaymentDto> paymentHistory(String memberId);
	
	PaymentDto findPayment(int paymentNo);
	List<PaymentDetailDto> findPaymentDetail(int paymentNo);
	
	void cancelPayment(int paymentNo);
	void cancelPaymentDetail(int paymentNo);
	
	PaymentDetailDto findPaymentDetailItem(int paymentDetailNo);
	
	void cancelPaymentDetailItem(int paymentDetailNo);
	void refreshPayment(int paymentNo);
}
