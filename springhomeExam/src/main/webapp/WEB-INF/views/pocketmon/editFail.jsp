<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page = "/WEB-INF/views/template/header.jsp">
	<jsp:param value = "도감 수정 실패" name = "title"/>
</jsp:include>

	<div align = "center">
		<h1>도감 수정 실페</h1>
		
		<h3>존재하지 않는 포켓몬 번호입니다</h3>
		
		<br>
		<h3><a href = "list">전체 포켓몬 도감</a></h3>
	</div>

<jsp:include page = "/WEB-INF/views/template/footer.jsp"></jsp:include>