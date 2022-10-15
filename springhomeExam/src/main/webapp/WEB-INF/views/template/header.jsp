<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
	<title>
		<c:choose>
			<%-- title이라는 변수의 값이 있다면(null이 아니면) title에 입력될 값은 해당 title 변수의 값으로  --%>
			<c:when test = "${param.title != null}">
				${param.title}
			</c:when>
			<c:otherwise>
				홈페이지
			</c:otherwise>
		</c:choose>
	</title>
	
	<link rel="stylesheet" type="text/css" href="/css/commons.css">
	
	<!-- 체크박스 모듈에 대한 js -->
    <script src = "checkbox.js"></script>
	
</head>

<body>

<div align = "center">

<%-- 로그인 상태인지를 판별 --%>
<c:set var = "login" value = "${loginId != null}"></c:set>

<%-- 로그인한 회원의 등급이 '관리자'인지 판별 --%>
<c:set var = "admin" value = "${mg == '관리자'}"></c:set>

<%-- 로그인을 할 경우에만 보이는 메뉴 --%>
<c:choose>
	<%-- 회원에게만 보이는 메뉴 --%>
	<c:when test = "${login}">
		<a href = "/">홈</a>
		<a href = "/board/list">게시글 목록</a>
		<a href = "/guestbook/list">방명록</a>
		<a href = "/pocketmon/list">포켓몬스터</a>
		<a href = "/music/list">음원관리</a>
		<a href = "/member/logout">로그아웃</a>
		<a href = "/member/mypage">마이페이지</a>
	</c:when>
	<%-- 비회원에게 보이는 메뉴 --%>
	<c:otherwise>
		<a href = "/">홈</a>
		<a href = "/board/list">게시판</a>
		<a href = "/guestbook/list">방명록</a>
		<a href = "/member/insert">회원가입</a>
		<a href = "/member/login">로그인</a>
	</c:otherwise>	
</c:choose>

<%-- 관리자에게만 보이는 메뉴 --%>
<c:if test = "${login && admin}">
	<a href="/admin/home">관리자페이지</a>
</c:if>

</div>

<hr>

<%-- 미리 <div> 태그를 써서 Main Content는 자동으로 가운데 정렬이 되도록 한다 --%>
<%-- 나머지 </div>는 footer에 작성하여 Main Content를 감싸도록 한다 --%>
<div align = "center" style = "min-height : 400px">