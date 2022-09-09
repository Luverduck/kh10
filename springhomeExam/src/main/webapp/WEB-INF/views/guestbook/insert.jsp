<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page = "/WEB-INF/views/template/header.jsp">
	<jsp:param name = "title" value = "방명록 등록"/>
</jsp:include>

	<div align = "center">
		<h1>방명록 등록</h1>
		
		<form action = "insert" method = "post">
			이름 : <input name = "name" placeholder = "이름" type = "text" required><br><br>
			내용 : <input name = "memo" placeholder = "내용" type = "text" required><br><br>
			<button>등록</button> 
		</form>
	</div>
	
<jsp:include page = "/WEB-INF/views/template/footer.jsp"></jsp:include>