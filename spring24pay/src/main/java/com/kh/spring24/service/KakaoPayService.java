package com.kh.spring24.service;

import java.net.URISyntaxException;
import java.util.List;

import com.kh.spring24.entity.PaymentDto;
import com.kh.spring24.entity.ProductDto;
import com.kh.spring24.vo.KakaoPayApproveRequestVO;
import com.kh.spring24.vo.KakaoPayApproveResponseVO;
import com.kh.spring24.vo.KakaoPayCancelRequestVO;
import com.kh.spring24.vo.KakaoPayCancelResponseVO;
import com.kh.spring24.vo.KakaoPayOrderRequestVO;
import com.kh.spring24.vo.KakaoPayOrderResponseVO;
import com.kh.spring24.vo.KakaoPayReadyRequestVO;
import com.kh.spring24.vo.KakaoPayReadyResponseVO;
import com.kh.spring24.vo.PurchaseItemVO;

public interface KakaoPayService {

	// 추상 메소드 - 결제 준비 요청을 보낸 후 결제 준비 응답을 반환
	KakaoPayReadyResponseVO ready(KakaoPayReadyRequestVO vo) throws URISyntaxException;
	
	// 추상 메소드 - 결제 승인 요청을 보낸 후 결제 승인 응답을 반환
	KakaoPayApproveResponseVO approve(KakaoPayApproveRequestVO vo) throws URISyntaxException;
	
	// 추상 메소드 - 결제 조회
	KakaoPayOrderResponseVO order(KakaoPayOrderRequestVO vo) throws URISyntaxException;
	
	// 추상 메소드 - 결제 취소
	KakaoPayCancelResponseVO cancel(KakaoPayCancelRequestVO vo) throws URISyntaxException;
	
	void insertPayment(PaymentDto paymentDto, List<ProductDto> list, List<PurchaseItemVO> data);
}
