package com.kh.spring18.component;

public interface RandomGenerator {

	// 추상 메소드 - 자릿수에 해당하는 숫자를 받아 인증번호를 생성
	String generateSerial(int size);
}
