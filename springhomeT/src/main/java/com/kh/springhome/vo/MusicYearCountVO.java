package com.kh.springhome.vo;

public class MusicYearCountVO {
	private int rank;
	private int year;
	private int cnt;
	@Override
	public String toString() {
		return "MusicYearCountVO [rank=" + rank + ", year=" + year + ", cnt=" + cnt + "]";
	}
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
	public MusicYearCountVO() {
		super();
	}
}
