<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>테이블 예제</title>
</head>
<body>

	<!-- 
		table 태그 : 화면에 표를 출력하기 위한 태그 
		- 잘못된 방식으로 사용하면 글자가 외부로 빠진다
		- 내부의 여러 태그들을 조합하여 사용할 수 있다
		- thead, tbody, tfoot, tr, th, td와 같은 태그들이 등장한다
		
		- thead : 테이블 헤더(제목)
		- tbody : 테이블 내용
		- tfoot : 테이블 하단 도구
		
		- tr : 테이블 행 구분 줄 (table row)
		
		- th : 테이블 제목용 컬럼 (가운데 정렬)
		- td : 테이블 데이터용 컬럼 (왼쪽 정렬)
		
		(주의) 테이블 내부에 입력될 글자는 반드시 th/td에만 작성 가능하다
		
		테이블 테두리 두께 : border - 0 또는 1
		테이블 폭 : width - 값 또는 퍼텐트(%)
 	-->
 
	<table border = "1" width = "800">
		<thead>
			<tr>
				<th rowspan = "2">NO</th>
				<th rowspan = "2">부하의 종류</th>
				<th rowspan = "2">출력[kW]</th>
				<th colspan = "4">전부하 특성</th>
			</tr>
			<tr>
				<th>역률[%]</th>
				<th>효율[%]</th>
				<th>입력[kVA]</th>
				<th>입력[kW]</th>
			</tr>
		</thead>	
		<tbody>
			<tr>
				<td>NO.1</td>
				<td>유도전동기</td>
				<td>6대 X 37</td>
				<td>87.0</td>
				<td>80.5</td>
				<td>6대 X 53</td>
				<td>6대 X 46</td>
			</tr>
			<tr>
				<td>NO.2</td>
				<td>유도전동기</td>
				<td>1대 X 11</td>
				<td>84.0</td>
				<td>77.0</td>
				<td>17</td>
				<td>14.3</td>
			</tr>
			<tr>
				<td>NO.3</td>
				<td>전등 및 기타</td>
				<td>30</td>
				<td>100</td>
				<td>-</td>
				<td>30</td>
				<td>30</td>
			</tr>
		</tbody>
		<tfoot>
			<tr>
				<td colspan = "2">합계</td>
				<td>263</td>
				<td>88.0</td>
				<td>-</td>
				<td>365</td>
				<td>320.3</td>
			</tr>
		</tfoot>
	</table>
</body>
</html>