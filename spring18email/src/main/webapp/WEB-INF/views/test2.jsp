<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h1>인증번호 입력</h1>
<form action = "test3" method = "get">
	<input type = "hidden" name = "who" value = "${who}">
	
	인증번호 : <input type = "text" name = "serial" required>
	<button type = "submit">확인</button>
</form>