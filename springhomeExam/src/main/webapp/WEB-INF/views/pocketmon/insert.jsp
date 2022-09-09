<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page = "/WEB-INF/views/template/header.jsp">
	<jsp:param value = "포켓몬 도감 등록" name = "title"/>
</jsp:include>

	<div align = "center">
	
		<h1>도감 등록</h1>
		
		<form action = "insert" method = "post">
			번호 : <input type = "text" name = "no" required><br><br>
			이름 : <input type = "text" name = "name" required><br><br>
			타입 : <input type = "text" name = "type" required><br><br>
			<button>등록</button>
		</form>
		
	</div>

<jsp:include page = "/WEB-INF/views/template/footer.jsp"></jsp:include>