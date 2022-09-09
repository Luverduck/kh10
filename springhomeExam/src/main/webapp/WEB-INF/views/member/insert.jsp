<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page = "/WEB-INF/views/template/header.jsp">
	<jsp:param name = "title" value = "회원 가입"/>
</jsp:include>

	<div align = "center">
		<h1>가입 정보 입력</h1>
		<form action = "insert" method = "post">
			아이디 : <input name ="memberId" placeholder = "아이디 입력" type = "text" required><br><br>
			<!-- 비밀번호는 type을 password로 한다 -->
			비밀번호 : <input name ="memberPw" placeholder = "비밀번호 입력" type = "password" required ><br><br>
			닉네임 : <input name ="memberNick" placeholder = "닉네임 입력" type = "text" required><br><br>
			생년월일 : <input name ="memberBirth" placeholder = "생년월일 입력" type = "date" required><br><br>
			연락처(선택) : <input name ="memberTel" placeholder = "연락처 입력" type = "text"><br><br>
			이메일(선택) : <input name ="memberEmail" placeholder = "이메일 입력" type = "text"><br><br>
			우편번호(선택) : <input name ="memberPost" placeholder = "우편주소 입력" type = "text" maxlength = "6" size = "6"><br><br>
			기본주소(선택) : <input name ="memberBaseAddress" placeholder = "기본주소 입력" type = "text"><br><br>
			상세주소(선택) : <input name ="memberDetailAddress" placeholder = "상세주소 입력" type = "text"><br><br>
			<button>등록</button>
		</form>
	</div>

<jsp:include page = "/WEB-INF/views/template/footer.jsp"></jsp:include>