<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h1>웹소켓 연결 예제</h1>

<button class = "btn-connect">연결</button>
<button class = "btn-disconnect">종료	</button>

<script src="https://code.jquery.com/jquery-3.6.1.js"></script>

<script>
	$(function(){
		// 목표
		// 1. 연결 버튼을 누르면 웹소켓 연결을 생성
		// 2. 종료 버튼을 누르면 웹소켓 연결을 제거
		
		disconnectState(); // 처음에는 연결이 안되어있는 상태
		
		// 1.
		$(".btn-connect").click(function(){
			// 웹소켓 연결 생성
			var uri = "ws://localhost:8888/ws/basic"; // 웹소켓 연결 주소
			//window.socket = new WebSocket(uri);
			socket = new WebSocket(uri); // 변수로 만들지 말고 window에 붙여서 만듬
			
			// (추가) 웹소켓이 연결되었는지 종료되었는지 어떻게 아는가?
			// - 웹소켓 객체가 기본 제공하는 4가지 이벤트를 설정해서 처리
			console.log(socket);
			
			// socket 연결시 해당 함수 실행
			socket.onopen = function(){
				console.log("open");	
				connectState();	// 연결 상태일 때 connectState() 실행
			};
			socket.onclose = function(){
				console.log("close");
				disconnectState(); // 해제 상태일 때 disconnectState() 실행
			};
			socket.onerror = function(){
				console.log("error");
				disconnectState(); // 에러  상태일 때 disconnectState() 실행
			};
			socket.onmessage = function(){
				console.log("message");
			};
		});
		
		// 2. 
		$(".btn-disconnect").click(function(){
			// 웹소켓 연결 종료
			//window.socket.close();
			socket.close();
		});
		
		function connectState(){ // 연결 상태일 때 보여줘야 할 화면 처리
			$(".btn-connect").prop("disabled", true); // 연결버튼 잠금
			$(".btn-disconnect").prop("disabled", false); // 종료버튼 해제
		}
		
		function disconnectState(){ // 종료 상태일 때 보여줘야 할 화면 처리
			$(".btn-connect").prop("disabled", false); // 연결버튼 해제
			$(".btn-disconnect").prop("disabled", true); // 종료버튼 잠금
		}
	});
</script>