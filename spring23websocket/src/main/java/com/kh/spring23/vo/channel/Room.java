package com.kh.spring23.vo.channel;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import org.springframework.web.socket.TextMessage;

import lombok.extern.slf4j.Slf4j;

/*
	채팅방 클래스
	- 사용자(User)를 저장할 수 있도록 구성
	- 입장, 퇴장, 검색, 메시지 기능이 있어야 한다
 */

@Slf4j
public class Room {

	// 방 참가자 저장소 - Set (중복 방지)
	// - 특정 방에 참가한 모든 사용자의 User 클래스의 인스턴스 저장
	private Set<User> users = new CopyOnWriteArraySet<>();
	
	// 방 입장
	public void enter(User user) {
		// 방 참가자 저장소에 해당 사용자를 추가
		users.add(user);
		log.debug("--> 방 입장 : {}", user);
	}
	
	// 방 퇴장
	public void leave(User user) {
		// 방 참가자 저장소에서 해당 사용자를 제거
		users.remove(user);
		log.debug("--> 방 퇴장 : {}", user);
	}
	
	// 방 참가자 중 특정 아이디를 가진 사용자가 존재하는지 여부 반환
	public User search(String memberId) {
		for(User user : users) { // 방 참가자 저장소에 아이디가 저장된 모든 사용자에 대해
			// 방 참가자 저장소에 입력된 memberId를 아이디로 하는 사용자이 있으면 
			if(user.is(memberId)) return user; // 해당 사용자의 User 클래스의 인스턴스 반환
		}
		// 기본적으로 null을 반환
		return null;
	}
	
	// 방 참가자 수 반환
	public int size() {
		// 방 참가자 저장소의 길이(참가자 수) 반환
		return users.size();
	}
	
	// 메시지 전송
	// - 웹소켓 연결을 통해 웹소켓 서버에서 방 참가자 저장소에 아이디가 저장된 모든 사용자에게 메시지 전송
	public void broadcast(TextMessage message) throws IOException {
		for(User user : users) { // 방 참가자 저장소에 아이디가 저장된 모든 사용자에 대해
			user.send(message); // 웹소켓 서버가 수신한 메시지를 전송
		}
	}
}
