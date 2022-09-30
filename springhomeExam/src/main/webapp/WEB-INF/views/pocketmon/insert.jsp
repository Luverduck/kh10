<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page = "/WEB-INF/views/template/header.jsp">
	<jsp:param value = "포켓몬 도감 등록" name = "title"/>
</jsp:include>

<div class = "container-600 mt-40" style = "background-image: url(/image/pikachu.png); background-repeat: no-repeat; background-size: 100%">
	<div class = "row center">
		<h1>도감 등록</h1>
	</div>
	
	<form action = "insert" method = "post">
		<div class = "row center">
			<input class = "input" type = "text" name = "no" placeholder = "번호" required autocomplete = "off">
		</div>
		<div class = "row center">
			<input class = "input" type = "text" name = "name" placeholder = "이름" required autocomplete = "off">
		</div>
		<div class = "row center">
			<input class = "input" type = "text" name = "type" placeholder = "타입" required autocomplete = "off">
		</div>
		<div class = "row center">
			<button class = "btn btn-positive" type = "submit">등록</button>
		</div>
	</form>
</div>

<jsp:include page = "/WEB-INF/views/template/footer.jsp"></jsp:include>