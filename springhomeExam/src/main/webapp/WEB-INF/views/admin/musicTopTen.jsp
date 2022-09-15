<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<jsp:include page = "/WEB-INF/views/template/adminHeader.jsp">
	<jsp:param name = "title" value = "음원 재생 순위"/>
</jsp:include>

<h1>음원 재생 순위</h1>

<table border = "1" width = "300">
	<thead>
		<tr>
			<th>순위</th>
			<th>음원명</th>
			<th>가수명</th>
			<th>재생수</th>
		</tr>
	</thead>
	<tbody align = "center">
		<c:forEach var = "musicDto" items = "${list}">
			<tr>
				<td>${status.count}</td>
				<td>${musicDto.getMusicTitle()}</td>
				<td>${musicDto.getMusicArtist()}</td>
				<td>${musicDto.getMusicPlay()}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<jsp:include page = "/WEB-INF/views/template/adminFooter.jsp"></jsp:include>