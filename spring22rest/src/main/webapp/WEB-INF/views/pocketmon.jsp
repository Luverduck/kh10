<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script src="https://code.jquery.com/jquery-3.6.1.js"></script>

<script>
	$(function(){
		loadList();
		
		// 수정 버튼 클릭 이벤트
		$(".edit-btn").click(function(){
			var no = $("[name=no]").val();
			var name = $("[name=name]").val();
			var type = $("[name=type]").val();
			
			editData(no, name, type);
			
			$("[name=no]").val("");
 			$("[name=name]").val("");
 			$("[name=type]").val("");
		});
		
		// form에 submit 이벤트를 설정해서 등록 처리
		$(".detail-view").submit(function(e){
			e.preventDefault(); // 기본 이벤트 차단
			
			var no = $("[name=no]").val();
			var name = $("[name=name]").val();
			var type = $("[name=type]").val();
			
			// 검사
			saveData(no, name, type);
			
 			$("[name=no]").val("");
 			$("[name=name]").val("");
 			$("[name=type]").val("");
		});
	});
	
	// 삭제 함수
	function deleteData(no){
		$.ajax({
			url : "http://localhost:8888/rest/pocketmon/" + no,
			method : "delete",
			success : function(resp){
				loadList();
			}
		});
	}
	
	// 수정 함수
	function editData(no, name, type){
		var data = {
				no : no, 
				name : name, 
				type : type
				};
		
		$.ajax({
			url : "http://localhost:8888/rest/pocketmon",
			method : "put",
			contentType : "application/json",
			data : JSON.stringify(data),
			success : function(){
				loadList();
			}
		});
	}
	
	// 등록 함수
	function saveData(no, name, type){
		var data = {
					no : no, 
					name : name, 
					type : type
					};
		
		$.ajax({
			url : "http://localhost:8888/rest/pocketmon",
			method : "post",
			contentType : "application/json",
			data : JSON.stringify(data),
			success : function(){
				loadList();
			}
		});
	}
	
	// 목록을 불러오는 함수
	function loadList(){
		
		$.ajax({
			url : "http://localhost:8888/rest/pocketmon",
			method : "get",
			success : function(resp) {
				//console.log(resp);
				
				// 비우기 (다시 만들기 위해)
				$(".list-view").empty();
				
				for(var i = 0 ; i < resp.length ; i ++){
					
					var h3 = $("<h3>").text(resp[i].no + "/" + resp[i].name + "/" + resp[i].type)
									.attr("data-no", resp[i].no)
									.attr("data-name", resp[i].name)
									.attr("data-type", resp[i].type);
					
					h3.click(function(){
						$("[name=no]").val($(this).data("no"));
						$("[name=name]").val($(this).data("name"));
						$("[name=type]").val($(this).data("type"));
					});
					
					// 삭제 버튼
					var span = $("<span>").text("x").attr("data-no", resp[i].no);
					
					span.click(function(e){
						
						e.stopPropagation(); // 이벤트 전파 중지
						
						if(confirm("정말 삭제하시겠습니까?")){
							
						var no = $(this).data("no");
						
						deleteData(no);
						
						}						
					});
					
					h3.append(span);
					$(".list-view").append(h3);
				}
			}
		});
		
	}
	
</script>

<h1>포켓몬스터 관리 페이지</h1>

<form class = "detail-view">
	<input type = "text" name = "no" placeholder = "번호">
	<input type = "text" name = "name" placeholder = "이름">
	<input type = "text" name = "type" placeholder = "속성">
	<button type = "submit">등록</button>
	<button type = "button" class = "edit-btn">수정</button>
</form>

<div class = "list-view">
	
</div>