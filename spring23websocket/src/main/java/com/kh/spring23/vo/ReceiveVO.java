package com.kh.spring23.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// 사용자가 그룹채팅에서 보내는 메시지를 수신하는 vo
@JsonIgnoreProperties // 필드의 값이 모두 있지 않아도 처리가 가능하도록
@Data 
@NoArgsConstructor 
@AllArgsConstructor 
@Builder
public class ReceiveVO {
	
	// 필드
	private int type; // 유형 - 방 참가 / 메시지 전송을 구별하기 위함
	private String room; // 방 이름 - 방 참가를 위한 필드
	private String text; // 메시지 내용 - 메시지 전송을 위한 필드
}
