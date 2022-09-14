package com.kh.springhome.entity;

public class PasswordDto {

	// 필드
	String pwNow;		// 현재 비밀번호
	String pwChange;		// 변경 비밀번호
	String pwChangeCheck;	// 비밀번호 확인
	
	// 생성자
	public PasswordDto() {
		super();
	}
	
	// getter & setter
	public String getPwNow() {
		return pwNow;
	}
	public void setPwNow(String pwNow) {
		this.pwNow = pwNow;
	}
	public String getPwChange() {
		return pwChange;
	}
	public void setPwChange(String pwChange) {
		this.pwChange = pwChange;
	}
	public String getPwChangeCheck() {
		return pwChangeCheck;
	}
	public void setPwChangeCheck(String pwChangeCheck) {
		this.pwChangeCheck = pwChangeCheck;
	}
}
