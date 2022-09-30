<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page = "/WEB-INF/views/template/header.jsp">
	<jsp:param name = "title" value = "방명록 등록"/>
</jsp:include>

<div class = "container-500 mt-40">
	<div class = "row center">
		<h1>방명록 작성</h1>
	</div>
	<form action = "insert" method = "post">
		<div class = "row left">
			<input class = "input input-underline w-100" name = "name" placeholder = "이름" autocomplete = "off">
		</div>
		<div class = "row center">
			<textarea class = "input w-100" name = "memo" placeholder = "내용" required rows = "8"></textarea>
		</div>
		<div class = "row right">
			<a class = "btn btn-neutral" href = "list">목록</a>
		<button class = "btn btn-positive" type = "submit">작성</button>
	</div>
	</form>
</div>
	
<jsp:include page = "/WEB-INF/views/template/footer.jsp"></jsp:include>