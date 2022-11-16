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
	
	// 웹소켓 사용자 저장소 - Set(혹시 모를 중복 방지)
	//private Set<WebSocketSession> users = new HashSet<>(); // HashSet은 동기화가 안되므로 X
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
		
		// ObjectMapper의 인스턴스 생성 
		ObjectMapper mapper = new ObjectMapper();
		
		// 1. JSON을 Java Object로 변환 - readValue()
		// 1) JSON을 Map 형태로 변환
		//Map json = mapper.readValue(message.getPayload(), Map.class);
		//log.debug("json = {}", json);
		
		// 2) JSON을 클래스의 인스턴스 형태로 변환
		MessageVO json = mapper.readValue(message.getPayload(), MessageVO.class);
		log.debug("json = {}", json);
		
		// 인스턴스에 시간 설정
		json.setTime(new Date());
		
		// 2. Java Object를 JSON 형태로 변환 - writeValue()
		// - 클래스의 인스턴스를 JSON 형태로 변환 
		String payload = mapper.writeValueAsString(json);
		TextMessage jsonMessage = new TextMessage(payload);
		
		// 웹소켓에 연결된 모든 사용자에게 메시지 전송
		for(WebSocketSession user : users) {
			user.sendMessage(jsonMessage);
		}
	}
}
