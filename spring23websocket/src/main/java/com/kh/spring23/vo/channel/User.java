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

	private String memberId;
	private String memberNick;
	private String memberGrade;
	
	private WebSocketSession session;
	
	// 사용자
	public boolean is(String memberId) {
		if(memberId == null) return false;
		if(this.memberId == null) return false;
		return this.memberId.equals(memberId);
	}
	
	// 사용자에게 메시지를 전송하는 메소드
	public void send(TextMessage message) throws IOException {
		session.sendMessage(message);
	}
}
