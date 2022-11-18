<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>결제 상세 정보</h1>
<h2><a href="${pageContext.request.contextPath}/">홈</a></h2>
<h2><a href="list">목록</a></h2>

<!-- 우리 DB에 있는 정보 -->
<div>
	<h1>대표 정보</h1>
	<ul>
		<li>paymentNo : ${paymentDto.paymentNo}</li>
		<li>itemName : ${paymentDto.itemName}</li>
		<li>totalAmount : ${paymentDto.totalAmount}</li>
		<li>approveAt : ${paymentDto.approveAt}</li>
		<li>paymentStatus : ${paymentDto.paymentStatus}</li>
		<li>tid : ${paymentDto.tid}</li>
	</ul>
	<h2><a href="">취소</a></h2>
</div>

<div>
	<h1>세부 내역</h1>
	<ul>
		<c:forEach var="paymentDetailDto" items="${paymentDetailList}">
		<li>
			${paymentDetailDto.productName}
			(${paymentDetailDto.qty}개)
			-
			${paymentDetailDto.productPrice}원
			[${paymentDetailDto.paymentDetailStatus}]
			<a href="">취소</a>
		</li>
		</c:forEach>
	</ul>
</div>

<!-- 카카오페이에서 조회한 정보 -->
<h1>카카오페이 조회 정보</h1>
<ul>
	<li>거래번호 : ${info.tid}</li>
	<li>
		결제상태 : 
		<c:choose>
			<c:when test="${info.status == 'SUCCESS_PAYMENT'}">결제 완료</c:when>
			<c:when test="${info.status == 'PART_CANCEL_PAYMENT'}">부분 취소</c:when>
			<c:when test="${info.status == 'CANCEL_PAYMENT'}">전체 취소</c:when>
			<c:otherwise>알 수 없음(관리자에게 문의)</c:otherwise>
		</c:choose>
	</li>
	<li>주문번호 : ${info.partner_order_id}</li>
	<li>
		결제방법 :
		<c:choose>
			<c:when test="${info.payment_method_type == 'CARD'}">카드</c:when>
			<c:otherwise>현금</c:otherwise>
		</c:choose> 
	</li>
	<li>
		결제금액 : 
		총 ${info.amount.total} 원 , 
		취소 ${info.canceled_amount.total} 원, 
		잔액 ${info.cancel_available_amount.total} 원
	</li>
	<li>상품명 : ${info.item_name}</li>
	<li>
		내역 : 
		<ul>
			<c:forEach var="detailsVO" items="${info.payment_action_details}">
				<li>${detailsVO}</li>
			</c:forEach>
		</ul>
	</li>
</ul>
<div>${info}</div>