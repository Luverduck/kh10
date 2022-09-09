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
			<a href = "#">방명록</a>
			<a href = "#">음원관리</a>
			
			<a href = "#">회원가입</a>
			<a href = "#">로그인</a>
			<a href = "#">로그아웃</a>
			<a href = "#">회원목록</a>
		</div>
		
		<hr>
		<div align = "center" style = "min-height : 400px">
		