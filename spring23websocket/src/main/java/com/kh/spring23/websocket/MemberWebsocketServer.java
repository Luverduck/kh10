package com.kh.spring23.websocket;

import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import org.springframework.stereotype.Service;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kh.spring23.vo.MessageVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MemberWebsocketServer extends TextWebSocketHandler {

	// 웹소켓 사용자 저장소 - Set(중복 방지)
	private Set<WebSocketSession> users = new CopyOnWriteArraySet<>(); // 동기화된 Set

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		
		// HttpSessionHandshakeInterceptor의 동작을 확인하기 위한 로그 출력
		log.debug("session = {}", session.getAttributes());
		
		// HttpSessionHandshakeInterceptor에 의해 HttpSession에서 WebSocketSession로 가져온 값을 Map 형태로 반환
		Map<String, Object> attributes = session.getAttributes();
		
		// Map에 저장된 값 반환
		String loginId = (String)attributes.get("loginId");
		String loginNick = (String)attributes.get("loginNick");
		String loginAuth = (String)attributes.get("loginAuth");
		
		// Map에서 반환한 값 확인
		log.debug("{}, {}, {}", loginId, loginNick, loginAuth);
		
		// 사용자 저장소에 해당 사용자 추가
		users.add(session);
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		// WebSocketSession의 정보 출력
		log.debug("session = {}", session);
		// 사용자 저장소에서 해당 사용자 삭제
		users.remove(session);
	}
	
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		
		// 로그인한 회원의 로그인 정보 반환
		Map<String, Object> attributes = session.getAttributes();
		String loginId = (String)attributes.get("loginId");
		String loginNick = (String)attributes.get("loginNick");
		String loginAuth = (String)attributes.get("loginAuth");
		
		// 반환된 정보를 확인하기 위한 로그 출력
		log.debug("{}, {}, {}", loginId, loginNick, loginAuth);
		
		// 회원인지(로그인한 상태인지) 판정
		boolean available = loginAuth != null;
		
		// 비회원이라면
		if(available == false) {
			log.warn("비회원 채팅 금지");
			return;
		}
		
		// 회원이 보낸 메시지의 전송 데이터 확인을 위한 로그 출력
		log.debug("메세지 - {}", message.getPayload());

		// ObjectMapper의 인스턴스 생성 
		ObjectMapper mapper = new ObjectMapper();
		
		// 1. JSON을 Java Object로 변환 - readValue()
		// 1) JSON을 Map 형태로 변환
		//Map json = mapper.readValue(message.getPayload(), Map.class);
		//log.debug("json = {}", json);
		
		// 2) JSON을 클래스의 인스턴스 형태로 변환
		MessageVO json = mapper.readValue(message.getPayload(), MessageVO.class);
		log.debug("json = {}", json);

		// VO에 시간 설정
		json.setTime(new Date());
		
		// VO에 로그인 정보(id, nickname, auth) 설정
		json.setId(loginId);
		json.setNickname(loginNick);
		json.setAuth(loginAuth);

		// 2. Java Object를 JSON 형태로 변환 - writeValue()
		// 설정된 VO를 JSON 형태의 문자열로 변환
		String payload = mapper.writeValueAsString(json);
		// JSON 형태의 문자열로 메시지 생성
		TextMessage jsonMessage = new TextMessage(payload);

		// 연결된 모든 사용자에게 메시지 전송
		for(WebSocketSession user : users) {
			//user.sendMessage(json);
			user.sendMessage(jsonMessage);
		}
	}
}
