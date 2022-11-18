package com.kh.spring24.service;

import java.net.URISyntaxException;

import com.kh.spring24.vo.KakaoPayApproveRequestVO;
import com.kh.spring24.vo.KakaoPayApproveResponseVO;
import com.kh.spring24.vo.KakaoPayOrderRequestVO;
import com.kh.spring24.vo.KakaoPayOrderResponseVO;
import com.kh.spring24.vo.KakaoPayReadyRequestVO;
import com.kh.spring24.vo.KakaoPayReadyResponseVO;

public interface KakaoPayService {

	// 추상 메소드 - 결제 준비
	KakaoPayReadyResponseVO ready(KakaoPayReadyRequestVO vo) throws URISyntaxException;
	
	// 추상 메소드 - 결제 승인
	KakaoPayApproveResponseVO approve(KakaoPayApproveRequestVO vo) throws URISyntaxException;
	
	// 추상 메솓 - 결제 조회
	KakaoPayOrderResponseVO order(KakaoPayOrderRequestVO vo) throws URISyntaxException;
	
	
}
