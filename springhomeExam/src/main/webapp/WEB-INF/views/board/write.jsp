<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page = "/WEB-INF/views/template/header.jsp">
	<jsp:param name = "title" value = "게시글 작성"></jsp:param>
</jsp:include>

<div align = "center">
	<h1>게시글 작성</h1>
	<form action = "write" method = "post">
		<select name = "boardHead">
			<option value = "">말머리선택</option>
			<option value = "[정보]">정보</option>
			<option value = "[유머]">유머</option>
			<option value = "[공지]">공지</option>
		</select>
		<input name = "boardTitle" placeholder = "제목" required><br><br>
		<input name = "boardContent" placeholder = "내용" required><br><br>
		<button type = "submit">작성</button>
	</form>
</div>

<jsp:include page = "/WEB-INF/views/template/footer.jsp"></jsp:include>