package com.kh.springhome.error;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// @ControllerAdvice는 컨트롤러의 오류를 간섭하는 객체
//@ControllerAdvice(annotations = {Controller.class})	// @Controller가 붙은 모든 클래스에 간섭
@ControllerAdvice(basePackages = {"com.kh.springhome.controller"})	// 해당 패키지에 있는 모든 컨트롤러에 간섭
public class ExceptionProcessor {

	// 원하는 상황이 발생하면 자동으로 간섭하여 실행할 메소드
	// - 메소드는 컨트롤러와 동일한 구성이 가능 (+ 예외 객체 선언 가능)
	// - 반환시 view resolver의 영향을 받는다
	
	@ExceptionHandler(Exception.class)	// 모든 예외를 다 처리
	public String handle(Exception e) {
		// 컨트롤러에 예외가 발생하면 예외 페이지(exception.jsp)로 이동
//		rerturn "/WEB-INF/views/error/exception.jsp";
		return "error/exception";
	}
	
	@ExceptionHandler(TargetNotFoundException.class)
	public String handle2(Exception e) {
		return "error/notFound";
	}
}
