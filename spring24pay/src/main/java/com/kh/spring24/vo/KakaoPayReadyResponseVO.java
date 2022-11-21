package com.kh.spring24.vo;

import java.util.Date;

import lombok.Data;

// 카카오페이 준비 요청 결과 데이터
@Data
public class KakaoPayReadyResponseVO {
	private String tid; // 결제 고유 번호, 20자
	private String next_redirect_mobile_url; // 모바일 웹에 대한 카카오페이 결제 페이지 Redirect URL
	private String next_redirect_pc_url; // PC 웹에 대한 카카오페이 결제 페이지 Redirect URL
	private Date created_at; // 결제 준비 요청 시간
}
