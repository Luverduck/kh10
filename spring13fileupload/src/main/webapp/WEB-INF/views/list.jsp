<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:forEach var = "attachmentDto" items = "${list}">

	<h3>
		<%-- 미리보기 표시 --%>
		<img src = "download?attachmentNo=${attachmentDto.attachmentNo}" width = "50" height = "50">
		
		[${attachmentDto.attachmentType}] 
		
		<%-- 업로드된 파일을 다운로드할 수 있도록 하는 하이퍼링크 추가 --%>
		<a href = "download?attachmentNo=${attachmentDto.attachmentNo}">${attachmentDto.attachmentName} </a>
		
		(${attachmentDto.attachmentSize})
	</h3>
</c:forEach>