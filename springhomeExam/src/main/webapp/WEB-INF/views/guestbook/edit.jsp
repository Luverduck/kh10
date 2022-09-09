<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page = "/WEB-INF/views/template/header.jsp">
	<jsp:param name = "title" value = "${guestBookDto.getNo()}번 방명록 정보 수정"/>
</jsp:include>

	<div align = "center">
		<h1>방명록 정보 수정</h1>
		<form action = "edit" method = "post">
			<input type = "hidden" name = "no" required value = "${guestBookDto.getNo()}">
			작성자 : <input type = "text" name = "name" required value = "${guestBookDto.getName()}"><br><br>
			메모 : <input type = "text" name = "memo" required value = "${guestBookDto.getMemo()}"><br><br>
			<button type = "submit">수정</button>
		</form>
	</div>

<jsp:include page = "/WEB-INF/views/template/footer.jsp"></jsp:include>