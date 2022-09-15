package com.kh.springhome.vo;

public class MusicYearCountVO {

	// 필드
	String musicYear;
	int cnt;
	
	// 생성자
	public MusicYearCountVO() {
		super();
	}
	
	// getter & setter
	public String getMusicYear() {
		return musicYear;
	}

	public void setMusicYear(String musicYear) {
		this.musicYear = musicYear;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
}
