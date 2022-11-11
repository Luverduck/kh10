package com.kh.spring21;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class SecurityTest4 {

	// 목표 : spring-security-core에 있는 암호화 도구 활용
	// - StandardPasswordEncoder : SHA-256 방식의 암호화를 하는 도구
	
//	@Test
	public void test() {
		StandardPasswordEncoder encoder = new StandardPasswordEncoder();
		String origin = "hello everyone";
		String encrypt = encoder.encode(origin); // 암호화
		
		log.debug("origin = {}", origin);
		log.debug("encrypt = {}", encrypt);
	}
	
	
	// - Pbkdf2PasswordEncoder : 의도적으로 단방향 암호화를 느리게 하는 도구
	
	@Test
	public void test2() {
		Pbkdf2PasswordEncoder encoder = new Pbkdf2PasswordEncoder();
		String origin = "hello everyone";
		String encrypt = encoder.encode(origin); // 암호화
		
		log.debug("origin = {}", origin);
		log.debug("encrypt = {}", encrypt);
	}
	
	
	// - BCryptPasswordEncoder : 시간을 이용하여 매번 달라지는 암호화 (60자리)
	
	@Test
	public void test3() {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String origin = "hello everyone";
		String encrypt = encoder.encode(origin); // 암호화
		
		log.debug("origin = {}", origin);
		log.debug("encrypt = {}", encrypt);
		
		// origin과 encrypt의 검증은 matches로 한다 - origin 먼저, encrypt는 뒤에
		log.debug("판정 = {}", encoder.matches(origin, encrypt));
	}
}
