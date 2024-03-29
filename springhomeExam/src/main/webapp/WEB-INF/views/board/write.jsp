<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   

<jsp:include page = "/WEB-INF/views/template/header.jsp">
	<jsp:param name = "title" value = "게시글 작성"></jsp:param>
</jsp:include>

<div class = "container-800">
	<div class = "row">
		<c:set var = "isReply" value = "${param.boardParent != null}"></c:set>
		<c:choose>
			<c:when test = "${isReply}">
				<h1>답글 작성</h1>
			</c:when>
			<c:otherwise>
				<h1>게시글 작성</h1>
			</c:otherwise>
		</c:choose>
	</div>
	
	<%-- 파일 전송을 위해 enctype 추가 --%>
	<form action = "write" method = "post" enctype = "multipart/form-data">
		<div class = "row">
			<%-- 답글이라면 부모글번호를 추가로 전송하도록 처리 --%>
			<c:if test="${isReply}">
				<input type = "hidden" name = "boardParent" value = "${param.boardParent}">
			</c:if>
			
			<select name = "boardHead">
				<option value = "">선택</option>
				<option value = "정보">정보</option>
				<option value = "유머">유머</option>
				<c:if test = "${mg == '관리자'}">
				<option value = "공지">공지</option>
				</c:if>
			</select>
			
			<input type = "text" name = "boardTitle" placeholder = "제목" required>
		</div>
		<div class = "row">
		
		</div>
		<div class = "row">1</div>
		<div class = "row">1</div>
	</form>
</div>

<div align = "center">
	
	<c:set var = "isReply" value = "${param.boardParent != null}"></c:set>
	<c:choose>
		<c:when test = "${isReply}">
			<h1>답글 작성</h1>
		</c:when>
		<c:otherwise>
			<h1>게시글 작성</h1>
		</c:otherwise>
	</c:choose>
	
	<%-- 파일 전송을 위해 enctype 추가 --%>
	<form action = "write" method = "post" enctype = "multipart/form-data">
	
	<%-- 답글이라면 부모글번호를 추가로 전송하도록 처리 --%>
	<c:if test="${isReply}">
		<input type = "hidden" name = "boardParent" value = "${param.boardParent}">
	</c:if>
	
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
			
			<%-- 첨부 파일 --%>
			<tr>
				<th>첨부파일</th>
				<td>
					<%-- multiple 옵션은 파일을 여러개 선택하도록 한다 --%>
					<input type = "file" name = "attachment" multiple>
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