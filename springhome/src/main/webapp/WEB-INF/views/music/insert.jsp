<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>음원 등록</title>
</head>
<body>
	<h1>음원 등록</h1>
		<form action = "insert" method = "post">
		제목 : <input name = "musicTitle" placeholder = "음원명" type = "text" required><br><br>
		가수 : <input name = "musicArtist" placeholder = "아티스트명" type = "text" required><br><br>
		앨범 : <input name = "musicAlbum" placeholder = "앨범명" type = "text" required><br><br>
		발매일 : <input nane = "releaseTitle" placeholder = "발매일" type = "date" required><br><br>
		<button>등록</button>
	</form>
</body>
</html>