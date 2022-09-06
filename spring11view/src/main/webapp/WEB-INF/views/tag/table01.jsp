<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>통신사 요금제 정보</title>
</head>

<body>
	<!-- div는 일단 정렬 기능만 사용 -->
	<div align = "center">

		<h1>통신사 요금제 정보</h1>
		
		<!-- 
			가운데 정렬하는 방법
			- align = "center"
			- tbody, tr, td 모두에 가능
			- table에 할 경우 table의 위치가 화면 가운데로 정렬됨
		-->
		
		<table border =  "1" width = 35%>
			<thead>
				<tr>
				<th>통신사</th><th align = "left">상품평</th><th align = "right">월정액</th><th>데이터(GB)</th><th>통화(분)</th><th>문자(건)</th>
				</tr>
			</thead>
				
			<tbody align = "center">
				<tr>
				<td>SK</td><td align = "left">5G언택트 52</td><td align = "right">52000</td><td>200</td><td>1000</td><td>2000</td>
				</tr>
				
				<tr>
				<td>KT</td><td align = "left">5G언택트 52</td><td align = "right">45000</td><td>100</td><td>900</td><td>1500</td>
				</tr>
				
				<tr>
				<td>LG</td><td align = "left">5G시그니처</td><td align = "right">130000</td><td>500</td><td>2000</td><td>2500</td>
				</tr>
			</tbody>
			
			<!-- tfoot : 요약 정보 -->
			<tfoot>
				<tr>
					<!-- 
						칸을 원하는 방향으로 늘릴 수 있다 (입력하는 숫자가 셀의 길이를 늘리는 갯수)
						- colspan은 우측으로 늘리고
						- rowspan은 하단으로 늘린다
					-->
					<td colspan = "6" align = "center">총 3개의 요금제가 있습니다</td>
				</tr>
			</tfoot>
			
		</table>
	
	</div>
</body>
</html>