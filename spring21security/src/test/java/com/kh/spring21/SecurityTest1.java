package com.kh.spring21;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class SecurityTest1 {

	// 암호화
	// - 데이터를 암호 방식으로 변경하여 보안 수준을 올리는 행위
	// (1) 양방향 암호화 - 암호화/복호화 가능한 방식
	// (2) 단방향 암호화 - 암호화만 가능한 방식
	
	// [1] 시저(caesar) 암호화
	// - 알파벳을 특정 offset만큼 증가 혹은 감소시켜 암호화/복호화 처리
	// - offset이 3이라면 a는 d가 된다
	@Test
	public void test() {
		char ch = 'a';
		ch += 3; // 암호화
		log.debug("ch = {}", ch);
		
		ch -= 3; // 복호화
		log.debug("ch = {}", ch);
	}
	
	@Test
	public void test2() {
		
		String origin = "hello everyone";
		int offset = 3;
		
		// 문자열 시저 암호화
		StringBuffer encrypt = new StringBuffer();
		for(int i = 0 ; i < origin.length() ; i ++) {
			char ch = origin.charAt(i);
			ch += offset;
			encrypt.append(ch);
		}
		
		log.debug("encrypt = {}", encrypt);
		
		// 문자열 복호화
		StringBuffer decrypt = new StringBuffer();
		for(int i = 0 ; i < encrypt.length() ; i ++) {
			char ch = encrypt.charAt(i);
			ch -= offset;
			decrypt.append(ch);
		}
		
		log.debug("decrypt = {}", decrypt);
	}
}
