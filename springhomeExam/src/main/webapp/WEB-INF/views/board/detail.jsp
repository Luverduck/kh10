<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
				<th>조회수</th>
			</tr>
		</thead>
		
		<tbody align= "center">
			<tr>
				<td>${boardDto.getBoardNo()}</td>
				<td>${boardDto.getBoardTitle()}</td>
				<td>${boardDto.getBoardWriter()}</td>
				<td>${boardDto.getBoardWritetime()}</td>
<!-- 			
				<td><fmt:formatDate value = "${boardDto.getBoardWritetime()}" pattern = "y년 M월 d일 E a h시 m분 s초"/></td>
				<td><fmt:formatDate value = "${boardDto.getBoardUpdatetime()}" pattern = "y년 M월 d일 E a h시 m분 s초"/></td>
-->	
				<td>${boardDto.getBoardRead()}</td>
			</tr>
			<tr>
				<td colspan = 5 height="300" align = "left" valign = "top">${boardDto.getBoardContent()}</td>
			</tr>
		</tbody>
	</table>
	<h3><a href = "list">목록</a></h3>
	<h3><a href = "edit?boardNo=${boardDto.getBoardNo()}">수정</a></h3>
	<h3><a href = "delete?boardNo=${boardDto.getBoardNo()}">삭제</a></h3>
</div>

<jsp:include page = "/WEB-INF/views/template/footer.jsp"></jsp:include>