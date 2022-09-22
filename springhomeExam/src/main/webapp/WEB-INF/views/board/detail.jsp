<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page = "/WEB-INF/views/template/header.jsp">
	<jsp:param name = "title" value = "${boardDto.getBoardTitle()}"/>
</jsp:include>

<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script>
	$(function(){
		//목표 : 
		//1. edit-btn을 누르면 view를 숨기고 editor를 보여준다
		//2. cancel-btn을 누르면 editor를 숨기고 view를 보여준다
		//3. 처음에는 view만 보여준다
		//1
		$(".edit-btn").click(function(){
			$(this).parents(".view").hide();
			$(this).parents(".view").next(".editor").show();
		});
		//2
		$(".cancel-btn").click(function(){
			$(this).parents(".editor").hide();
			$(this).parents(".editor").prev(".view").show();
		});
		//3
		$(".editor").hide();
	});
</script>

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
				<td height="200" align = "left" valign = "top">
				
				<!-- 블라인드 여부에 따라 다르게 표시 -->
				<c:choose>
					<c:when test = "${replyDto.getReplyBlind()}">
						<pre>블라인드 처리된 게시물입니다</pre>
					</c:when>
					<c:otherwise>
						${boardDto.getBoardContent()}
					</c:otherwise>
				</c:choose>
				
				</td>
			</tr>
			<tr>
				<th>작성자</th>
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

	<%-- 회원일 경우와 아닐 경우 댓글 작성창이 다르게 보이도록 처리 --%>
	<table border = "1" width = "900" >
		<!-- 댓글 목록 -->
		<tbody>
			<c:forEach var = "replyDto" items = "${replyList}">
			<tr class="view">
				<td width = "90%">		
					<!-- 작성자 -->
					${replyDto.getReplyWriter()} 
					<c:if test = "${boardDto.getBoardWriter() == replyDto.getReplyWriter()}">
					(작성자)
					</c:if>

					(등급은 table 조인을 배워야 할 수 있는 항목)
					<pre>${replyDto.getReplyContent()}</pre>
					<br><br>
					<fmt:formatDate value="${replyDto.getReplyWritetime()}" pattern = "yyyy-mm-dd HH:mm"/>
				</td>
				<th>
					<!-- 수정과 삭제는 현재 사용자가 남긴 댓글에만 표시하기 -->
					<c:if test = "${loginId == replyDto.getReplyWriter()}">
						<a class="edit-btn">수정</a>
						<br>
						<a href = "reply/delete?replyNo=${replyDto.getReplyNo()}&replyOrigin=${replyDto.getReplyOrigin()}">삭제</a>
					</c:if>
					
					<c:if test="${admin}">
					
						<!-- 블라인드 여부에 따라 다르게 표시 -->
						<c:choose>
							<c:when test = "${replyDto.replyBlind}">
								<a href="reply/blind?replyNo=${replyDto.replyNo}&replyOrigin=${replyDto.replyOrigin}">블라인드<br>해제</a>
							</c:when>
							<c:otherwise>
								<a href="reply/blind?replyNo=${replyDto.replyNo}&replyOrigin=${replyDto.replyOrigin}">블라인드<br>설정</a>
							</c:otherwise>
						</c:choose>
						
					</c:if>
				</th>
			</tr>
			
			<!-- 수정하기 위한 화면 : 댓글 작성자 본인에게만 출력 -->
			<c:if test="${loginId ==  replyDto.replyWriter}">
			<tr class="editor">
				<th colspan="2">
					<form action="reply/edit" method="post">
						<input type="hidden" name="replyNo" value="${replyDto.replyNo}">
						<input type="hidden" name="replyOrigin" value="${replyDto.replyOrigin}">
						<textarea name="replyContent" rows="5" cols="50" required>${replyDto.replyContent}</textarea>
						<button type="submit">변경</button>
						<a class="cancel-btn">취소</a>
					</form>
				</th>
			</tr>
			</c:if>
				
			</c:forEach>
		</tbody>
	</table>

	<%-- 회원일 경우와 아닐 경우 댓글 작성창이 다르게 보이도록 처리 --%>
	<c:choose>
		<c:when test = "${loginId != null}">	<!-- 회원일 경우 -->
			<!-- 댓글 입력창 -->
			<form action = "reply/write" method = "post">
			<input type = hidden name = "replyOrigin" value = "${boardDto.getBoardNo()}">
			<table border = "1" width = "500">
				<tbody>
					<tr>
						<th>
							<textarea name="replyContent" rows = "5" cols = "55" required placeholder = "댓글 내용"></textarea>
						</th>
						<th>
							<button type = "submit">댓글 작성</button>
						</th>
					</tr>
				</tbody>
			</table>
			</form>
		</c:when>
		
		<c:otherwise>	<!-- 비회원일 경우 -->
			<table width="500">
				<tbody>
					<tr>
						<th>
							<textarea name="replyContent" rows="5" cols="55" 
								placeholder="로그인 후 댓글 작성이 가능합니다" disabled></textarea>
						</th>
						<th>
							<button type="submit" disabled>등록</button>
						</th>
					</tr>
				</tbody>
			</table>
		</c:otherwise>
		
	</c:choose>	
</div>

<jsp:include page = "/WEB-INF/views/template/footer.jsp"></jsp:include>