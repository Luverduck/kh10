<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page = "/WEB-INF/views/template/header.jsp">
	<jsp:param name = "title" value = "회원 탈퇴"/>
</jsp:include>

	<div align = "center">
		<h1>회원 탈퇴</h1><br><br>
		<form action = "goodbye" method = "post">
			비밀번호 : <input type = "password" name = "memberPw" required placeholder = "비밀번호"><br><br>
			비밀번호 확인 : <input type = "password" name = "memberPwCheck" required placeholder = "비밀번호 확인"><br><br>
			<button type = "submit">탈퇴하기</button>
		</form>
	</div>

<jsp:include page = "/WEB-INF/views/template/footer.jsp"></jsp:include>