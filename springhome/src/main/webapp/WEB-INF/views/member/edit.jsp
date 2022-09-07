<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정</title>
</head>
<body>

	<div align = "center">
		<h1>회원 정보 수정</h1>
		<form action = "edit" method = "post">
			<input type = "hidden" name = "memberId" value = "${memberDto.getMemberId()}">
			비밀번호 : <input type = "password" name = "memberPw" value = "${memberDto.getMemberPw()}"><br><br>
			닉네임 : <input type = "text" name = "memberNick" value = "${memberDto.getMemberNick()}"><br><br>
			전화번호 : <input type = "text" name = "memberTel" value = "${memberDto.getMemberTel()}"><br><br>
			이메일 : <input type = "text" name = "memberEmail" value = "${memberDto.getMemberEmail()}"><br><br>
			우편번호 : <input type = "text" name = "memberPost" value = "${memberDto.getMemberPost()}"><br><br>
			기본주소 : <input type = "text" name = "memberBaseAddress" value = "${memberDto.getMemberBaseAddress()}"><br><br>
			상세주소 : <input type = "text" name = "memberDetailAddress" value = "${memberDto.getMemberDetailAddress()}"><br><br>
			포인트 : <input type = "text" name = "memberPoint" value = "${memberDto.getMemberPoint()}"><br><br>
			등급 : <input type = "text" name = "memberGrade" value = "${memberDto.getMemberGrade()}"><br><br>
			<button type = "submit">변경</button>
		</form>
	</div>

</body>
</html>