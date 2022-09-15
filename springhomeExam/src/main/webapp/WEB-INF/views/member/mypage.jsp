<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page = "/WEB-INF/views/template/header.jsp">
	<jsp:param name = "title" value = "마이 페이지"/>
</jsp:include>

	<div align = "center">
		<h1>마이 페이지</h1>
		
		<h3>아이디 : "${memberDto.getMemberId()}"</h3>
		<h3>닉네임 : ${memberDto.getMemberNick()}</h3>
		<h3>생년월일 : ${memberDto.getMemberBirth()}</h3>
		<h3>연락처 : ${memberDto.getMemberTel()}</h3>
		<h3>이메일 : ${memberDto.getMemberEmail()}</h3>
		<h3>우편주소 : ${memberDto.getMemberPost()}</h3>
		<h3>기본주소 : ${memberDto.getMemberBaseAddress()}</h3>
		<h3>상세주소 : ${memberDto.getMemberDetailAddress()}</h3>
		<h3>포인트 : ${memberDto.getMemberPoint()}</h3>
		<h3>등급 : ${memberDto.getMemberGrade()}</h3>
		<h3>가입일 : <fmt:formatDate value="${memberDto.memberJoin}" pattern="y년 M월 d일 E a h시 m분 s초"/></h3>
		<h3>최종 로그인 : <fmt:formatDate value="${memberDto.memberLogin}" pattern="y년 M월 d일 E a h시 m분 s초"/></h3>
		
		<br>
		
		<c:choose>
			<c:when test="${mg == '관리자'}">
				<!-- 관리자용 메뉴 -->
				<h2><a href = "member/list">목록 보기</a></h2>
				<h3><a href = "edit?memberId=${memberDto.getMemberId()}">회원 정보 변경</a></h3>
			</c:when>
			<c:otherwise>
				<!-- 회원용 메뉴 -->
				<h3><a href = "/member/information">개인 정보 변경</a></h3>
				<h3><a href = "/member/password">비밀번호 변경</a></h3>
				<h3><a href = "/member/goodbye">회원 탈퇴</a></h3>
			</c:otherwise>
		</c:choose>
	</div>

<jsp:include page = "/WEB-INF/views/template/footer.jsp"></jsp:include>