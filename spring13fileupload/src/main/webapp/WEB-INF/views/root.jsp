<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>파일 업로드 테스트</h1>

<!-- 
	파일 업로드 화면을 구현할 때 알아야 할 점
	- 기존 방식(GET/POST 무관)으로는 파일명만 전송
	- form에 post방식 + enctype = "multipart/form-data"로 설정
	- 절취선이 생기면서 파일의 여러 정보가 한의 구역에 담겨 전송
-->

<!-- <form action="/" method="get"> -->
<!-- <form action="/" method="post"> -->
<form action="/" method="post" enctype="multipart/form-data">
	
	<input type="text" name="uploader">
	<br><br>
	<input type="file" name="attachment">
	<br><br>
	<button type="submit">업로드</button>
	
</form>