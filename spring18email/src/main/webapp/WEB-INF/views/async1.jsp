<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script src = "http://code.jquery.com/jquery-3.6.1.min.js"></script>

<script>
	$(function(){
		// 판정 객체 - 인증이 성공할 경우에만 true로 변경
		var judge = {
			emailValid : false,
		};
		
		// 확인 버튼에 대한 click 이벤트 설정
		$(".send-btn").click(function(){
			
			// memberEmail이라는 name을 가진 요소의 value를 변수 email로 지정
			var email = $("[name=memberEmail]").val();
			
			// email의 길이가 0이면(입력되지 않았으면) return
			if(email.length == 0) return;
			
			// 확인 버튼을 변수 btn으로 지정
			var btn = $(this);
			
			// 확인 버튼을 누르면 중복입력을 방지하기 위해 비활성화 설정
			btn.prop("disabled", true);
			
			// 화인 버튼을 클릭할 때 발급된 인증 번호를 등록하기 위한 비동기 통신
			$.ajax({
				url:"${pageContext.request.contextPath}/async2", 
				method : "post",
				data : {who : email},
				success : function(){
					// 성공했다면 메일은 전송되었다고 볼 수 있다
					btn.prop("disabled", false);
					
					// 인증번호 입력창 태그 재구성을 위한 변수 지정
					// <div> 태그를 변수 div로 지정
					var div = $("<div>");
					// <input> 태그를 변수 input으로 지정
					var input = $("<input>");
					// <button> 태그를 변수 button으로 지정
					// - type을 "button"으로, 태그 사이의 text를 "검사"로 지정
					var button = $("<button>").attr("type", "button").text("검사");
					
					// div에 input와 button 추가
					div.append(input).append(button);
					
					// 클래스명이 cert인 <div> 태그 안에 html(innerHtml)로 태그 생성
					$(".cert").html(div);
					
					// 검사 버튼에 대한 click 이벤트 설정
					button.click(function(){
						// input 태그에 입력되어있는 값을 변수 serial로 지정 
						var serial = input.val();
						
						// 만약 serial의 길이가 6이 아니라면(비정상 입력) return
						if(serial.length != 6) return;
						
						// 인증번호 확인에 대한 ajax
						$.ajax({
							url:"${pageContext.request.contextPath}/async3",
							method:"post",
							data : {who : email, serial : serial},
							success:function(resp){
								// checkCert(CertDto certDto)의 결과를 
								// judge의 emailValid 값으로 저장 
								judge.emailValid = resp;
								// 더이상 인증메일을 보내지 못하도록 
								// 확인 버튼(인증메일 전송 버튼)을 비활성화
								btn.prop("disabled", true);	
							}
						});
					});
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

<form class = "join-form">
	이메일 : <input type = "text" name = "memberEmail">
	<button class = "send-btn">확인</button>
	<div class = "cert"></div>
	
	<button type = "submit">가입</button>
</form>