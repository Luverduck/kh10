<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page = "/WEB-INF/views/template/header.jsp">
	<jsp:param name = "title" value = "${musicDto.getMusicNo()}번 음원 정보"/>
</jsp:include>

	<div align = "center">
	
		<h1>${musicDto.getMusicNo()}번 음원 정보</h1>
		<table border= "1" width = "400">
			<tbody align = "center">
				<tr>
					<th width = "25%">음원 번호</th>
					<td>${musicDto.getMusicNo()}</td>
				</tr>
				<tr>
					<th width = "25%">음원명</th>
					<td>${musicDto.getMusicTitle()}</td>
				</tr>
				<tr>
					<th width = "25%">가수명</th>
					<td>${musicDto.getMusicArtist()}</td>
				</tr>
				<tr>
					<th width = "25%">앨범명</th>
					<td>${musicDto.getMusicAlbum()}</td>
				</tr>
				<tr>
					<th width = "25%">재생수</th>
					<td>${musicDto.getMusicPlay()}</td>
				</tr>
				<tr>
					<th width = "25%">발매일</th>
<%-- 				<td>${musicDto.getReleaseTitle()}</td> --%>				
					<td>
						<fmt:formatDate value="${musicDto.releaseTitle}" pattern = "y년 M월 d일 E요일"/>
					</td>
				</tr>
			</tbody>
		</table>
		
		<h3><a href = "edit?musicNo=${musicDto.getMusicNo()}">음원 정보 수정</a></h3>
		<h3><a href = "delete?musicNo=${musicDto.getMusicNo()}">음원 삭제</a></h3>
		<h3><a href = "list">전체 음원 목록</a></h3>
	</div>

<jsp:include page = "/WEB-INF/views/template/footer.jsp"></jsp:include>