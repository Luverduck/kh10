<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<style>
	.chat-message {
		padding: 1em;
		border: 1px solid black;
		border-radius : 1em;
	}
</style>

<h1>그룹 채팅 예제</h1>
<h2>방 이름 : ${room} </h2>

<hr>

<input type="text" id="message-input">
<button type="button" id="message-send">전송</button>
<hr>
<div id="message-list"></div>

<script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.6.1/sockjs.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.4/moment.min.js"></script>
<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
<script>
	$(function(){
		//목표
		//1. 시작하자마자 웹소켓 연결을 생성
		//2. 나가기 전에 웹소켓 연결을 제거
		//3. 전송버튼을 누르면 웹소켓으로 입력된 메세지를 전송
		
		//1.
		//웹소켓 연결 생성
		//- sockjs를 사용하면 주소를 http로 설정할 수 있다.
		//- 절대경로 표시를 추가할 수 있다.
		var uri = "${pageContext.request.contextPath}/ws/group";
		
		//- 접속 시 생성하는 객체가 WebSocket이 아니라 SockJS로 바뀐다
		socket = new SockJS(uri);
		
		//(+추가) 웹소켓이 연결되었는지 종료되었는지 어떻게 아나?
		// - 웹소켓 객체가 기본 제공하는 4가지 이벤트를 설정해서 처리
		//console.log(socket);
		socket.onopen = function(){
			//console.log("open");
			// 접속하자마자 서버로 입장메시지를 보내야 한다
			var data = {
				type : 1,
				room : "${room}"
			}
			socket.send(JSON.stringify(data));
		};
		
		socket.onclose = function(){
			//console.log("close");
		};
		
		socket.onerror = function(){
			//console.log("error");
		};
		
		socket.onmessage = function(e){
			//수신된 e.data는 JSON 문자열
			var data = JSON.parse(e.data);
			//console.log(data);
			
			var p = $("<p>").addClass("chat-message"); // 클래스를 부여하여 CSS에서 디자인
			var time = moment(data.time).format("YYYY-MM-DD hh:mm");
			var w = $("<p>").text(data.nickname + "[" + data.auth + "]");
			var t = $("<p>").text("("+time+")");
			var c = $("<p>").text(data.text);
			p.append(w).append(c).append(t);
			$("#message-list").append(p);
			
			// 스크롤 하단으로 이동
			var height = $(document).height();
			$(window).scrollTop(height);
		};
			
		
		//2.
		$(window).on("beforeunload", function(){
			//웹소켓 연결 종료
			//window.socket.close();
			socket.close();
			
		});
		
		//3
		$("#message-send").click(function(){
			var text = $("#message-input").val();
			if(text.length == 0) return;
			
			//JSON으로 변환해서 전송
			//- JSON.stringify(객체) : 객체를 문자열로
			//- JSON.parse(문자열) : 문자열을 객체로
			var data = {
				type : 2,
				text : text
			};
			socket.send(JSON.stringify(data));
			$("#message-input").val("");
		});
		
	});
</script>