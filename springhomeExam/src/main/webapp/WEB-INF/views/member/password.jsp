<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page = "/WEB-INF/views/template/header.jsp">
	<jsp:param name = "title" value = "비밀번호 변경"/>
</jsp:include>

	<div align = "center">
		<h1>비밀번호 변경</h1>
		
		<form action = "password" method = "post">
			현재 비밀번호 : <input type = "password" name = "pwNow" placeholder = "현재 비밀번호"><br>
			변경 비밀번호 : <input type = "password" name = "pwChange" placeholder = "변경 비밀번호"><br>
			비밀번호 확인 : <input type = "password" name = "pwChangeCheck" placeholder = "비밀번호 확인"><br>
			<button type = "submit">변경</button>
		</form>
	</div>

<jsp:include page = "/WEB-INF/views/template/footer.jsp"></jsp:include>