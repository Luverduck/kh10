<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page = "/WEB-INF/views/template/header.jsp">
	<jsp:param name = "title" value = "음원 등록"/>
</jsp:include>

<div class = "container-500 mt-20">
	<div class = "row center">
		<h1>음원 등록</h1>
	</div>
	<form action = "insert" method = "post">
		<div class = "row center mt-20">
			<input class = "input input-underline w-100" name = "musicTitle" placeholder = "음원명" type = "text" required>
		</div>
		<div class = "row center mt-20">
			<input class = "input input-underline w-100" name = "musicArtist" placeholder = "아티스트명" type = "text" required>
		</div>
		<div class = "row center mt-20">
			<input class = "input input-underline w-100" name = "musicAlbum" placeholder = "앨범명" type = "text" required>
		</div>
		<div class = "row center mt-20">
			<input class = "input input-underline w-100" name = "releaseTitle" placeholder = "발매일" type = "date" required>
		</div>
		<div class = "row center mt-20">
			<button class = "btn btn-positive" type = "submit">등록</button>
		</div>
	</form>
</div>
	
<jsp:include page = "/WEB-INF/views/template/footer.jsp"></jsp:include>