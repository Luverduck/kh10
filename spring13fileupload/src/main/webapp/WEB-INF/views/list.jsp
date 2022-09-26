<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:forEach var = "attachmentDto" items = "${list}">
	<h3>
		<!-- 미리보기(썸네일) -->
		<img src = "download?attachmentNo=${attachmentDto.attachmentNo}" width = "50" height = "50">
		
		[${attachmentDto.attachmentType}] 
		
		<a href = "download?attachmentNo=${attachmentDto.attachmentNo}">${attachmentDto.attachmentName} </a>
		
		(${attachmentDto.attachmentSize})
	</h3>
</c:forEach>