<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>입력 화면</title>
</head>
<body>
	<!-- 
		입력창은 <input> 태그로 만든다 
		- 종료 태그를 사용하지 않는다
		- 한 줄 입력만 가능
		- name을 부여하여 전송 시의 파라미터 명을 지정할 수 있다
		
		버튼은 <butto> 태그로 만든다
		
		폼은 <form> 태그로 만든다
		- 입력창과 버튼을 한 덩어리로 묶을 수 있다
		- action 속성으로 form이 전송될 목적지를 설정할 수 있다
	-->
	
	<form action = https://www.genie.co.kr/search/searchMain>
		<input name = "query">
		<button>검색</button>
	</form>
</body>
</html>