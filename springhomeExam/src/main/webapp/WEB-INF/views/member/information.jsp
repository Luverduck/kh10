<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page = "/WEB-INF/views/template/header.jsp">
	<jsp:param name = "title" value = "개인정보 변경"/>
</jsp:include>

	<div align = "center">
		<h1>개인정보 변경</h1>
		<form action ="information" method = "post">
			비밀번호 : <input type = "password" name = "memberPw" placeholder = "현재 비밀번호"><br><br>
			닉네임 : <input type = "text" name = "memberNick" placeholder = "닉네임"><br><br>
			연락처 : <input type = "text" name = "memberTel" placeholder = "연락처"><br><br>
			이메일 : <input type = "text" name = "memberEmail" placeholder = "이메일"><br><br>
			우편주소 : <input type = "text" name = "memberPost" placeholder = "우편주소"><br><br>
			기본주소 : <input type = "text" name = "memberBaseAddress" placeholder = "기본주소"><br><br>
			상세주소 : <input type = "text" name = "memberDetailAddress" placeholder = "상세주소"><br><br>
			<button type = "submit">변경</button>
		</form>
		
		<c:if test = "${param.error != null}">
			<h2>비밀번호가 맞지 않습니다</h2>
		</c:if>
	</div>

<jsp:include page = "/WEB-INF/views/template/footer.jsp"></jsp:include>