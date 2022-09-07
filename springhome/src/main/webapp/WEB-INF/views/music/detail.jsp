<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${musicDto.getMusicNo()}번 음원 정보</title>
</head>
<body>

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
		
		<h2><a href = "list">목록보기</a></h2>
		<h2><a href = "edit?musicNo=${musicDto.getMusicNo()}">수정하기</a></h2>
	</div>

</body>
</html>