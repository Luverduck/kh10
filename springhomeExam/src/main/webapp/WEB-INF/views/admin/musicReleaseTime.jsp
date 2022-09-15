<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page = "/WEB-INF/views/template/adminHeader.jsp">
	<jsp:param name = "title" value = "관리자 페이지"/>
</jsp:include>

<h1>년도별 발매 현황</h1>

<table border = "1" width = "300">
	<thead>
		<tr>
			<th>년도</th>
			<th>발매수</th>
		</tr>
	</thead>
	<tbody align = "center">
		<c:forEach var = "vo" items = "${list}">
			<tr>
				<td>${vo.getMusicYear()}</td>
				<td>${vo.getCnt()}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<jsp:include page = "/WEB-INF/views/template/adminFooter.jsp"></jsp:include>