<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page = "/WEB-INF/views/template/header.jsp">
	<jsp:param name = "title" value = "회원 가입"/>
</jsp:include>
 
	<div align = "center">
		<h1>회원 가입 성공!</h1>
		<h3><a href = "/">메인페이지로 돌아가기</a></h3>
		<h3><a href = "login">로그인</a></h3>
	</div>
	
<jsp:include page = "/WEB-INF/views/template/footer.jsp"></jsp:include>