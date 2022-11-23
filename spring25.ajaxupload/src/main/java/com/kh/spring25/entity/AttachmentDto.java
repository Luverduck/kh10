package com.kh.spring25.entity;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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