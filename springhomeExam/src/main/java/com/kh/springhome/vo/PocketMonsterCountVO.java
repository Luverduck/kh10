package com.kh.springhome.vo;

// VO (Value Object) - 값을 편하게 처리하기 위한 클래스
public class PocketMonsterCountVO {

	// 필드
	private String type;
	private int cnt;		// DB에서 정한 별칭을 입력
	
	// 생성자
	public PocketMonsterCountVO() {
		super();
	}

	// getter & setter
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
}
