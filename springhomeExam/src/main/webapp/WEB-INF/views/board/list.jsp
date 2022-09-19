<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!-- 현재 시간 구하기 -->
<jsp:useBean id="now" class="java.util.Date"></jsp:useBean>
<c:set var="today">
	<fmt:formatDate value="${now}" pattern="yyyy-MM-dd"/>
</c:set>

<jsp:include page = "/WEB-INF/views/template/header.jsp">
	<jsp:param name = "title" value = "게시글 목록"/>
</jsp:include>

<div align = "center">
	<h1>전체 게시글</h1>	
	<table border = "1" width = 900>
		<thead>
			<tr>
				<th>번호</th>
				<th width = "45%">제목</th>
				<th>글쓴이</th>
				<th>등록일</th>
				<th>조회수</th>
				<th>추천수</th>
			</tr>
		</thead>
		
		<tbody align = "center">
			<c:forEach var = "boardDto" items = "${list}">
				<tr>
					<td>${boardDto.getBoardNo()}</td>					
					<td align = "left">
						<!-- 말머리 출력(있을 경우에만 -->
						<c:if test = "${boardDto.getBoardHead() != null}">
						[${boardDto.getBoardHead()}]
						</c:if>
						<a href = "detail?boardNo=${boardDto.boardNo}">
						${boardDto.getBoardTitle()}
						</a>
					</td>
					<td>${boardDto.getBoardWriter()}</td>
					<td>
						<c:set var="current">
							<fmt:formatDate value = "${boardDto.getBoardWritetime()}"/>
						</c:set>
						<c:choose>
							<c:when test = "${today == current}">
								<fmt:formatDate value = "${boardDto.getBoardWritetime()}" pattern = "HH:mm"/>
							</c:when>
							<c:otherwise>
								<fmt:formatDate value = "${boardDto.getBoardWritetime()}" pattern = "yyyy-MM-dd"/>
							</c:otherwise>
						</c:choose>
					</td>
					<td>${boardDto.getBoardRead()}</td>
					<td>${boardDto.getBoardLike()}</td>
				</tr>
			</c:forEach>
		</tbody>
		<tfoot>
			<tr align="right">
				<td colspan="6">
					<a href = "/board/write">글쓰기</a>
				</td>
			</tr>
		</tfoot>
	</table>
	<!-- 페이지 네비게이터 -->
	<h4>&laquo; &lt; 이전 1 2 3 4 5 6 7 8 9 10 다음 &gt; &raquo;</h4>
	<!-- 검색창 -->
	<form action = "list" method = "get">
		<select name = "type" required>
			<option value = "board_title"><c:if test = "${vo.type == 'board_title'}">selected</c:if>제목</option>
			<option value = "board_content"><c:if test = "${vo.type == 'board_content'}">selected</c:if>내용</option>
			<option value = "board_writer"><c:if test = "${vo.type == 'board_writer'}">selected</c:if>작성자</option>
		</select>
		<input type = "search" name = "keyword" placeholder = "검색어" required value = "${vo.getKeyword()}">
		<button type = "submit">검색</button>
	</form>
</div>

<jsp:include page = "/WEB-INF/views/template/footer.jsp"></jsp:include>