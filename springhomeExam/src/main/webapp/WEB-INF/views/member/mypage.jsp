<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page = "/WEB-INF/views/template/header.jsp">
	<jsp:param name = "title" value = "마이 페이지"/>
</jsp:include>

	<div align = "center">
		<h1>마이 페이지</h1>
		
		<!-- 프로필 이미지를 출력 -->
		<img src = "download?memberId=${memberDto.memberId}" width = "100" height = "100">
		
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
		<h3>가입일 : <fmt:formatDate value="${memberDto.memberJoin}" pattern="y년 M월 d일 E a h시 m분 s초"/></h3>
		<h3>최종 로그인 : <fmt:formatDate value="${memberDto.memberLogin}" pattern="y년 M월 d일 E a h시 m분 s초"/></h3>
		
		<br>
		
		<c:choose>
			<c:when test="${mg == '관리자'}">
				<!-- 관리자용 메뉴 -->
				<h2><a href = "list">목록 보기</a></h2>
				<h3><a href = "edit?memberId=${memberDto.getMemberId()}">회원 정보 변경</a></h3>
			</c:when>
			<c:otherwise>
				<!-- 회원용 메뉴 -->
				<h3><a href = "/member/information">개인 정보 변경</a></h3>
				<h3><a href = "/member/password">비밀번호 변경</a></h3>
				<h3><a href = "/member/goodbye">회원 탈퇴</a></h3>
			</c:otherwise>
		</c:choose>
		
		<br>
		
		<h3>내가 작성한 게시글</h3>
		<table border = "1" width = 900>
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성일</th>
				<th>조회수</th>
				<th>좋아요</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var = "boardDto" items = "${myBoardList}">
			<tr>
				<td>${boardDto.boardNo}</td>
				<td>${boardDto.boardTitle}</td>
				<td>${boardDto.boardWritetime}</td>
				<td>${boardDto.boardRead}</td>
				<td>${boardDto.boardLike}</td>
			</tr>
			</c:forEach>
		</tbody>
		</table>
		
		<br>
		
		<h3>내가 좋아요한 작성글</h3>
		<table border = "1" width = 900>
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성일</th>
				<th>조회수</th>
				<th>좋아요</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var = "likeDto" items = "${myLikeList}">
			<tr>
				<td>${likeDto.boardNo}</td>
				<td>	
					<!-- depth만큼 앞에 띄어쓰기 -->
					<c:forEach var = "i" begin = "1" end = "${likeDto.boardDepth}">
						&nbsp;&nbsp;
					</c:forEach>
					
					<!-- 말머리가 있을 경우에만 표기하도록 -->
					<c:if test = "${likeDto.boardHead != null}">
						${likeDto.boardHead} 
					</c:if>
				
					${likeDto.boardTitle}
				</td>
				<td>${likeDto.boardWritetime}</td>
				<td>${likeDto.boardRead}</td>
				<td>${likeDto.boardLike}</td>
			</tr>
			</c:forEach>
		</tbody>
		</table>
		
		<br>
		
		<h3>내가 남긴 댓글</h3>
		<table border = "1" width = 900>
		<thead>
			<tr>
				<th colspan = "4">원본글</th>
				<th colspan = "2">댓글목록</th>
			</tr>
			
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>댓글내용</th>
				<th>댓글작성일</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var = "replyDto" items = "${myReplyList}">
			<tr>
				<td>${replyDto.boardNo}</td>
				<td>	
					<!-- depth만큼 앞에 띄어쓰기 -->
					<c:forEach var = "i" begin = "1" end = "${replyDto.boardDepth}">
						&nbsp;&nbsp;
					</c:forEach>
					
					<!-- 말머리가 있을 경우에만 표기하도록 -->
					<c:if test = "${replyDto.boardHead != null}">
						${replyDto.boardHead} 
					</c:if>
				
					${replyDto.boardTitle}
				</td>
				<td>${replyDto.boardWriter}</td>
				<td>${replyDto.boardWritetime}</td>
				<td>${replyDto.replyContent}</td>
				<td>${replyDto.replyWritetime}</td>
			</tr>
			</c:forEach>
		</tbody>
		</table>
	</div>

<jsp:include page = "/WEB-INF/views/template/footer.jsp"></jsp:include>