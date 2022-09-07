<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8">
<title>음원 목록</title>
</head>
<body>

<div align="center">
	<!-- 제목 -->
	<h1>음원 목록 조회</h1>
	
	<!-- 음원 검색창 (검색일 떄는 method를 get으로 한다) -->
	<form action = "list" method = "get">
	<!-- 항목 -->
	<select name = "type" required>
		<!-- 
			보여지는 글자와 전송할 글자를 분리하여 작성 
			value - 실제 전송되는 값
		-->
		<option value = "music_title">음원명</option>
		<option value = "music_artist">가수명</option>
		<option value = "music_album">앨범명</option>
		
	</select>
	<!-- 키워드 -->
	<input name = "keyword" placeholder = "검색어" required><br><button>검색</button>
	</form>
	
	<hr>
	
	<!-- 목록 출력 -->
	<table border = "1" width = "600">
		<thead>
			<tr>
				<th>음원번호</th>
				<th>음원명</th>
				<th>가수명</th>
				<th>앨범명</th>
				<th>재생수</th>
				<th>발매일</th>
			</tr>
		</thead>
		
		<tbody>
			<!-- 반복문 -->
			<c:forEach var="musicDto" items="${list}">
				<tr height = "10" valign = "top">
					<td>${musicDto.getMusicNo()}</td>
					<td>
						<a href = "detail?musicNo=${musicDto.getMusicNo()}">
							${musicDto.getMusicTitle()}
						</a>
						<!-- 만약 조회수가 3 이상이면 인기곡이라는 문구가 붙도록 -->
						<c:if test="${musicDto.musicPlay >= 3}">
							<img src = "/image/hot.png" width="20" height="20"> 
						</c:if>
					</td>
					<td>${musicDto.getMusicArtist()}</td>
					<td>${musicDto.getMusicAlbum()}</td>
					<td>${musicDto.getMusicPlay()}</td>
					<td>${musicDto.getReleaseTitle()}</td>
				</tr>
			</c:forEach>
		</tbody>
		
		<tfoot align = "right">
			<tr>
				<td colspan = "6">
					<a href = "insert">음원 등록</a><br>
				</td>
			</tr>
		</tfoot>
	</table>
</div>

</body>
</html>