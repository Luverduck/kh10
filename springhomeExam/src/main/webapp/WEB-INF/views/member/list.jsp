<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page = "/WEB-INF/views/template/header.jsp">
	<jsp:param name = "title" value = "회원 조회"/>
</jsp:include>

	<div align = "center">
		
		<!-- 제목 -->
		<h1>회원 조회</h1>
		
		<!-- 검색창 -->
		<form action = "list" method = "get" >
			<%--
				- c:if는 단일 조건을, c:choose는 그룹 조건(if~else if~else)을 구현할 수 있다 
				- EL에서는 모든 데이터가 비교 연산으로 비교가 가능하다
				- 따옴표 1개와 2개를 구분하지 않는다
			--%>
			<c:choose>
				<c:when test="${param.type == 'member_nick'}">
					<select name = "type" required>
						<option value = "member_id">아이디</option>
						<option value = "member_nick" selected = "selected">닉네임</option>
						<option value = "member_tel">전화번호</option>
						<option value = "member_email">이메일</option>
						<option value = "member_grade">등급</option>
					</select>
				</c:when>	
				<c:when test="${param.type == 'member_tel'}">
					<select name = "type" required>
						<option value = "member_id">아이디</option>
						<option value = "member_nick">닉네임</option>
						<option value = "member_tel" selected>전화번호</option>
						<option value = "member_email">이메일</option>
						<option value = "member_grade">등급</option>
					</select>
				</c:when>
				<c:when test="${param.type == 'member_email'}">
					<select name = "type" required>
						<option value = "member_id">아이디</option>
						<option value = "member_nick">닉네임</option>
						<option value = "member_tel">전화번호</option>
						<option value = "member_email" selected>이메일</option>
						<option value = "member_grade">등급</option>
					</select>
				</c:when>
				<c:when test="${param.type == 'member_grade'}">
					<select name = "type" required>
						<option value = "member_id">아이디</option>
						<option value = "member_nick">닉네임</option>
						<option value = "member_tel">전화번호</option>
						<option value = "member_email">이메일</option>
						<option value = "member_grade" selected>등급</option>
					</select>
				</c:when>
				<c:otherwise>
					<select name = "type" required>
						<option value = "member_id" selected>아이디</option>
						<option value = "member_nick">닉네임</option>
						<option value = "member_tel">전화번호</option>
						<option value = "member_email">이메일</option>
						<option value = "member_grade">등급</option>
					</select>
				</c:otherwise>
			</c:choose>
			<!-- - 검색 후 해당 검색어가 검색창에 남아있도록 -> ${param.keyword} -->
			<!-- - 파라미터에 접근할 경우 param 키워드를 사용한다 -->
			<input name = "keyword" type = "search" placeholder = "검색어" required value = "${param.keyword}">
			<button type = "submit">검색</button>
		</form><br>
		
		<!-- 
			button을 type을 submit(전송용 버튼)과 button(일반 버튼)으로 설정할 수 있다 
		-->
	
		<!-- 테이블 -->
		<table border = "1" width = 900>
			<thead>
				<tr>
					<th>회원 아이디</th>
					<th>닉네임</th>
					<th>생년월일</th>
					<th>전화번호</th>
					<th>이메일</th>
					<th>등급</th>
					<th>상세정보</th>
				</tr>
			</thead>
				
			<tbody align = "center">
				<c:forEach var = "memberDto" items = "${list}">
					<tr>
						<td>${memberDto.getMemberId()}</td>
						<td>${memberDto.getMemberNick()}</td>
						<td>${memberDto.getMemberBirth()}</td>
						<td>${memberDto.getMemberTel()}</td>
						<td>${memberDto.getMemberEmail()}</td>
						<td>${memberDto.getMemberGrade()}</td>
						<td>
							<a href = "detail?memberId=${memberDto.getMemberId()}">상세</a>
							<a href = "edit?memberId=${memberDto.getMemberId()}">수정</a>
							<a href = "delete?memberId=${memberDto.getMemberId()}">삭제</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
			
			<tfoot>
				<tr>
					<td colspan = "7" align = "right">총 ?개의 결과</td>
				</tr>
			</tfoot>
		</table>
		
		<h2><a href = "/">메인 페이지로 돌아가기</a></h2>
	</div>

<jsp:include page = "/WEB-INF/views/template/footer.jsp"></jsp:include>