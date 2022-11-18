package com.kh.spring24.entity;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberDto {

	/// 필드
	private String memberId;
	private String memberPw;
	private String memberNick;
	private Date memberBirth;
	private String memberTel;
	private String memberEmail;
	private String memberPost;
	private String memberBaseAddress;
	private String memberDetailAddress;
	private int memberPoint;
	private String memberGrade;
	private Date memberJoin;
	private Date memberLogin;
}
