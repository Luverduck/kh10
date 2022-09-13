package com.kh.springhome.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.kh.springhome.interceptor.MemberInterceptor;

// 스프링 설정 파일
// - application.properties 에서 설정하기 어려운 복잡한 설정을 구현
// - 프로그램 동작 방식과 관련된 설정일 경우 특정 인터페이스를 상속받아야 함
// - interface WebMvcConfigurer 상속

@Configuration
public class InterceptorConfiguration implements WebMvcConfigurer {

	// 의존성 주입
	@Autowired
	private MemberInterceptor memberInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// registry에 추가하여 인터셉터가 작동하도록 설정
		registry.addInterceptor(memberInterceptor)
													.addPathPatterns(		// 인터셉터가 감시할 주소
																	"/pocketmon/**",	// 포켓몬 전부
																	"/music/detail",	// 음원 상세
																	"/member/**"		// 회원 전체
																	)
													.excludePathPatterns(	// 위 주소에서 제외할 주소
																	"/member/insert",		//회원 가입
																	"/member/login"		// 로그인
																	);
	}
}
