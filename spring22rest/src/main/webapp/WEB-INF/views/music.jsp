<%@ page language="java" contentType="text/html; charsset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- jQuery -->
<script src="https://code.jquery.com/jquery-3.6.1.js"></script>

<script>

	$(function(){
		loadList();
	});

	// 음언 목록 함수
	function loadList(){
		$.ajax({
			url : "http://localhost:8888/rest/music",
			method : "get",
			success : function(resp){
				// 기존 내용 비우기 (변경 사항을 비동기 통신을 통해 바로 반영하기 위해)
				$(".list-view").empty();
				
				for(i = 0 ; i < resp.length ; i ++){
					var tr = $("<tr>")
							.attr("data-musicNo", resp[i].musicNo)
							.attr("data-musicTitle", resp[i].musicTitle)
							.attr("data-musicArtist", resp[i].musicArtist)
							.attr("data-musicAlbum", resp[i].musicAlbum)
							.attr("data-musicPlay", resp[i].musicPlay)
							.attr("data-releaseTitle", resp[i].releaseTitle);
					
					var tdMusicNo = $("<td>").text(resp[i].musicNo);
					var tdMusicTitle = $("<td>").text(resp[i].musicTitle);
					var tdMusicArtist = $("<td>").text(resp[i].musicArtist);
					var tdMusicAlbum = $("<td>").text(resp[i].musicAlbum);
					var tdMusicPlay = $("<td>").text(resp[i].musicPlay);
					var tdReleaseTitle = $("<td>").text(resp[i].releaseTitle);
					
					tr.append(tdMusicNo).append(tdMusicTitle).append(tdMusicArtist).append(tdMusicAlbum).append(tdMusicPlay).append(tdReleaseTitle);
					$(".list-view").append(tr);
					
					// 수정을 위해 클릭시 값이 input에 입력되도록 설정
					tr.click(function(){
						$("[name=musicNo]").val($(this).data("musicno"));
						$("[name=musicTitle]").val($(this).data("musictitle"));
						$("[name=musicArtist]").val($(this).data("musicartist"));
						$("[name=musicAlbum]").val($(this).data("musicalbum"));
						$("[name=musicPlay]").val($(this).data("musicplay"));
						$("[name=releaseTitle]").val($(this).data("releasetitle"));
					});
				}
			}
		});
	}
	
</script>

<h1>음원 관리 페이지</h1>

<form class = "detail-view">
	<input type = "text" name = "musicNo" placeholder = "번호">
	<input type = "text" name = "musicTitle" placeholder = "음원명">
	<input type = "text" name = "musicArtist" placeholder = "아티스트명">
	<input type = "text" name = "musicAlbum" placeholder = "앨범명">
	<input type = "text" name = "musicPlay" placeholder = "재생수">
	<input type = "text" name = "releaseTitle" placeholder = "발매일자">
	<button type = "button">등록</button>
	<button type = "button">수정</button>
</form>

<table>
	<thead>
		<tr>
			<th>번호</th>
			<th>타이틀</th>
			<th>아티스트</th>
			<th>앨범</th>
			<th>재생수</th>
			<th>발매일</th>
		</tr>		
	</thead>
	<tbody class = "list-view">
		
	</tbody>
</table>