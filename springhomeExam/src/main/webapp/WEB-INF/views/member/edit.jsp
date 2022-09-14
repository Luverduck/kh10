<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page = "/WEB-INF/views/template/header.jsp">
	<jsp:param name = "title" value = "회원 정보 수정"/>
</jsp:include>
 
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
			<button type = "submit">변경</button>
		</form>
	</div>

<jsp:include page = "/WEB-INF/views/template/footer.jsp"></jsp:include>