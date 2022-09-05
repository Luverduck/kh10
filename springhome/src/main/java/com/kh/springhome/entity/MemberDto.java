package com.kh.springhome.entity;

import java.sql.Date;

public class MemberDto {

	// 필드
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
	
	// 생성자
	public MemberDto() {
		super();
	}
	
	// getter & setter
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberPw() {
		return memberPw;
	}
	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}
	public String getMemberNick() {
		return memberNick;
	}
	public void setMemberNick(String memberNick) {
		this.memberNick = memberNick;
	}
	public Date getMemberBirth() {
		return memberBirth;
	}
	public void setMemberBirth(Date memberBirth) {
		this.memberBirth = memberBirth;
	}
	public String getMemberTel() {
		return memberTel;
	}
	public void setMemberTel(String memberTel) {
		this.memberTel = memberTel;
	}
	public String getMemberEmail() {
		return memberEmail;
	}
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}
	public String getMemberPost() {
		return memberPost;
	}
	public void setMemberPost(String memberPost) {
		this.memberPost = memberPost;
	}
	public String getMemberBaseAddress() {
		return memberBaseAddress;
	}
	public void setMemberBaseAddress(String memberBaseAddress) {
		this.memberBaseAddress = memberBaseAddress;
	}
	public String getMemberDetailAddress() {
		return memberDetailAddress;
	}
	public void setMemberDetailAddress(String memberDetailAddress) {
		this.memberDetailAddress = memberDetailAddress;
	}
	public int getMemberPoint() {
		return memberPoint;
	}
	public void setMemberPoint(int memberPoint) {
		this.memberPoint = memberPoint;
	}
	public String getMemberGrade() {
		return memberGrade;
	}
	public void setMemberGrade(String memberGrade) {
		this.memberGrade = memberGrade;
	}
	public Date getMemberJoin() {
		return memberJoin;
	}
	public void setMemberJoin(Date memberJoin) {
		this.memberJoin = memberJoin;
	}
	public Date getMemberLogin() {
		return memberLogin;
	}
	public void setMemberLogin(Date memberLogin) {
		this.memberLogin = memberLogin;
	}

	// toString 오버라이딩 - memberPw(비밀번호)는 보안을 위해 제외할 것
	@Override
	public String toString() {
		return "MemberDto [memberId=" + memberId + ", memberNick=" + memberNick
				+ ", memberBirth=" + memberBirth + ", memberTel=" + memberTel + ", memberEmail=" + memberEmail
				+ ", memberPost=" + memberPost + ", memberBaseAddress=" + memberBaseAddress + ", memberDetailAddress="
				+ memberDetailAddress + ", memberPoint=" + memberPoint + ", memberGrade=" + memberGrade
				+ ", memberJoin=" + memberJoin + ", memberLogin=" + memberLogin + "]";
	}
}
