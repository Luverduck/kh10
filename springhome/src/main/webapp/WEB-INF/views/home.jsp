<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%-- header.jsp를 불러와라 --%>
<%-- 동적으로 header.jsp를 불러오는 코드 --%>
<jsp:include page = "/WEB-INF/views/template/header.jsp">
	<jsp:param value = "메인페이지" name = "title"/>
</jsp:include>

	<h1>어서오세요!</h1>

<%-- footer.jsp를 불러와라 --%>
<%-- 동적으로 footer.jsp를 불러오는 코드 --%>
<jsp:include page = "/WEB-INF/views/template/footer.jsp"></jsp:include>