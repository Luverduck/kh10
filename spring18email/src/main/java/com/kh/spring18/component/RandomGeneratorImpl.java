package com.kh.spring18.component;

import java.text.DecimalFormat;
import java.text.Format;
import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomGeneratorImpl implements RandomGenerator {

	// 
	private Random r = new Random();
	
	// 추상 메소드 오버라이딩 - 자릿수에 해당하는 숫자를 받아 인증번호를 생성
	@Override
	public String generateSerial(int size) {
		// 10의 size 제곱
		int range = (int)Math.pow(10, size);
		// 해당 자릿수의 난수 생성
		int number = r.nextInt(range);
		System.out.println("number = " + number);
		
		// 인증번호 자릿수 조정
		StringBuffer buffer = new StringBuffer();
		for(int i = 0 ; i < size ; i ++) {
			buffer.append("0");
		}
		Format f = new DecimalFormat(buffer.toString());
		String serial = f.format(number);
		
		// 인증번호 반환
		return serial;
	}
}
