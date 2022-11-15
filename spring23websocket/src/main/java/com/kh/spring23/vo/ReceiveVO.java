package com.kh.spring23.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// 사용자가 그룹채팅에서 보내는 메시지를 수신하는 vo
@JsonIgnoreProperties // 필드의 값이 모두 있지 않아도 처리가 가능하도록
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class ReceiveVO {
	
	private int type;
	private String room;
	private String text;
}
