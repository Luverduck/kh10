<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page = "/WEB-INF/views/template/header.jsp">
	<jsp:param name = "title" value = "게시글 수정"/>
</jsp:include>

<div align = "center">
	<form action="edit" method = "post">
		<input type = "hidden" name = "boardNo" value = "${boardDto.getBoardNo()}">
		제목 : <select name = "boardHead">
			<option value = "[정보]">정보</option>
			<option value = "[유머]">유머</option>
			<option value = "[공지]">공지</option>
		</select>
		<input type = "text" name = "boardTitle" value = "${boardDto.getBoardTitle()}" size = "50%"><br><br>
		내용 : <input type = "text" name = "boardContent" value = "${boardDto.getBoardContent()}" size = "55%"><br><br>
		<button type = "submit">수정</button>
	</form>
</div>

<jsp:include page = "/WEB-INF/views/template/footer.jsp"></jsp:include>