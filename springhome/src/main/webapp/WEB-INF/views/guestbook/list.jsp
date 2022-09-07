<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전체 방명록</title>
</head>
<body>

	<div align = "center">
		<h1>방명록
		<a href = "insert">작성하기</a>
		</h1>
		
		<!-- 
			검색을 위한 검색창 
			- <Select>는 주어진 <option> 중에서만 선택이 가능하도록 하는 태그
		-->
		<!--  <form action = "/guestbook/list"> -->
		<form action = "list" method = "get">
			<select name = "type" required>
				<option>name</option>
				<option>memo</option>
				<option>no</option>
			</select>
			<input name = "keyword" required>
			<button>검색</button>
		</form>
		
		<br><br>
		
		<table border = "1", width = "600">
	<!--	<thead>
				<tr>
					<th>번호</th>
					<th>이름</th>
					<th>메모</th>
				</tr>
			</thead>
	-->

			<tbody> 
				<c:forEach var = "guestBookDto" items = "${list}">
				<tr>
					<td>${guestBookDto.getNo()}</td>
					<td>${guestBookDto.getName()}</td>
					<td>
						<a href = "detail?no=${guestBookDto.getNo()}">
							<img src = "/image/go.png" width = 20 height = 20>
						</a>
					</td>
				</tr>
				<!-- 
				<tr height = "80" valign = "top">
					<td colspan = "2">${guestBookDto.getMemo()}</td>
				</tr>
				 -->
				</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>