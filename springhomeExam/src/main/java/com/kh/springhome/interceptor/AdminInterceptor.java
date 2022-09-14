package com.kh.springhome.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class AdminInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(
								HttpServletRequest request, 
								HttpServletResponse response, 
								Object handler
							) throws Exception {
		System.out.println("Admin Interceptor");
		
		HttpSession session = request.getSession();
		String mg = (String) session.getAttribute("mg");
		if(mg != null && mg.equals("관리자")) {	// 관리자일 때
			return true;
		}
		else {	// 관리자가 아닐 때
//			response.sendRedirect("/");		// 메인으로 강제이동(redirect)
			response.sendError(403);		// 사용자에게 권한 없음(403) 출력
			return false;	// 차단
		}
	}

	
}
