<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page = "/WEB-INF/views/template/header.jsp">
	<jsp:param name = "title" value = "음원 정보 변경"/>
</jsp:include>

	<div align = "center">
		<h1>음원 정보 변경</h1>
		<form action = "edit" method = "post">
			<input type = "hidden" name = "musicNo" value = "${musicDto.getMusicNo()}">
			<input type = "text" name = "musicTitle" value = "${musicDto.getMusicTitle()}"><br><br>
			<input type = "text" name = "musicArtist" value = "${musicDto.getMusicArtist()}"><br><br>
			<input type = "text" name = "musicAlbum" value = "${musicDto.getMusicAlbum()}"><br><br>
<%-- 		<input type = "number" name = "musicPlay" value = "${musicDto.getMusicPlay()}"><br><br>			--%>			
			<input type = "date" name = "releaseTitle" value = "${musicDto.getReleaseTitle()}"><br><br>
			<button type = "submit">변경</button>
		</form>
	</div>

<jsp:include page = "/WEB-INF/views/template/footer.jsp"></jsp:include>