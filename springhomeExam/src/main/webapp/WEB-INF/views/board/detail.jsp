<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page = "/WEB-INF/views/template/header.jsp">
	<jsp:param name = "title" value = "${boardDto.getBoardTitle()}"/>
</jsp:include>

<div align = "center">
	<table border = "1" width = "500">
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>글쓴이</th>
				<th>등록일</th>
			</tr>
		</thead>
		
		<tbody align= "center">
			<tr>
				<td>${boardDto.getBoardNo()}</td>
				<td>${boardDto.getBoardTitle()}</td>
				<td>${boardDto.getBoardWriter()}</td>
				<td>${boardDto.getBoardWritetime()}</td>
			</tr>
			<tr>
				<td colspan = 4 height="300" align = "left" valign = "top">${boardDto.getBoardContent()}</td>
			</tr>
		</tbody>
	</table>
	
	<h3><a href = "edit?boardNo=${boardDto.getBoardNo()}">수정하기</a></h3>
</div>

<jsp:include page = "/WEB-INF/views/template/footer.jsp"></jsp:include>