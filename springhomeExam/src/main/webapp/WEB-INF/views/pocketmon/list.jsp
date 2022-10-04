<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page = "/WEB-INF/views/template/header.jsp">
	<jsp:param value = "포켓몬 도감" name = "title"/>
</jsp:include>
 
<div class = "container-600 mt-40">
	<div class = "row center">
		<h1>포켓몬 도감</h1>
	</div>
	
	<div class = "row center">
		<table class = "table table-border table-hover">
			<thead>
				<tr style = "background-color: #dfe6e9;">
					<th>번호</th>
					<th>이름</th>
					<th>타입</th>
				</tr>
			</thead>
			<tbody class = "center">
				<%-- <tr> 태그 반복문 --%>
				<%-- 
					for(PocketMonsterDto dto : list){
					}
				--%>
				<c:forEach var = "dto" items = "${list}">
				<tr>
					<%-- 추론(dto.no 방식으로 쓰기)도 가능 --%>
					<td>${dto.no}</td>
					<td>
						<a href = "detail?no=${dto.getNo()}" style = "color: inherit; text-decoration: none;">
							${dto.getName()}
						</a>
					</td>
					<td>${dto.getType()}</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div class = "row">
		<a href = "insert">포켓몬 도감 등록</a><br>
		<a href = "/">홈으로 돌아가기</a>
	</div>
</div>

<jsp:include page = "/WEB-INF/views/template/footer.jsp"></jsp:include>