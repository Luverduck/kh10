<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page = "/WEB-INF/views/template/header.jsp">
	<jsp:param name = "title" value = "${guestBookDto.getNo()}번 방명록"/>
</jsp:include>

	<div align = "center">
		<h1>${guestBookDto.getNo()}번 방명록</h1>
		
		<table border = "1" width = "400">
			<tbody>
				<tr>
					<th width = "25%">작성자</th>
					<td>${guestBookDto.getName()}</td>
				</tr>
				
				<tr height = "250" valign = "top">
					<th>내용</th>
					<td>${guestBookDto.getMemo()}</td>
				</tr>
			</tbody>
		</table>
		
		<h3><a href = "edit?no=${guestBookDto.getNo()}">수정하기</a></h3>
		<h3><a href = "delete?no=${guestBookDto.getNo()}">삭제하기</a></h3>
		<h3><a href = "list">전체 방명록 목록</a></h3>
	</div>

<jsp:include page = "/WEB-INF/views/template/footer.jsp"></jsp:include>