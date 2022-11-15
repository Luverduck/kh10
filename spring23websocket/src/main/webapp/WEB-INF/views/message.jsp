<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h1>메시지 전송 예제</h1>

<button class = "btn-connect">연결</button>
<button class = "btn-disconnect">종료	</button>

<hr>

<input type = "text" id = "message-input">
<button type = "button" id = "message-send">전송</button>

<hr>

<div id = "message-list"></div>

<script src="https://code.jquery.com/jquery-3.6.1.js"></script>

<script>
	$(function(){
		// 초기 웹소켓은 연결 해제 상태
		disconnectState();
		
		// 1. 연결버튼을 누를 때 - 웹소켓 연결 생성
		$(".btn-connect").click(function(){
	
			// 웹소켓 연결 주소 설정
			var uri = "ws://localhost:8888/ws/message";
			
			// 웹소켓 연결 생성
			//window.socket = new WebSocket(uri);
			socket = new WebSocket(uri); // 변수로 만들지 말고 window에 붙여서 만듬
			
			console.log(socket);
			
			// 웹소켓에 대한 이벤트 설정
			// 1) 웹소켓 연결이 생성될 때
			socket.onopen = function(){
				console.log("open");	
				connectState();	// 연결 상태일 때 connectState() 실행
			};
			
			// 2) 웹소켓 연결 중 연결이 해제될 때
			socket.onclose = function(){
				console.log("close");
				disconnectState(); // 해제 상태일 때 disconnectState() 실행
			};
			
			// 3) 웹소켓 연결 중 연결에 에러가 발생할 때
			socket.onerror = function(){
				console.log("error");
				disconnectState(); // 에러 상태일 때 disconnectState() 실행
			};
			
			// 4) 웹소켓 연결 중 메시지가 수신될 때
			socket.onmessage = function(e){
				//console.log("message");
				//console.log(arguments); // 모든 매개변수 목록을 배열로 반환
				//console.log(e.data);
				$("<p>").text(e.data).appendTo("#message-list"); // <p> 태그를 생성하여 메시지 표시
			};
			
		});
		
		// 2. 종료 버튼을 누를 때 - 웹소켓 연결 해제
		$(".btn-disconnect").click(function(){
			// 웹소켓 연결 종료
			//window.socket.close();
			socket.close();
		});
		
		// 3. 전송 버튼을 누를 때 - 웹소켓에 연결된 모든 사용자에게 메시지 전달
		$("#message-send").click(function(){
			// 입력창의 값 지정
			var text = $("#message-input").val();
			
			// 입력창이 비어있으면 return
			if(text.length == 0) return;
			
			// 입력창의 값 전송
			// window.socket.send(text);
			socket.send(text);
			
			// 전송 후 입력창 초기화(비우기)
			$("#message-input").val("");
		});
		
		// 웹소켓 연결이 만들어진 상태일 때
		function connectState(){
			$(".btn-connect").prop("disabled", true); // 연결버튼 비활성화
			$(".btn-disconnect").prop("disabled", false); // 종료버튼 비활성화 해제
		}
		
		// 웹소켓 연결이 해제된 상태일 때
		function disconnectState(){
			$(".btn-connect").prop("disabled", false); // 연결버튼 비활성화 해제
			$(".btn-disconnect").prop("disabled", true); // 종료버튼 비활성화
		}
	});
</script>