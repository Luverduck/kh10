<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!-- 현재 시간 구하기 -->
<jsp:useBean id="now" class="java.util.Date"></jsp:useBean>
<c:set var="today">
	<fmt:formatDate value="${now}" pattern="yyyy-MM-dd"/>
</c:set>

<h3>${vo}</h3>

<jsp:include page = "/WEB-INF/views/template/header.jsp">
	<jsp:param name = "title" value = "게시글 목록"/>
</jsp:include>

<div align = "center">
	<h1>전체 게시글</h1>	
	<table border = "1" width = 900>
		<thead>
			<tr>
			<!-- 관리자일 때만 체크박스란 추가 -->
			<c:if test = "${mg == '관리자'}">
			<th>
				<input type = "checkbox" class = "check-all">
			</th>
				</c:if>
				<th>번호</th>
				<th width = "45%">제목</th>
				<th>글쓴이</th>
				<th>등록일</th>
				<th>조회수</th>
				<th>추천수</th>
				<th>그룹</th>
				<th>부모</th>
				<th>차수</th>
			</tr>
		</thead>
		
		<tbody align = "center">
			<c:forEach var = "boardDto" items = "${list}">
				<tr>
				<!-- 관리자일 때만 체크박스란 추가 -->
				<c:if test = "${mg == '관리자'}">
					<th>
						<input type = "checkbox" class = "check-item">
					</th>
				</c:if>
					
					<td>${boardDto.getBoardNo()}</td>					
					<td align = "left">
						<!-- 차수만큼 띄어쓰기를 반복 -->
						<c:forEach var = "i" begin = "1" end = "${boardDto.getBoardDepth()}">
							&nbsp;&nbsp;
						</c:forEach>
						
						<!-- 말머리 출력(있을 경우에만 -->
						<c:if test = "${boardDto.getBoardHead() != null}">
						[${boardDto.getBoardHead()}]
						</c:if>
						<a href = "detail?boardNo=${boardDto.boardNo}">
						${boardDto.getBoardTitle()}
						</a>
						
						<!-- 댓글 개수 출력 -->
						<c:if test="${boardDto.replyCount > 0}">
							[${boardDto.replyCount}]
						</c:if>
						
						<c:if test = "${boardDto.getBoardLike() > 0}">
							♥ ${boardDto.getBoardLike()}
						</c:if>
					</td>
					<td>${boardDto.getBoardWriter()}</td>
					<td>
						<c:set var="current">
							<fmt:formatDate value="${boardDto.boardWritetime}" pattern="yyyy-MM-dd"/>
						</c:set>
						<c:choose>
							<c:when test="${today == current}">
								<fmt:formatDate value="${boardDto.boardWritetime}" pattern="HH:mm"/>
						</c:when>
							<c:otherwise>
								<fmt:formatDate value="${boardDto.boardWritetime}" pattern="yyyy-MM-dd"/>
							</c:otherwise>
						</c:choose>
					</td>
					<td>${boardDto.getBoardRead()}</td>
					<td>${boardDto.getBoardLike()}</td>
					<td>${boardDto.getBoardGroup()}</td>
					<td>${boardDto.getBoardParent()}</td>
					<td>${boardDto.getBoardDepth()}</td>
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
	<h4>
		<c:choose>
			<c:when test = "${not vo.isFirst()}">	
				<a href = "list?p=${vo.firstBlock()}&${vo.parameter()}">&laquo;</a>
			</c:when>
			<c:otherwise>
				<a href = "#">&laquo;</a>
			</c:otherwise>
		</c:choose>
	
		<!-- 이전을 누르면 이전 구간의 마지막 페이지로 안내 -->
		<c:choose>
			<c:when test = "${vo.hasPrev()}">	<!-- 이전 페이지가 있으면 이전 페이지 이동 -->
				<a href = "list?p=${vo.prevBlock()}&${vo.parameter()}">&lt; </a> 
			</c:when>
			<c:otherwise>
				<a href = "#">&lt; </a> <!-- 이전 페이지가 없으면(1페이지면) 그대로 -->
			</c:otherwise>
		</c:choose>
		
		<c:forEach var = "i" begin = "${vo.startBlock()}" end = "${vo.endBlock()}" step = "1">
			<a href = "list?p=${i}&${vo.parameter()}">${i}</a>
		</c:forEach>
		
		<!-- 다음을 누르면 다음 구간의 마지막 페이지로 안내 -->
		<c:choose>
			<c:when test = "${vo.hasNext()}">	<!-- 다음 페이지가 있으면 다음 페이지 이동 -->
				<a href = "list?p=${vo.nextBlock()}&${vo.parameter()}">&gt;</a> 
			</c:when>
			<c:otherwise>	<!-- 다음 페이지가 없으면(마지막 페이지이면) 그대로 -->
				<a href = "">&gt;</a>	
			</c:otherwise>
		</c:choose>
		
		<c:choose>
			<c:when test = "${not vo.isLast()}">
				<a href = "list?p=${vo.lastBlock()}&${vo.parameter()}">&raquo;</a>
			</c:when>
			<c:otherwise>
				<a href ="">&raquo;</a>
			</c:otherwise>
		</c:choose>
		
	</h4>
	
	<!-- 검색창 -->
	<form action = "list" method = "get">
		<select name = "type" required>
			<option value="board_title" <c:if test="${vo.type == 'board_title'}">selected</c:if>>제목</option>
			<option value="board_title" <c:if test="${vo.type == 'board_content'}">selected</c:if>>내용</option>
			<option value="board_title" <c:if test="${vo.type == 'board_writer'}">selected</c:if>>작성자</option>
		</select>
		<input type = "search" name = "keyword" placeholder = "검색어" required value = "${vo.getKeyword()}">
		<button type = "submit">검색</button>
	</form>
</div>

<jsp:include page = "/WEB-INF/views/template/footer.jsp"></jsp:include>