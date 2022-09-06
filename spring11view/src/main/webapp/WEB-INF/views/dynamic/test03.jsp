<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%--
	Cotroller에서 전달하는 데이터 출력은 EL로 한다
	${requestScope.name}이 정식 표현이지만 생략이 가능하므로
	%{name}과 같이 쓴다
--%>
<h1>이름 : ${name}</h1>
<h1>점수 : ${score}</h1>