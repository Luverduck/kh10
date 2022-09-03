<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 
		img 태그 : 이미지를 표시하기 위한 태그
		- 종료 태그가 없음
		- src라는 속성으로 이미지의 위치를 설정
		- 남이 가진 이미지는 안전하지 않으므로 직접 저장 후 설정하는 것을 권장
		- 프로젝트 외부에 있는 이미지는 절대 불러올 수 없다
		- spring boot에서는 static 폴더가 정적 자원 저장 위치이다
		- width와 height라는 속성으로 크기 조절이 가능하다
			- width만 설정하면 height는 비율에 맞게 자동 조정된다
			- 크기를 숫자로 지정하면 자동으로 픽셀(px) 단위 처리
			- 크기를 비율로 설정할 수 있다(%)
	 -->
	<img src = "https://img1.daumcdn.net/thumb/R1280x0.fjpg/?fname=http://t1.daumcdn.net/brunch/service/user/cnoC/image/7yWsGzD7n1Boy4uxVEhVJjNjfI0.jpg">
	<!-- <img src = "D://study/image/cheetah.jpg"> -->	
	
	<hr>
	
	<!-- 절대 경로 -->
	<img src = "http://localhost:8888/image/cheetah.jpg" width = "1920">
	<img src = "http://localhost:8888/image/cheetah.jpg" width = "20%">
	<img src = "/image/cheetah.jpg" width = "20%">
	
	<!-- 
		상대 경로
		- 현재 위치 : http://localhost:8888/tag/test03
		- 목적 위치 : http://localhost:8888/image/cheetah.jpg
		
		** 상위 경로로 가기 : ../
	-->
	<img src = "../image/cheetah.jpg" width = "20%">
	
	<!-- 
		alt 속성은 이미지가 없을 때 나올 글자이기도 하지만 시각장애인 리더기가 읽는 글자 역할을 한다
		접근성을 높이기 위해서 사용하며 최대한 자세히 쓰는 것을 권유
	 -->
	 <img alt = "치타 이미지" src = "../image/cheeta1h.jpg" width = "20%">
</body>
</html>