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

<!-- Moment CDN -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.4/moment.min.js"></script>

<!-- SockJS CDN -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.6.1/sockjs.min.js"></script>

<!-- JQuery CDN -->
<script src="https://code.jquery.com/jquery-3.6.1.js"></script>

<script>
	$(function(){
		// 초기 웹소켓은 연결 해제 상태
		disconnectState();
		
		// 1. 연결버튼을 누를 때 - 웹소켓 연결 생성
		$(".btn-connect").click(function(){
	
			// 웹소켓 연결 주소 설정
			// - SockJS를 사용하면 주소를 http로 시작하도록 할 수 있다
			var uri = "${pageContext.request.contextPath}/ws/sockjs";
			
			// 웹소켓 연결 생성
			// - 접속시 WebSocket이 아닌 SockJS 객체를 생성
			socket = new SockJS(uri); // 변수로 만들지 말고 window에 붙여서 만듬
			
			//console.log(socket);
			
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
				
				// 문자열을 JSON 형태로 수신 - JSON.parse()
				var data = JSON.parse(e.data);
				//console.log(data);
				
				// 수신한 JSON의 text를 태그 사이의 문자열로 하는 p 태그 지정
				var p = $("<p>").text(data.text);
				
				// 수신한 JSON의 time 형태 변경 
				var time = moment(data.time).format("YYYY-MM-DD hh:mm");
				
				// 변경된 time을 태그 사이의 문자열로 하는 span 태그 지정
				var span = $("<span>").text("(" + time +")");
				
				// p 태그 안에 span 태그 추가
				p.append(span);
				
				// div 태그(id = message-list)에 p태그 추가
				$("#message-list").append(p);
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
			
			// 입력창의 값을 JSON으로 변환하여 전송
			var data = {
				text : text
			}
			
			// 입력창의 값 전송
			// window.socket.send(text);
			socket.send(JSON.stringify(data));
			
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