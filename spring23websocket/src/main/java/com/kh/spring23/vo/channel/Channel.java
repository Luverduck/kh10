package com.kh.spring23.vo.channel;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.socket.TextMessage;

/*
	방들을 관리할 수 있는 채널 클래스
	- 방을 관리할 수 있는 필드와 메소드 필요
*/
public class Channel {

	// 방들을 이름으로 관리할 수 있는 저장소
	//Map<String, Room> rooms = new HashMap<>(); // HashMap은 동기화가 안됨
	Map<String, Room> rooms = Collections.synchronizedMap(new HashMap<>());
	
	// 입장
	public void join(User user, String name) {
		if(!rooms.containsKey(name)) { // 방이 없으면 (key에 해당 방 이름이 없으면)
			rooms.put(name, new Room()); // 해당 이름(name)으로 방을 생성
		}
		// 입장시키세요
		rooms.get(name).enter(user);
	}
	
	// 검색 - 방 이름 반환
	public String find(User user) {
		for(String name : rooms.keySet()) { // 모든 방을 반복하며
			Room room = rooms.get(name); // 방 하나를 꺼낸다
			if(room.search(user.getMemberId()) != null) { // 방에 해당 사용자가 있으면
				return name; // 해당 방을 반환
			}
		}
		return null;
	}
	
	// 퇴장
	public void exit(User user) {
		// 해당 유저가 있는 방 이름을 찾아서 반환
		String name = this.find(user);
		// 방에서 나가게
		rooms.get(name).leave(user);
		// 방이 비어있으면(방의 인원이 0명이면)
		if(rooms.get(name).size() == 0) {
			rooms.remove(name);
		}
	}
	
	// 해당 방에 메시지를 전송하는 기능 (전체 / 방 안에만 / 특정사용자에게) -> 일단 특정 방에만 메시지 전송하는 기능 구현
	// - 사용자와 메시지를 알아야 한다
	public void send(User user, TextMessage message) throws IOException {
		String name = this.find(user);
		if(name != null) {
			rooms.get(name).broadcast(message);
		}
	}
}
