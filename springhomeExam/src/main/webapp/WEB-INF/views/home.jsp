<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%-- header.jsp를 불러와라 --%>
<%-- 동적으로 header.jsp를 불러오는 코드 --%>
<jsp:include page = "/WEB-INF/views/template/header.jsp">
	<jsp:param value = "메인페이지" name = "title"/>
</jsp:include>

<div align = "center">

<h1>어서오세요!</h1>

<br>
<h3>
<a href = "board/list">최근에 작성된 게시글(5~10개)</a>
</h3>
<form action = "/" method = "post">
	<select name = "boardEnd">
		<option <c:if test = "${boardDto.boardHead == '정보'}">selected</c:if>value = "5">5개</option>
		<option value = "6">6개</option>
		<option value = "7">7개</option>
		<option value = "8">8개</option>
		<option value = "9">9개</option>
		<option value = "10">10개</option>
	</select>
	<button type = "submit">검색</button>
</form>

<table border = "1" width = "500">
<tbody align = "center">
	<tr>
		<th>번호		</th>
		<th>제목</th>
		<th>글쓴이</th>
		<th>등록일</th>
		<th>조회수</th>
	</tr>
	<c:forEach var = "boardDto" items = "${boardList}">
	<tr>
		<td>${boardDto.boardNo}</td>
		<td align = "left">${boardDto.boardTitle}</td>
		<td>${boardDto.boardWriter}</td>
		<td>${boardDto.boardWritetime}</td>
		<td>${boardDto.boardRead}</td>
	</tr>
	</c:forEach>
</tbody>
</table>

<br>

<h3>
<a href = "guestbook/list">최근에 등록된 방명록(5~10개)</a>
</h3>

<form action = "/" method = "post">
	<select name = "guestbookEnd">
		<option value = "5">5개</option>
		<option value = "6">6개</option>
		<option value = "7">7개</option>
		<option value = "8">8개</option>
		<option value = "9">9개</option>
		<option value = "10">10개</option>
	</select>
	<button type = "submit">검색</button>
</form>

<table border = "1" width = "500">
<tbody align = "center">
	<tr>
		<th>번호</th>
		<th>작성자</th>
		<th>내용</th>
	</tr>
	<c:forEach var = "guestBookDto" items = "${guestBookList}">
	<tr>
		<td>${guestBookDto.no}</td>
		<td>${guestBookDto.name}</td>
		<td align = "left">	${guestBookDto.memo}</td>
	</tr>
	</c:forEach>
</tbody>
</table>

<br>

<h3>
<a href = "pocketmon/list">최근에 등록된 포켓몬(5~10개)</a>
</h3>

<form action = "/" method = "post">
	<select name = "pocketmonEnd">
		<option value = "5">5개</option>
		<option value = "6">6개</option>
		<option value = "7">7개</option>
		<option value = "8">8개</option>
		<option value = "9">9개</option>
		<option value = "10">10개</option>
	</select>
	<button type = "submit">검색</button>
</form>

<table border = "1" width = "500">
<tbody align = "center">
	<tr>
		<th>번호</th>
		<th>이름</th>
		<th>타입</th>
	</tr>
	<c:forEach var = "pocketMonsterDto" items = "${pocketMonsterList}">
		<tr>
			<td>${pocketMonsterDto.no}</td>
			<td>${pocketMonsterDto.name}</td>
			<td>${pocketMonsterDto.type}</td>
		</tr>
	</c:forEach>
</tbody>
</table>

<br>

<h3>
<a href = "music/list">최근에 등록된 음원(5~10개)</a>
</h3>

<form action = "/" method = "post">
	<select name = "musicEnd">
		<option value = "5">5개</option>
		<option value = "6">6개</option>
		<option value = "7">7개</option>
		<option value = "8">8개</option>
		<option value = "9">9개</option>
		<option value = "10">10개</option>
	</select>
	<button type = "submit">검색</button>
</form>

<table border = "1" width = "500">
<tbody align = "center">
	<tr>
		<th>음원번호</th>
		<th>음원명</th>
		<th>가수명</th>
		<th>발매일</th>
	</tr>
	<c:forEach var = "musicDto" items = "${musicList}">
		<tr>
			<td>${musicDto.musicNo}</td>
			<td>${musicDto.musicTitle}</td>
			<td>${musicDto.musicArtist}</td>
			<td>${musicDto.releaseTitle}</td>
		</tr>
	</c:forEach>
</tbody>
</table>

<br>

<h3>
<a href = "board/list">글을 가장 많이 쓴 회원(5~10개)</a>
</h3>

<form action = "/" method = "post">
	<select name = "memberEnd">
		<option value = "5">5개</option>
		<option value = "6">6개</option>
		<option value = "7">7개</option>
		<option value = "8">8개</option>
		<option value = "9">9개</option>
		<option value = "10">10개</option>
	</select>
	<button type = "submit">검색</button>
</form>

<table border = "1" width = "300">
<tbody align = "center">
	<tr>
		<th>순위</th>
		<th>회원</th>
		<th>작성수</th>
	</tr>
	<c:forEach var = "memberDto" items = "${memberList}">
		<tr>
			<td>${memberDto.boardRank}</td>
			<td>${memberDto.memberId}</td>
			<td>${memberDto.boardCount}</td>
		</tr>
	</c:forEach>
</tbody>
</table>

</div>	

<%-- footer.jsp를 불러와라 --%>
<%-- 동적으로 footer.jsp를 불러오는 코드 --%>
<jsp:include page = "/WEB-INF/views/template/footer.jsp"></jsp:include>