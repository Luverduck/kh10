package com.kh.springhome.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class BoardInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("Board Interceptor");
		
		HttpSession session = request.getSession();
		
		String loginId = (String) session.getAttribute("loginId");
		
		if(loginId == null) {
			response.sendRedirect("/member/loginId");
			return false;
		}
		else {
			return true;
		}
	}	
}
