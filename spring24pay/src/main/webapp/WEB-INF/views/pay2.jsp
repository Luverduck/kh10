<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<h1>골라서 결제</h1>

<c:forEach var = "productDto" items = "${list}">
	<div>
		<!-- 체크 박스와 수량 입력란을 생성 -->
		<input type = "checkbox" class = "item-check" data-no = "${productDto.no}">
		<input type = "number" class = "item-qty" data-no = "${productDto.no}" value = "0">
		${productDto.no} /
		${productDto.name} /
		${productDto.type} /
		${productDto.price} /
		${productDto.made} /
		${productDto.expire} /
	</div>
</c:forEach>

<button class = "purchase-btn">구매하기</button>

<!-- JQuery CDN -->
<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>

<script>
	$(function(){
		// 구매하기 버튼에 클릭 이벤트 설정
		$(".purchase-btn").click(function(){
			
			// POST 방식의 form 태그 지정
			var form = $("<form>").attr("method", "post");
			
			// 값을 배열 형태로 전송하기 위한 배열 index 카운트
			var count = 0;
			
			// 체크박스 각각에 대해
			$(".item-check").each(function(){
				
				// 체크 여부를 변수로 지정
				var checked = $(this).prop("checked");
				
				// 체크 박스가 체크되어 있다면
				if(checked) {
					
					// 체크된 상품의 상품 번호를 변수로 지정
					var no = $(this).data("no");
					
					// 체크된 상품의 상품 갯수를 변수로 지정
					var qty = $(".item-qty[data-no="+ no +"]").val();
					
					// 배열 형태로 값을 전달
					// <input type = "hidden" name = "data[i].no"> 형태이며 값은 no의 값
					var noTag = $("<input>").attr("type", "hidden").attr("name", "data[" + count + "].no").val(no);
					// <input type = "hidden" name = "data[i].qty"> 형태이며 값은 qty의 값
					var qtyTag = $("<input>").attr("type", "hidden").attr("name", "data[" + count + "].qty").val(qty);
					
					// form 태그에 해당 input 태그를 연결
					form.append(noTag).append(qtyTag);
					
					// 배열 index 카운트를 증가
					count ++;
				}
			});
			
			// 최종 완성된 form 태그를 body에 생성
			$("body").append(form);
			
			// form 전송
			form.submit();
		});
	});
</script>