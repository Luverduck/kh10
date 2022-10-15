<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page = "/WEB-INF/views/template/header.jsp">
<jsp:param name = "title" value = "회원 정보"/>
</jsp:include>
 
	<div align = "center">
		
		<h1>${memberDto.getMemberId()} 회원 정보</h1>
		
		<table border = "1" width = 400>
			<tbody>
				<tr>
					<th colspan = "2">
						<img src = "download?memberId=${memberDto.memberId}" width = "100" height = "100">
					</th>
				</tr>
				<tr>
					<th width = "25%">아이디</th>
					<td>${memberDto.getMemberId()}</td>
				</tr>
				<tr>
					<th>닉네임</th>
					<td>${memberDto.getMemberNick()}</td>
				</tr>
				<tr>
					<th>생년월일</th>
					<td>${memberDto.getMemberBirth()}</td>
				</tr>
				<tr>
					<th>전화번호</th>
					<td>${memberDto.getMemberTel()}</td>
				</tr>
				<tr>
					<th>이메일</th>
					<td>${memberDto.getMemberEmail()}</td>
				</tr>
				<tr>
					<th>주소</th>
					<td>
						<c:if test="${memberDto.getMemberPost() != null}">
							[${memberDto.getMemberPost()}]
							${memberDto.getMemberBaseAddress()}
							${memberDto.getMemberDetailAddress()}
						</c:if>					
					</td>
				</tr>
				<tr>
					<th>포인트</th>
					<td>
						<fmt:formatNumber pattern="#,##0">${memberDto.getMemberPoint()}</fmt:formatNumber>
					</td>
				</tr>
				<tr>
					<th>등급</th>
					<td>${memberDto.getMemberGrade()}</td>
				</tr>
				<tr>
					<th>가입일</th>
					<td>
						<fmt:formatDate value = "${memberDto.getMemberJoin()}" pattern = "y년 M월 d일 E a h시 m분 s초"/>
					</td>
				</tr>
				<tr>
					<th>마지막 로그인</th>
					<td>
						<fmt:formatDate value = "${memberDto.getMemberLogin()}" pattern = "y년 M월 d일 E a h시 m분 s초"/>
					</td>
				</tr>
			</tbody>
		</table>
		
		<c:choose>
			<c:when test="${mg == '관리자'}">
			<%-- 관리자용 메뉴 --%>
				<h3><a href="list">목록 보기</a></h3>
				<h3><a href="edit?memberId=${memberDto.memberId}">정보 변경</a></h3>
				<h3><a href="exit?memberId=${memberDto.memberId}">회원 탈퇴</a></h3>
			</c:when>
			<%-- 회원용 메뉴 --%>
			<c:otherwise>
				<h3><a href = "/member/password">비밀번호 변경</a></h3>
				<h3><a href = "/member/information?memberId=${memberDto.memberId}">개인정보 변경</a></h3>
				<h3><a href = "/member/goodbye">회원 탈퇴</a></h3>
			</c:otherwise>
		</c:choose>
		<h3><a href = "edit?memberId=${memberDto.getMemberId()}">회원 정보 변경</a></h3>
		<h3><a href = "delete?memberId=${memberDto.getMemberId()}">회원 탈퇴</a></h3>
	</div>

<jsp:include page = "/WEB-INF/views/template/footer.jsp"></jsp:include>