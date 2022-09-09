<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<jsp:include page = "/WEB-INF/views/template/header.jsp">
	<jsp:param value = "전체 방명록" name = "title"/>
</jsp:include>

	<div align = "center">
	
		<h1>방명록</h1>
		
		<form action = "list" method = "get">
			<select name = "type" required>
				<option>name</option>
				<option>memo</option>
				<option>no</option>
			</select>
			<input name = "keyword" required>
			<button>검색</button>
		</form>
		
		<table border = "1", width = "600">
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
				</c:forEach>
			</tbody>
		</table>
		
		<h3><a href = "insert">작성하기</a></h3>
	</div>

<jsp:include page = "/WEB-INF/views/template/footer.jsp"></jsp:include>