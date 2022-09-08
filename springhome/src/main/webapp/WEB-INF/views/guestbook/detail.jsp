<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${guestBookDto.getNo()}번 방명록</title>
</head>
<body>

	<div align = "center">
		<h1>${guestBookDto.getNo()}번 방명록 보기</h1>
		
		<table border = "1" width = "400">
			<tbody>
				<tr>
					<th width = "25%">작성자</th>
					<td>${guestBookDto.getName()}</td>
				</tr>
				
				<tr height = "250" valign = "top">
					<th>내용</th>
					<td>${guestBookDto.getMemo()}</td>
				</tr>
			</tbody>
		</table>
		
		<h2><a href = "list">목록</a></h2>
		<h2><a href = "insert">등록</a></h2>
		<h2><a href = "edit?no=${guestBookDto.getNo()}">수정</a></h2>
		<h2><a href = "delete?no=${guestBookDto.getNo()}">삭제</a></h2>
	</div>

</body>
</html>