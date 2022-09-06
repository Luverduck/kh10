<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 
	Java에서
	for(PocketMonsterDto dto : list){
		System.out.println(dto);
	} 
-->

<%@ taglib prefix="kh" uri="http://java.sun.com/jsp/jstl/core" %>
<kh:forEach var="dto" items="${list}">
	<h1>${dto}</h1>
</kh:forEach>