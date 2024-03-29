package com.kh.spring23.websocket;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import org.springframework.stereotype.Service;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import lombok.extern.slf4j.Slf4j;

/*
	여러 명의 사용자를 기억하기 위한 코드가 구현된 서버
	- 아직 메세지는 처리하지 않음 
*/

@Slf4j
@Service
public class MultipleUserWebsocketServer extends TextWebSocketHandler {
	
	// 웹소켓 사용자 저장소 - Set(혹시 모를 중복 방지)
	//private Set<WebSocketSession> users = new HashSet<>(); // HashSet은 동기화가 안되므로 X
	private Set<WebSocketSession> users = new CopyOnWriteArraySet<>(); // 동기화된 Set (대신 느림)

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		users.add(session); // 사용자 저장
		log.debug("사용자 접속 : {} 명", users.size());
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		users.remove(session); // 사용자 삭제
		log.debug("사용자 종료 : {} 명", users.size());
	}
}
