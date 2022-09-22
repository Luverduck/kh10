package com.kh.springhome.constant;

// 세션에서 자주 사용하는 값들의 이름을 보관 - 상수 보관용 클래스/인터페이스
public interface SessionConstant {
	
	// 클래스에서는 반드시 public static final을 붙여야함
	public static final String ID = "loginId";
	
	// 인터페이스에서는 public static final 생략 가능
	String GRADE = "mg";
	
	// 상수로 바꿀 값을 찾을 때
	// ctrl + F
	// ctrl + h
}
