package com.kh.spring21;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class SecurityTest2 {

	// 비트 연산 - &(and), |(or), ^(xor), ~(not)
	// - 연산 중에 가장 빠름
	// - 2진수의 1비트를 기반으로 계산
	// ex) 	7 & 4 = ? 
	// 		7 | 4 = ?
	//		7 ^ 4 = ?
	
	@Test
	public void test() {
		// xor 암호화 - xor 연산을 2번 하면 자기 자신으로 돌아오는 특징을 활용
		
		char ch = 'a';
		int offset = 5;
		
		// 암호화
		ch ^= offset;
		log.debug("ch = {}", ch);
		
		// 복호화
		ch ^= offset;
		log.debug("ch = {}", ch);
	}
	
	@Test
	public void test2() {
		
		String origin = "hello everyone";
		int offset = 3;
		
		// 문자열 xor 암호화
		StringBuffer encrypt = new StringBuffer();
		for(int i = 0 ; i < origin.length() ; i ++) {
			char ch = origin.charAt(i);
			ch ^= offset;
			encrypt.append(ch);
		}
		
		log.debug("encrypt = {}", encrypt);
		
		// 문자열 xor 복호화
		StringBuffer decrypt = new StringBuffer();
		for(int i = 0 ; i < encrypt.length() ; i ++) {
			char ch = encrypt.charAt(i);
			ch ^= offset;
			decrypt.append(ch);
		}
		
		log.debug("decrypt = {}", decrypt);
	}
}
