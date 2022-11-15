<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h1>SockJS 예제</h1>

<button class = "btn-connect">연결</button>
<button class = "btn-disconnect">종료	</button>

<hr>

<input type = "text" id = "message-input">
<button type = "button" id = "message-send">전송</button>

<hr>

<div id = "message-list"></div>

<!-- 시간을 원하는 형식으로 변환 -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.4/moment.min.js"></script>

<!-- SockJS CDN -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.6.1/sockjs.min.js"></script>

<script src="https://code.jquery.com/jquery-3.6.1.js"></script>

<script>
	$(function(){
		// 목표
		// 1. 연결 버튼을 누르면 웹소켓 연결을 생성
		// 2. 종료 버튼을 누르면 웹소켓 연결을 제거
		// 3. 전송 버튼을 누르면 웹소켓으로 입력된 메세지를 전송
		
		disconnectState(); // 처음에는 연결이 안되어있는 상태
		
		// 1.
		$(".btn-connect").click(function(){
			// 웹소켓 연결 생성
			// - sockjs를 사용하면 주소를 http로 설정할 수 있다
			//var uri = "ws://localhost:8888/ws/sockjs"; // 웹소켓 연결 주소
			var uri = "${pageContext.request.contextPath}/ws/sockjs";
			//window.socket = new WebSocket(uri);
			
			// - 접속시 생성하는 객체가 WebSocket이 아니라 SockJS로 바뀐다
			socket = new SockJS(uri); // 변수로 만들지 말고 window에 붙여서 만듬
			
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
			
			socket.onmessage = function(e){
				//console.log("message");
				//console.log(arguments); // 모든 매개변수 목록을 배열로 반환
				//console.log(e.data);
				
				// 수신된 e.data는 JSON 문자열
				var data = JSON.parse(e.data);
				//console.log(data);
				
				var p = $("<p>").text(data.text);
				
				var time = moment(data.time).format("YYYY-MM-DD hh:mm");
				
				var span = $("<span>").text("(" + time + ")");
				
				p.append(span);
				
				$("#message-list").append(p);
			};
		});
		
		// 2. 
		$(".btn-disconnect").click(function(){
			// 웹소켓 연결 종료
			//window.socket.close();
			socket.close();
		});
		
		// 3. 
		$("#message-send").click(function(){
			// 입력창의 값 지정
			var text = $("#message-input").val();
			
			// 입력창이 비어있으면 return
			if(text.length == 0) return;
			
			var data = {
				text : text
			};
			
			// JSON으로 변환해서 전송
			// - JSON.stringify(객체) : 문자열을 객체로
			// - JSON.parse(문자열) : 객체를 문자열로
			// window.socket.send(text);
			socket.send(JSON.stringify(data));
			
			// 입력창 초기화(비우기)
			$("#message-input").val("");
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