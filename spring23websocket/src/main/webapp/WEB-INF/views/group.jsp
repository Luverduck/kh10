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
		
		//1. 페이지에 연결되면 바로 웹소켓 연결 생성
		// 웹소켓 연결 주소 설정
		var uri = "${pageContext.request.contextPath}/ws/group";
		
		// 웹소켓 연결 생성
		// - 접속시 WebSocket이 아닌 SockJS 객체를 생성
		socket = new SockJS(uri);
		
		// 웹소켓에 대한 이벤트 설정
		// 1) 웹소켓 연결이 생성될 때
		socket.onopen = function(){
			//console.log("open");
			// 웹소켓에 연결되면 바로 웹소켓 서버로 '방 입장' 메시지 전송
			var data = {
				type : 1,
				room : "${room}"
			}
			socket.send(JSON.stringify(data));
		};
		
		// 2) 웹소켓 연결 중 연결이 해제될 때
		socket.onclose = function(){
			//console.log("close");
		};
		
		// 3) 웹소켓 연결 중 연결에 에러가 발생할 때
		socket.onerror = function(){
			//console.log("error");
		};
		
		// 4) 웹소켓 연결 중 메시지가 수신될 때
		socket.onmessage = function(e){
			// 문자열을 JSON 형태로 수신 - JSON.parse()
			var data = JSON.parse(e.data);
			
			// p 태그 지정 - CSS에서 디자인을 하기 위해 클래스 부여
			var p = $("<p>").addClass("chat-message");
			
			// p 태그 지정 - 닉네임[등급] 형태
			var w = $("<p>").text(data.nickname + "[" + data.auth + "]");
			
			// 수신한 JSON의 time 형태 변경 
			var time = moment(data.time).format("YYYY-MM-DD hh:mm");
			
			// p 태그 지정 - (시간) 형태
			var t = $("<p>").text("("+time+")");
			
			// p 태그 지정 - 메시지 표시
			var c = $("<p>").text(data.text);
			
			// 지정된 p 태그들을 연결
			p.append(w).append(c).append(t);
			
			// 메시지를 표시하는 div 안에 연결된 p 태그 생성
			$("#message-list").append(p);
			
			// 메시지가 발생할 때마다 스크롤 하단으로 이동
			var height = $(document).height();
			$(window).scrollTop(height);
		};
			
		
		// 2.
		$(window).on("beforeunload", function(){
			//웹소켓 연결 종료
			//window.socket.close();
			socket.close();
			
		});
		
		// 3. 전송 버튼을 누를 때 
		// - 웹소켓 서버로 '사용자가 입력한' 메시지 전송
		$("#message-send").click(function(){
			// 입력창에 입력된 값을 지정
			var text = $("#message-input").val();
			
			// 입력창에 입력된 값이 없는 상태에서 전송 버튼을 누르면 return
			if(text.length == 0) return;
			
			// JSON으로 변환해서 전송
			// - JSON.stringify(객체) : 객체를 문자열로
			// - JSON.parse(문자열) : 문자열을 객체로
			
			// 입력값을 JSON 형태로 설정
			var data = {
				type : 2,
				text : text
			};
			
			// 입력창의 값 전송
			socket.send(JSON.stringify(data));
			
			// 전송 후 입력창 초기화(비우기)
			$("#message-input").val("");
		});
	});
</script>