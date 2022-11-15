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

	// 사용자 목록
	private Set<User> users = new CopyOnWriteArraySet<>();
	
	// 입장
	public void enter(User user) {
		users.add(user);
		log.debug("--> 방 입장 : {}", user);
	}
	
	// 퇴장
	public void leave(User user) {
		users.remove(user);
		log.debug("--> 방 퇴장 : {}", user);
	}
	
	// 아이디로 해당 회원이 존재하는지 여부 반환
	public User search(String memberId) {
		for(User user : users) {
			if(user.is(memberId)) return user;
		}
		return null;
	}
	
	// 방에 존재하는 인원수 반환
	public int size() {
		return users.size();
	}
	
	// 메시지 전송(전체)
	public void broadcast(TextMessage message) throws IOException {
		for(User user : users) {
			user.send(message);
		}
	}
}
