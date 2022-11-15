package com.kh.spring23.websocket;

import java.util.Date;
import java.util.Map;

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
	
	// 대기실 - 비회원은 interceptor로 접근하지 못하도록 미리 처리해야함
	private Room waitingRoom = new Room();
	
	// 채널
	private Channel channel = new Channel();
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		// 접속시 대기실로 입장
		Map<String, Object> attr = session.getAttributes(); // id, nickname, auth가 key-value 형태로 저장되어있음
		User user = User.builder()
						.memberId((String)attr.get("loginId"))
						.memberNick((String)attr.get("loginNick"))
						.memberGrade((String)attr.get("loginAuth"))
						.session(session)
						.build();
		// 사용자 입장
		waitingRoom.enter(user);
		
		// 입장시 인원 표시
		log.debug("대기실 입장 - 현재 {}명", waitingRoom.size());
	}
	
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		// 사용자가 나가면
		// - 대기실에 있을지 채널에 있을지 알 수 없다
		Map<String, Object> attr = session.getAttributes(); // id, nickname, auth가 key-value 형태로 저장되어있음
		User user = User.builder()
						.memberId((String)attr.get("loginId"))
						.memberNick((String)attr.get("loginNick"))
						.memberGrade((String)attr.get("loginAuth"))
						.session(session)
						.build();
		
		// 대기실에서 사용자 삭제
		waitingRoom.leave(user);
		
		// 채널에서 사용자 삭제
		channel.exit(user);
		
		// 퇴장시 메시지
		log.debug("사용자 퇴장");
	}

	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		// 서버에서는 사용자 정보를 꺼낸 뒤 메시지를 종류별로 구분해서 처리
		Map<String, Object> attr = session.getAttributes(); // id, nickname, auth가 key-value 형태로 저장되어있음
		User user = User.builder()
						.memberId((String)attr.get("loginId"))
						.memberNick((String)attr.get("loginNick"))
						.memberGrade((String)attr.get("loginAuth"))
						.session(session)
						.build();
		
		// 메시지 해석
		ObjectMapper mapper = new ObjectMapper();
		ReceiveVO receiveVO = mapper.readValue(message.getPayload(), ReceiveVO.class);
		log.debug("receiveVO = {}", receiveVO);
		
		if(receiveVO.getType() == 1) { 
			// 사용자가 입장하려고 하는 경우 (방 이름을 사용자가 들고옴)
			// - 대기실에서 사용자를 제거한다
			waitingRoom.leave(user);
			// - 해당하는 방에 사용자(user)를 입장시킨다
			channel.join(user, receiveVO.getRoom());
			log.debug("{} 방에 {} 입장", receiveVO.getRoom(), user.getMemberId());
		}
		else if(receiveVO.getType() == 2) { 
			// 사용자가 채팅을 보내려고 하는 경우 (채팅 내용을 사용자가 보냄)
			// - 해당하는 방의 모든 사용자에게 메시지를 전송
			
			// 메시지 내용 추가
			MessageVO vo = MessageVO.builder()
										.id(user.getMemberId())
										.nickname(user.getMemberNick())
										.auth(user.getMemberGrade())
										.text(receiveVO.getText())
										.time(new Date())
									.build();
			
			String json = mapper.writeValueAsString(vo);
			TextMessage msg = new TextMessage(json);
			channel.send(user, msg);
		}
	}
}
