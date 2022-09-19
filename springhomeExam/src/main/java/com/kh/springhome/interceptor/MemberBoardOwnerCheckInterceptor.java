package com.kh.springhome.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.kh.springhome.entity.BoardDto;
import com.kh.springhome.repository.BoardDao;

@Component
public class MemberBoardOwnerCheckInterceptor implements HandlerInterceptor {

	@Autowired
	private BoardDao boardDao;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		// 통과 할 만한 상황이란?
		// (1) 현재 사용자가 작성자인 경우
		// (2) 관리자가 삭제를 하는 경우
		
		// Session에서 memberId 추출
		HttpSession session = request.getSession();
		String memberId = (String) session.getAttribute("loginId");
		
		// 파라미터에서 boardNo를 꺼내기
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		
		// 
		BoardDto boardDto = boardDao.selectOne(boardNo);
		
		// memberId가 boardDto의 boardWriter와 같다면 Owner(true)
		boolean isOwner = memberId.equals(boardDto.getBoardWriter());
		
		// (1) 현재 사용자가 작성자인 경우
		if(isOwner) {	// 소유자라면 통과(true)
			return true;
		}
		
		// (2) 관리자가 삭제를 하는 경우
		String memberGrade = (String) session.getAttribute("mg");
		boolean isAdmin = memberGrade.equals("관리자");
		boolean isDelete = request.getRequestURI().equals("/board/delete");
		if(isAdmin && isDelete) {	// 관리자가 삭제할 경우 통과(true)
			return true;
		}
		
		// 기본적으로 차단
		response.sendError(403);
		return false;
	}
	
	
}
