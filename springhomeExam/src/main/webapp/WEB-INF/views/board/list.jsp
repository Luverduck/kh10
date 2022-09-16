<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page = "/WEB-INF/views/template/header.jsp">
	<jsp:param name = "title" value = "게시글 목록"/>
</jsp:include>

<div align = "center">
	<h1>전체 게시글</h1>
	
	<form action = "list" method = "get">
		<select name = "type" required>
			<option value = "board_title">제목</option>
			<option value = "board_content">내용</option>
			<option value = "board_writer">작성자</option>
		</select>
		<input name = "keyword" required>
		<button type = "submit">검색</button>
	</form>
	
	<table border = "1" width = 500>
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>글쓴이</th>
				<th>등록일</th>
				<th>조회수</th>
				<th>추천수</th>
			</tr>
		</thead>
		
		<tbody>
			<c:forEach var = "boardDto" items = "${list}">
				<tr align="center">
					<td>${boardDto.getBoardNo()}</td>
					<td><a href = "detail?boardNo=${boardDto.boardNo}">[${boardDto.getBoardHead()}] ${boardDto.getBoardTitle()}</a></td>
					<td>${boardDto.getBoardWriter()}</td>
					<td>${boardDto.getBoardWritetime()}</td>
					<td>${boardDto.getBoardRead()}</td>
					<td>${boardDto.getBoardLike()}</td>
				</tr>
			</c:forEach>
			<tr align="right">
				<td colspan="6"><a href = "/board/write">게시글 작성</a></td>
			</tr>
		</tbody>
	</table>
</div>

<jsp:include page = "/WEB-INF/views/template/footer.jsp"></jsp:include>