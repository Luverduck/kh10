package com.kh.spring23.websocket;

import java.util.Date;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import org.springframework.stereotype.Service;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kh.spring23.vo.MessageVO;

import lombok.extern.slf4j.Slf4j;

/*
	웹 소켓의 문제점
	- 구버전 브라우저 미지원
	- 주소가 ws 혹은 wss로 시작
	
	해결 방안 
	- sockJS, socket.io 등
	- 구버전 브라우저는 풀링 혹은 롱풀링 방식으로 해결
	- 주소를 http 또는 https로 시작하도록 해줌
	
	적용 방식
	- 서버 등록시 SockJS를 사용하겠다고 선언
	- 클라이언트 코드를 sockJS로 구현
*/

@Slf4j
@Service
public class SockJSWebsocketServer extends TextWebSocketHandler {
	
	private Set<WebSocketSession> users = new CopyOnWriteArraySet<>();
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		users.add(session);
	}
	
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		users.remove(session);
	}
	
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		
		log.debug("메시지 - {}", message.getPayload());
		// (주의)
		// - 웹소켓 서버는 JSON을 자동으로 변환해주지 않는다
		// - jackson-databind를 통해 수동 변환해야 한다
		// (1) Map으로 바꾸는 방법
		// (2) 클래스의 객체로 바꾸는 방법
		
		// 변환 도구 생성
		ObjectMapper mapper = new ObjectMapper();
		//Map json = mapper.readValue(message.getPayload(), Map.class);
		//log.debug("json = {}", json);
		
		String str = message.getPayload();
		MessageVO json = mapper.readValue(message.getPayload(), MessageVO.class);
		log.debug("json = {}", json);
		
		// json에 시간을 추가
		json.setTime(new Date());
		
		// 바뀐 정보를 이용하여 신규 메시지 생성
		String payload = mapper.writeValueAsString(json);
		TextMessage jsonMessage = new TextMessage(payload);
		
		// 모두에게 발송(broadcast)
		for(WebSocketSession user : users) {
			user.sendMessage(jsonMessage);
		}
	}
}
