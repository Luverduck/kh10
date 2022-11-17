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

	// 방 저장소 
	// - 방 이름으로 Room 클래스의 인스턴스를 관리하는 저장소
	// - 동기화된 Map 사용
	Map<String, Room> rooms = Collections.synchronizedMap(new HashMap<>());
	
	// 방 입장
	public void join(User user, String name) {
		if(!rooms.containsKey(name)) { // 해당 이름(name)의 방이 없으면
			rooms.put(name, new Room()); // 해당 이름으로 방을 생성
		}
		// 특정 이름(name)의 방에 특정 사용자(user) 입장
		// - rooms.get(name)까지의 결과로 해당 이름(name)의 Room 클래스의 인스턴스가 반환된다
		rooms.get(name).enter(user);
	}
	
	// 방 이름 반환
	// - 특정 사용자가 참가하고 있는 방의 이름 반환
	public String find(User user) {
		// 방 저장소의 Key인으로 다음 작업을 수행
		for(String name : rooms.keySet()) { // keySet() - Map의 Key만 반환
			// 방 저장소에서 Room 클래스의 인스턴스를 반환
			Room room = rooms.get(name);
			// 반환한 인스턴스의 방 참가자 저장소에서 특정 아이디를 가진 참가자가 존재하면
			if(room.search(user.getMemberId()) != null) {
				// 해당 방의 이름을 반환
				return name;
			}
		}
		// 기본적으로 null을 반환
		return null;
	}
	
	// 방 퇴장
	public void exit(User user) {
		// 특정 사용자가 참가하고 있는 방의 이름을 반환
		String name = this.find(user);
		// 해당 이름의 방에서 퇴장
		// - rooms.get(name)의 결과로 해당 이름(name)을 가진 Room 클래스의 인스턴스 반환
		rooms.get(name).leave(user);
		// 해당 이름의 방에 참가하고 있는 참가자 수가 0인 경우
		if(rooms.get(name).size() == 0) {
			// 해당 이름의 방 제거
			rooms.remove(name);
		}
	}
	
	// 특정 방의 참가자 전체에게만 메시지 전송
	public void send(User user, TextMessage message) throws IOException {
		// 특정 사용자가 참가하고 있는 방의 이름을 반환
		String name = this.find(user);
		// 참가하고 있는 방이 있다면 (name이 null이 아닌 경우)
		if(name != null) {
			// 해당 이름의 방에 메시지 전송
			// - rooms.get(name)의 결과로 해당 이름(name)을 가진 Room 클래스의 인스턴스 반환
			// - broadcast(message) 메소드는 해당 방 참가자 저장소에 아이디가 저장된 모든 사용자에게 메시지 전송
			rooms.get(name).broadcast(message);
		}
	}
}
