<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page = "/WEB-INF/views/template/header.jsp">
	<jsp:param name = "title" value = "${boardDto.getBoardTitle()}"/>
</jsp:include>

<div align = "center">
	<table border = "1" width = "900">	
		<tbody align= "center">
			<tr>
				<th>번호</th>
				<td>${boardDto.getBoardNo()}</td>
			</tr>
			<tr>
				<th>제목</th>
				<td>${boardDto.getBoardTitle()}</td>
			</tr>
			<tr>
				<th>내용</th>
				<td height="200" align = "left" valign = "top">${boardDto.getBoardContent()}</td>
			</tr>
			<tr>
				<th>글쓴이</th>
				<td>${boardDto.getBoardWriter()}</td>
			</tr>
			<tr>
				<th>등록일</th>	
				<td><fmt:formatDate value = "${boardDto.getBoardWritetime()}" pattern = "y년 M월 d일 E a h시 m분 s초"/></td>
			</tr>
			<tr>
				<th>수정일</th>
				<td><fmt:formatDate value = "${boardDto.getBoardUpdatetime()}" pattern = "y년 M월 d일 E a h시 m분 s초"/></td>
			</tr>
			<tr>
				<th>조회수</th>
				<td>${boardDto.getBoardRead()}</td>
			</tr>
		</tbody>
		<tfoot>
			<tr>
				<td colspan = "2" align = "right">
					
					<c:if test = "${loginId != null}">
					<a href = "write">글쓰기</a>
					</c:if>
					
					<a href = "write">글쓰기</a>
					<a href = "edit?boardNo=${boardDto.getBoardNo()}">수정</a>
					<a href = "delete?boardNo=${boardDto.getBoardNo()}">삭제</a>
					<a href = "list">목록</a>
				</td>
			</tr>
		</tfoot>
	</table>	
</div>

<jsp:include page = "/WEB-INF/views/template/footer.jsp"></jsp:include>