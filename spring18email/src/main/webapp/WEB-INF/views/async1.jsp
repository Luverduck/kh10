<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script src = "http://code.jquery.com/jquery-3.6.1.min.js"></script>

<script>
	$(function(){
		// 판정 객체
		var judge = {
			emailValid : false,
			
		};
		
		// 목표 : 확인 버튼을 누르면 이메일 발송 컨트롤러로 비동기 요청
		$(".send-btn").click(function(){
			
			var email = $("[name=memberEmail]").val();
			
			if(email.length == 0) return;
			
			var btn = $(this);
			btn.prop("disabled", true); // 신호를 보낼 때 중복입력 방지
			
			$.ajax({
				url:"${pageContext.request.contextPath}/async2", // 비동기 통신시 절대경로 권장
				method : "post",
				data : {who : email},
				success : function(){
					// 성공했다면 메일은 전송되었다고 볼 수 있다
					console.log("메일 전송 완료");
					btn.prop("disabled", false);
					
					// 인증번호 입력창을 사용자에게 보여줘야 한다
					// (1) 새로 구성 (2) 만들어진 태그 숨김 -> 숨김해제
					
					var div = $("<div>");
					var input = $("<input>");
					var button = $("<button>").attr("type", "button").text("검사");
					
					// button을 클릭하면 input에 있는 인증번호와 이메일을 사용해서 검사요청
					button.click(function(){
						// input 태그에 입력되어있는 값 지정 = serial 
						var serial = input.val();
						if(serial.length != 6) return; // serial이 6글자가 아니면 return
						
						// 인증번호 확인에 대한 ajax
						$.ajax({
							url:"${pageContext.request.contextPath}/async3",
							method:"post",
							data : {who : email, serial : serial},
							success:function(resp){
								// console.log(resp);
								// resp가 true이면 이메일 인증이 성공한 것
								judge.emailValid = resp;
								// 결과를 외부에 저장하고 더이상 인증버튼을 누르지 못하도록 설정
								btn.prop("disabled", true);	
							}
						});
					});
					
					// div에 input와 button 추가
					div.append(input).append(button);
					$(".cert").html(div);
				}
			});
		});
		
		// form이 전송될 때 판정 객체(judge)의 상태가 어떤지 출력
		$(".join-form").submit(function(){
			console.log(judge);
			return false;
		});
	});
</script>

<h1>회원가입</h1>

<!-- 이 form은 회원가입을 위한 폼이다 -->
<form class = "join-form">
	이메일 : <input type = "text" name = "memberEmail">
	<button class = "send-btn">확인</button>
	<div class = "cert"></div>
	
	<button type = "submit">가입</button>
</form>