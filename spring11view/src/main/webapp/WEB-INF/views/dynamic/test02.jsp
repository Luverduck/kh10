<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%-- 
	JSTL (JSP Standard Tag Library)
	- JSP 표준 태그 모음
	- JSP에서 Java 코드 없이 Java 코드 효과를 내기 위해서 존재
	
	- 변수 생성, 조건문, 반복문이 핵심 (core 패키지)
	- 사용하려면 사용할 페이지에 등록해야함
--%>    

<!-- EL(Expression Language) 표현 언어 -->
<!-- 설정 태그 -->
<!-- 
	prefix : 태그 이름의 시작을 해당 글자로 한다
	url : 주소 입력
-->
<%@ taglib prefix="kh" uri="http://java.sun.com/jsp/jstl/core" %>
<kh:forEach var = "i" begin = "1" end = "10" step = "1">
	<h1>JSTL 반복 ${i}</h1>
</kh:forEach>

<!--  -->
<%for(int i = 1 ; i <= 10 ; i ++) {%>
	<h1>Scriptlet 반복 <%=i %></h1>
<%} %>

