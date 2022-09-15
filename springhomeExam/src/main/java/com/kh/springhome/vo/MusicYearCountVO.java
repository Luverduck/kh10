package com.kh.springhome.vo;

public class MusicYearCountVO {

	// 필드
	private int rank;
	private int year;
	private int cnt;
	
	// 생성자
	public MusicYearCountVO() {
		super();
	}
	
	// getter & setter
	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

}
