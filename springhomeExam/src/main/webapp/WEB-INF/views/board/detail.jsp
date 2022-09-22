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
					<a href = "write?boardParent=${boardDto.getBoardNo()}">답글쓰기</a>
					</c:if>
					<%--
						관리자는 삭제만, 회원은 자신의 글만 수정/삭제 가능하도록 처리 
					--%>
					<!-- 변수 설정 -->
					<c:set var="owner" value="${loginId == boardDto.boardWriter}"></c:set>
					<c:set var="admin" value="${mg == '관리자'}"></c:set>
					
					<!-- 판정 -->
					<c:if test="${owner}">
						<a href="edit?boardNo=${boardDto.boardNo}">수정</a>
					</c:if>
					
					<c:if test="${owner || admin}">
						<a href="delete?boardNo=${boardDto.boardNo}">삭제</a>
					</c:if>
					
					<a href = "list">목록</a>
				</td>
			</tr>
		</tfoot>
	</table>	
	
	<br><br>
	
	<h3>댓글 목록</h3>
	<table width = "900" border = "1">
		<tbody>
			<%-- 댓글 --%>
			<c:forEach var = "replyDto" items = "${replyList}">
			<tr align = "center">
				<td>		
				${replyDto.getReplyWriter()}
				</td>
				<td>
				${replyDto.getReplyContent()}
				</td>
				<td>
				${replyDto.getReplyWritetime()}
				</td>
				<td>
					<!-- 글 제목을 누르면 수정창이 나오도록 -->
					<form action = "reply/edit" method = "post" id = "replyEdit">
						<input type = "text" name = "replyContent" required>
						<input type = "hidden" name = "boardNo" value = "${replyDto.getReplyOrigin()}">
						<input type = "hidden" name = "replyNo" value = "${replyDto.getReplyNo()}">
						<button>수정</button>
					</form>
				</td>
				<td>
					<form action = "reply/delete" method = "get">
						<input type = "hidden" name = "boardNo" value = "${replyDto.getReplyOrigin()}">
						<input type = "hidden" name = "replyNo" value = "${replyDto.getReplyNo()}">
						<button type = "submit">삭제</button>
					</form>
				</td>
			</tr>	
			</c:forEach>
		</tbody>
	</table>
	
	<br><br>
	
	<h3>댓글 작성</h3>
	<form action = "reply/write" method = "post">
		<textarea name="replyContent" rows="10" cols="50" required></textarea><br><br>
		<input type = hidden name = "replyOrigin" value = "${boardDto.getBoardNo()}">
	<button type = "submit">댓글작성</button>
	</form>
			
</div>

<jsp:include page = "/WEB-INF/views/template/footer.jsp"></jsp:include>