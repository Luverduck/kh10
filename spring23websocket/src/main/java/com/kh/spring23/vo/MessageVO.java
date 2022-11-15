package com.kh.spring23.vo;

import java.util.Date;

import javax.validation.constraints.NegativeOrZero;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// 서버에서 클라이언트와 소통하기 위한 JSON 처리용 VO

@JsonIgnoreProperties // JSON 속성을 무시 - 이 어노테이션을 추가해야 데이터가 없어도 변환해준다
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MessageVO {
	
	private String text; // 클라이언트가 보내는 정보
	private Date time; // 서버가 추가해야 할 정보
	
	// 로그인 정보
	private String id;
	private String nickname;
	private String auth;
}
