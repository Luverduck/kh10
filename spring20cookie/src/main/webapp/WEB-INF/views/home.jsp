<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>쿠키 학습 예제</h1>

<!-- cookie 확인 -->
<%-- EL에서 쿠키는 ${cookie.이름.value} 형태로 읽는다 --%>
<h2>쿠키 존재 여부 : ${cookie.popup != null}</h2>
<h2>${cookie.popup.value}</h2>

<c:if test = "${cookie.popup == null}">
	<div class = "ad" style="border:1px solid black;">
		<h1>광고 화면</h1>
	</div>
	<a href = "create">이번 브라우저에서 안보기</a><br>
	<a href = "create2">24시간 하루 안보기</a><br>
	<a href = "create3">오늘 하루 안보기</a>
</c:if>
<br>
<a href = "delete">광고 다시 보기</a>