<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<h1>결제 내역 조회</h1>

<c:forEach var="paymentDto" items="${list}">
<div>
	상품명 : ${paymentDto.itemName} <br>
	결제금액 : <fmt:formatNumber value="${paymentDto.totalAmount}" 
						pattern="#,##0"/> 원 <br>
	결제시각 : <fmt:formatDate value="${paymentDto.approveAt}" 
						pattern="y년 M월 d일 E H시 m분 s초"/> 
	<br>
	<a href="detail?paymentNo=${paymentDto.paymentNo}">더보기</a>
</div>
</c:forEach>