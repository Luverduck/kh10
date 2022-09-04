<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방명록 등록</title>
</head>
<body>
	<h1>방명록 등록</h1>
		<!-- form을 보낼 주소를 안적으면 현재 페이지로 전송 -->
		<form action = "insert" method = "post">
		<input name = "name" placeholder = "닉네임" type = "text" required><br><br>
		<input name = "memo" placeholder = "내용" type = "text" required><br><br>
		<button>등록</button>
	</form>
</body>	
</html>