package com.kh.spring23.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

import com.kh.spring23.websocket.BasicWebsocketServer;
import com.kh.spring23.websocket.JsonWebsocketServer;
import com.kh.spring23.websocket.MemberWebsocketServer;
import com.kh.spring23.websocket.MessageWebsocketServer;
import com.kh.spring23.websocket.MultipleUserWebsocketServer;
import com.kh.spring23.websocket.SockJSWebsocketServer;

@Configuration
@EnableWebSocket // 웹소켓 활성화
public class WebSocketServerConfiguration implements WebSocketConfigurer {

	// 의존성 주입
	@Autowired
	private BasicWebsocketServer basicWebsocketServer;
	
	// 의존성 주입
	@Autowired
	private MultipleUserWebsocketServer multipleUserWebsocketServer;
	
	// 의존성 주입
	@Autowired
	private MessageWebsocketServer messageWebsocketServer;
	
	// 의존성 주입
	@Autowired
	private JsonWebsocketServer jsonWebsocketServer;
	
	// 의존성 주입
	@Autowired
	private SockJSWebsocketServer sockJSWebsocketServer;
	
	// 의존성 주입
	@Autowired
	private MemberWebsocketServer memberWebsocketServer;
	
	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		// 등록시 주의사항
		// - 절대로 다른 페이지와 주소가 겹치면 안된다
		// - HTTP가 사용중이면 웹소켓 서버는 정상 작동하지 않는다
		registry.addHandler(basicWebsocketServer, "/ws/basic")
				.addHandler(multipleUserWebsocketServer, "/ws/multiple")
				.addHandler(messageWebsocketServer, "/ws/message")
				.addHandler(jsonWebsocketServer, "/ws/json");
		
		registry.addHandler(sockJSWebsocketServer, "ws/sockjs")
				.withSockJS(); // 추가 코드
		
		// HttpSessionHandshakeInterceptor는 HttpSession을 WebSocketSession으로 넘겨준다
		registry.addHandler(memberWebsocketServer, "/ws/member")
				.addInterceptors(new HttpSessionHandshakeInterceptor())
				.withSockJS();
	}	
}
