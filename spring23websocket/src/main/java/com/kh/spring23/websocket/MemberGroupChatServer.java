package com.kh.spring23.websocket;

import java.util.Date;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kh.spring23.vo.MessageVO;
import com.kh.spring23.vo.ReceiveVO;
import com.kh.spring23.vo.channel.Channel;
import com.kh.spring23.vo.channel.Room;
import com.kh.spring23.vo.channel.User;

import lombok.extern.slf4j.Slf4j;

/*
	회원들간의 그룹 채팅이 가능하도록 구현한 서버
	- User, Room, Channel 클래스를 활용
	- 대기실을 구현
*/

@Slf4j
@Service
public class MemberGroupChatServer extends TextWebSocketHandler {
	
	// 대기실 
	// - 회원의 웹소켓 연결이 생성되면 대기실 참가자 저장소에 해당 회원을 참가자로서 저장
	private Room waitingRoom = new Room();
	
	// 채널
	// - 방들의 이름이 저장된 저장소를 포함
	private Channel channel = new Channel();
	
	// 웹소켓 연결 신규 생성시
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		
		// WebSocketSession에 저장된 값을 Map 형태로 반환 
		// - 웹소켓 연결이 생성된 회원의 아이디, 닉네임, 등급을 Key-Value 형태로 반환
		Map<String, Object> attr = session.getAttributes();
		
		// 웹소켓 연결이 생성된 사용자의 WebSocketSession에 저장된 값으로 User 클래스의 인스턴스 생성
		User user = User.builder()
							.memberId((String)attr.get("loginId"))
							.memberNick((String)attr.get("loginNick"))
							.memberGrade((String)attr.get("loginAuth"))
							.session(session)
						.build();
		
		// 신규 참가자 대기실 입장
		// - 웹소켓 연결이 생성된 회원의 User 클래스의 인스턴스를 Room 클래스의 방 참가자 저장소인 Set<User> users에 추가
		waitingRoom.enter(user);
		
		// 대기실 인원 확인을 위한 로그 출력
		log.debug("대기실 입장 - 현재 {}명", waitingRoom.size());
	}
	
	// 웹소켓 연결 해제시
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		
		// WebSocketSession에 저장된 값을 Map 형태로 반환 
		// - 웹소켓 연결이 생성된 회원의 아이디, 닉네임, 등급을 Key-Value 형태로 반환
		Map<String, Object> attr = session.getAttributes();
		
		// 웹소켓 연결이 생성된 사용자의 WebSocketSession에 저장된 값으로 User 클래스의 인스턴스 생성
		User user = User.builder()
							.memberId((String)attr.get("loginId"))
							.memberNick((String)attr.get("loginNick"))
							.memberGrade((String)attr.get("loginAuth"))
							.session(session)
						.build();
		
		// 참가자 채널 퇴장
		// - 웹소켓 연결이 해제된 회원이 참가하고있던 방 이름을 찾아 해당 방의 방 참가자 저장소인 Set<User> users에서 해당 회원의 User 클래스의 인스턴스를 제거
		channel.exit(user);
		
		// 참가자 대기실 퇴장
		// - 웹소켓 연결이 해제된 회원의 User 클래스의 인스턴스를 Room 클래스의 방 참가자 저장소인 Set<User> users에 제거
		waitingRoom.leave(user);
		
		// 사용자 퇴장 확인을 위한 로그 출력
		log.debug("사용자 퇴장");
	}

	// 웹소켓 서버에 메시지 전송시
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		
		// WebSocketSession에 저장된 값을 Map 형태로 반환 
		// - 웹소켓 연결이 생성된 회원의 아이디, 닉네임, 등급을 Key-Value 형태로 반환
		Map<String, Object> attr = session.getAttributes();
		
		// 웹소켓 연결이 생성된 사용자의 WebSocketSession에 저장된 값으로 User 클래스의 인스턴스 생성
		User user = User.builder()
							.memberId((String)attr.get("loginId"))
							.memberNick((String)attr.get("loginNick"))
							.memberGrade((String)attr.get("loginAuth"))
							.session(session)
						.build();
		
		// ObjectMapper의 인스턴스 생성 
		ObjectMapper mapper = new ObjectMapper();
		
		// JSON을 VO 형태로 변환
		ReceiveVO receiveVO = mapper.readValue(message.getPayload(), ReceiveVO.class);
		
		// 변환된 VO의 형태를 확인하기 위한 로그 출력
		log.debug("receiveVO = {}", receiveVO);
		
		// 사용자가 특정 방에 참가하는 것인지, 특정 방에 메시지를 보내는 것인지 판정
		if(receiveVO.getType() == 1) { // VO의 type 필드의 값이 1인 경우 (방 참가)
			
			// 대기실의 방 참가자 저장소에서 해당 사용자의 User 클래스의 인스턴스 제거
			waitingRoom.leave(user);
			
			// 참가하려는 방의 방 참가자 저장소에 해당 사용자의 User 클래스의 인스턴스 추가
			channel.join(user, receiveVO.getRoom());
			
			// 해당 사용자의 특정 방 참가를 확인하기 위한 로그 출력
			log.debug("{} 방에 {} 입장", receiveVO.getRoom(), user.getMemberId());
		}
		else if(receiveVO.getType() == 2) { // VO의 type 필드의 값이 2인 경우 (메시지 전송)
			// 메시지 출력 형식에 맞도록 메시지에 필요한 정보 추가
			MessageVO vo = MessageVO.builder()
										.id(user.getMemberId()) // 전송자 아이디
										.nickname(user.getMemberNick()) // 전송자 닉네임
										.auth(user.getMemberGrade()) // 전송자 회원 등급
										.text(receiveVO.getText()) // 전송자 메시지 내용
										.time(new Date()) // 전송 일자
									.build();
			// VO를 JSON 형태의 문자열로 변환
			String json = mapper.writeValueAsString(vo);
			
			// JSON 형태의 문자열로 메시지 생성
			TextMessage msg = new TextMessage(json);
			
			// 해당 사용자가 참가하고있는 방의 이름을 찾아 해당 방에만 메시지 전송
			channel.send(user, msg);
		}
	}
}
