<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page = "/WEB-INF/views/template/header.jsp">
	<jsp:param name = "title" value = "마이 페이지"/>
</jsp:include>

	<div align = "center">
		<h1>마이 페이지</h1>
		
		<h3>아이디 : "${memberDto.getMemberId()}"</h3>
		<h3>닉네임 : ${memberDto.getMemberNick()}</h3>
		<h3>생년월일 : ${memberDto.getMemberBirth()}</h3>
		<h3>연락처 : ${memberDto.getMemberTel()}</h3>
		<h3>이메일 : ${memberDto.getMemberEmail()}</h3>
		<h3>우편주소 : ${memberDto.getMemberPost()}</h3>
		<h3>기본주소 : ${memberDto.getMemberBaseAddress()}</h3>
		<h3>상세주소 : ${memberDto.getMemberDetailAddress()}</h3>
		<h3>포인트 : ${memberDto.getMemberPoint()}</h3>
		<h3>등급 : ${memberDto.getMemberGrade()}</h3>
		<h3>가입일 : ${memberDto.getMemberJoin()}</h3>
		<h3>최종 로그인 : ${memberDto.getMemberLogin()}</h3>
		
		<br>
		
		<h3><a href = "edit?memberId=${memberDto.getMemberId()}">회원 정보 변경</a></h3>
	</div>

<jsp:include page = "/WEB-INF/views/template/footer.jsp"></jsp:include>