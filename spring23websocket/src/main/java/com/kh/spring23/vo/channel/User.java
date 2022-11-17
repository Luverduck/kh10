package com.kh.spring23.vo.channel;

import java.io.IOException;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
	사용자 1명의 정보를 저장하는 클래스
	- 사용자에게 메시지를 보내는 기능 필요
*/

@Data 
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

	// 사용자 정보
	private String memberId; // 사용자 아이디
	private String memberNick; // 사용자 닉네임
	private String memberGrade; // 사용자 등급
	
	private WebSocketSession session; // 사용자의 WebSocketSession
	
	// 사용자 아이디 비교
	public boolean is(String memberId) {
		// 매개변수로 입력된 memberId가 null이면 false를 반환
		if(memberId == null) return false;
		
		// User 클래스의 인스턴스의 memberId 값이 null이면 false를 반환
		if(this.memberId == null) return false;
		
		// User 클래스의 인스턴스의 memberId 값이 매개변수로 입력된 memberId와 같은지 판정
		// - 특정 방에 참가하고있는 모든 참가자 중 해당 아이디를 가진 참가자 검색을 위함
		return this.memberId.equals(memberId);
	}
	
	// 메시지 전송
	// - 웹소켓 연결을 통해 웹소켓 서버가 수신한 메시지를 사용자에게 전송
	public void send(TextMessage message) throws IOException {
		session.sendMessage(message);
	}
}
