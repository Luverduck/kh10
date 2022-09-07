<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방명록 정보 수정</title>
</head>
<body>

	<div align = "center">
		<h1>방명록 정보 수정</h1>
		<form action = "edit" method = "post">
			<input type = "hidden" name = "no" required value = "${guestBookDto.getNo()}">
			작성자 : <input type = "text" name = "name" required value = "${guestBookDto.getName()}"><br><br>
			메모 : <input type = "text" name = "memo" required value = "${guestBookDto.getMemo()}"><br><br>
			<button type = "submit">수정</button>
		</form>
	</div>

</body>
</html>