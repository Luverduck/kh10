<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   

<jsp:include page = "/WEB-INF/views/template/header.jsp">
	<jsp:param name = "title" value = "게시글 작성"></jsp:param>
</jsp:include>

<div align = "center">
	<h1>게시글 작성</h1>
	<form action = "write" method = "post">
	<table border = "1" width = "500">
		<tbody>
			<tr>
				<th>말머리</th>
				<td>
					<select name = "boardHead">
						<option value = "">선택</option>
						<option value = "정보">정보</option>
						<option value = "유머">유머</option>
						<c:if test = "${mg == '관리자'}">
						<option value = "공지">공지</option>
						</c:if>
					</select>
				</td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type = "text" name = "boardTitle" placeholder = "제목" required></td>
			</tr>
			<tr>
				<th>내용</th>
				<td>
					<!-- 
					여러 줄 입력이 가능한 도구
					- rows 는 기본 표시 줄 수
					- cols 는 기본 표시 칸 수 
					-->
					<textarea name="boardContent" rows="10" cols="50" required></textarea>
				</td>
			</tr>
		</tbody>
		<tfoot>
			<tr>
				<td align = "right" colspan = "2">
					<button type = "submit">작성</button>
					<a href = "list">목록</a>
				</td>
			</tr>
		</tfoot>
	</table>
	</form>
</div>

<jsp:include page = "/WEB-INF/views/template/footer.jsp"></jsp:include>