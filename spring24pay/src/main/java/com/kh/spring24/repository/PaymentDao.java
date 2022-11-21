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
	
	// 추상 메소드 - 결제 내역 전체 조회
	List<PaymentDto> paymentHistory(String memberId);
	
	// 추상 메소드 - 결제 번호를 이용하여 결제 정보 조회
	PaymentDto findPayment(int paymentNo);
	
	// 추상 메소드 - 결제 번호를 이용하여 결제 상세 정보 조회
	List<PaymentDetailDto> findPaymentDetail(int paymentNo);
	
	// 추상 메소드 - 해당 결제 번호의 결제 상품의 결제 상태를 '취소'로 변경
	void cancelPayment(int paymentNo);
	
	// 추상 메소드 - 해당 결제 번호의 세부 결제 상품의 결제 상태를 '취소'로 변경
	void cancelPaymentDetail(int paymentNo);
	
	// 추상 메소드 - 세부 결제 번호를 이용하여 세부 결제 정보 조회
	PaymentDetailDto findPaymentDetailItem(int paymentDetailNo);
	
	// 추상 메소드 - 해당 세부 결제 번호의 세부 결제 상품의 결제 상태를 '취소'로 변경
	void cancelPaymentDetailItem(int paymentDetailNo);
	
	// 추상 메소드 - 부분 취소 결과에 따라 전체 결제의 상태를 '취소' 또는 '부분취소'로 변경
	void refreshPayment(int paymentNo);
}
