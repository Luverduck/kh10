<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page = "/WEB-INF/views/template/header.jsp">
	<jsp:param name = "title" value = "회원 로그인"/>
</jsp:include>

<div class = "container-500 mt-20">
	<!-- 정상/이상 접근일 때 모두에서 나오는 화면 -->
	<div class = "row center">
		<h1>회원 로그인</h1>
	</div>
	<form action = "login" method = "post">
	<div class = "row center mt-20">
		<input class = "input input-underline" type = "text" name = "memberId" placeholder = "아이디" required>
	</div>
	
	<div class = "row center mt-20">
		<input class = "input input-underline" type = "password" name = "memberPw" placeholder = "비밀번호" required>
	</div>
	
	<div class = "row center mt-20">
		<button class = "btn btn-positive" type = "submit">로그인</button>
	</div>
	</form>
	
	<div class = "row center mt-20">
		<!-- 이상한 경우만 나오는 화면 -->
		<c:if test = "${param.error != null}">
			<h2 style = "color:red">입력한 정보가 맞지 않습니다</h2>
		</c:if>
	</div>
</div>

<jsp:include page = "/WEB-INF/views/template/footer.jsp"></jsp:include>