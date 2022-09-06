<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>포켓몬 목록</title>
</head>
<body>

<div align="center">
	<h1>포켓몬 목록</h1>
	<table border = "1" width = 400>
	<thead>
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>타입</th>
		</tr>
	</thead>
	<tbody>
		<%-- <tr> 태그 반복문 --%>
		<%-- 
			for(PocketMonsterDto dto : list){
			}
		--%>
		<c:forEach var = "dto" items = "${list}">
		<tr>
			<%-- 추론(dto.no 방식으로 쓰기)도 가능 --%>
			<td>${dto.no}</td>
			<td>${dto.getName()}</td>
			<td>${dto.getType()}</td>
		</tr>
		</c:forEach>
	</tbody>
	
	</table>
</div>
</body>
</html>