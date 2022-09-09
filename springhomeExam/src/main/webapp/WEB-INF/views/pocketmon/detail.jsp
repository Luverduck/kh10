<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page = "/WEB-INF/views/template/header.jsp">
	<jsp:param value = "No ${dto.getNo()}. ${dto.getName()}의 상세 정보" name = "title"/>
</jsp:include>

	<div align = "center">
		<%-- No 01. 이상해씨 --%>
		<h1>No ${dto.getNo()}. ${dto.getName()}</h1>
		
		<table border = "1" width = "400">
			<tbody>
				<tr>
					<th>번호</th>
					<td>${dto.getNo()}</td>
				</tr>
				<tr>
					<th>이름</th>
					<td>${dto.getName()}</td>
				</tr>
				<tr>
					<th>타입</th>
					<td>${dto.getType()}</td>
				</tr>
			</tbody>
		</table>
		
		<h3><a href = "edit?no=${dto.no}">도감 수정</a></h3>
		<h3><a href = "delete?no=${dto.no}">도감 삭제</a></h3>
		<h3><a href = "list">전체 포켓몬 도감</a></h3>
	</div>

<jsp:include page = "/WEB-INF/views/template/footer.jsp"></jsp:include>