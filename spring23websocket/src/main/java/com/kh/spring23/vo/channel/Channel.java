package com.kh.spring23.vo.channel;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

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
	
	// 퇴장
	
	
	// 검색
	
}
