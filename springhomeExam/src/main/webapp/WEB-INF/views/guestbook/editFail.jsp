<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page = "/WEB-INF/views/template/header.jsp">
	<jsp:param name = "title" value = "오류"/>
</jsp:include>

	<div align = "center">
		<h1>존재하지 않는 방명록 번호입니다</h1>
		<h3><a href = "list">목록으로 이동</a></h3>
	</div>
	
<jsp:include page = "/WEB-INF/views/template/footer.jsp"></jsp:include>