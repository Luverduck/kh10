package com.kh.spring18.component;

import java.text.DecimalFormat;
import java.text.Format;
import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomGeneratorImpl implements RandomGenerator {

	// Random 클래스의 인스턴스 생성
	private Random r = new Random();
	
	// 추상 메소드 오버라이딩 - 자릿수에 해당하는 숫자를 받아 인증번호를 생성
	@Override
	public String generateSerial(int size) {
		
		// 인증번호(난수) 생성 범위 - 10의 size 제곱
		int range = (int)Math.pow(10, size);
		
		// 해당 범위에서 인증번호 생성
		int number = r.nextInt(range);
		System.out.println("number = " + number);
		
		// 0이 나열된 문자열 생성 (인증번호 자릿수 조정을 위함)
		StringBuffer buffer = new StringBuffer();
		for(int i = 0 ; i < size ; i ++) {
			buffer.append("0");
		}
		
		// 0이 나열된 문자열을 pattern으로 하는 Format 클래스의 인스턴스 생성
		Format f = new DecimalFormat(buffer.toString());
		
		// 인증번호를 지정된 pattern 형태의 문자열 변환
		String serial = f.format(number);
		
		// 생성된 인증번호 문자열 반환
		return serial;
	}
}
