package com.kh.springhome.entity;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// 파일 관련된 정보 중 무엇을 DB에 넣을 것인가?
// - PK(시퀀스) -> 실제로 저장된 파일명을 시퀀스로 대체
// - 업로드명 : 사용자가 업로드한 파일명
// - 업로드한 파일의 유형
// - 업로드한 파일의 크기
// - 업로드한 시각

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AttachmentDto {

	// 필드
	int attachmentNo;
	String attachmentName;
	String attachmentType;
	long attachmentSize;
	Date attachmentTime;
}
