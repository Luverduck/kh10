<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<title>
			<c:choose>
				<c:when test = "${param.title != null}">
					${param.title}
				</c:when>
				<c:otherwise>
					홈페이지
				</c:otherwise>
			</c:choose>
		</title>
	</head>
	
	<body>
		<!-- 메뉴 -->
		<div align = "center">
			<a href = "pocketmon/list">포켓몬스터</a>
			<a href = "guestbook/list">방명록</a>
			<a href = "music/list">음원관리</a>
			
			<c:set var = "login" value = "${loginId != null}"></c:set>
			<c:choose>
				<c:when test="${login}">
					<a href = "member/logout">로그아웃</a>
					<a href = "member/list">회원목록</a>
					<a href = "member/mypage">마이페이지</a>
				</c:when>
				<c:otherwise>
					<a href = "member/login">로그인</a>
					<a href = "member/insert">회원가입</a>
				</c:otherwise>
			</c:choose>
		</div>
		
		<hr>
		<div align = "center" style = "min-height : 400px">
		