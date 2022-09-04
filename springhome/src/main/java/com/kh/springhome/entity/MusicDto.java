package com.kh.springhome.entity;

import java.sql.Date;

public class MusicDto {

	// 필드
	int musicNo;
	String musicTitle;
	String musicArtist;
	String musicAlbum;
	int musicPlay;
	Date releaseTitle;
	
	// 생성자
	public MusicDto() {
		super();
	}

	// getter & setter
	public int getMusicNo() {
		return musicNo;
	}

	public void setMusicNo(int musicNo) {
		this.musicNo = musicNo;
	}

	public String getMusicTitle() {
		return musicTitle;
	}

	public void setMusicTitle(String musicTitle) {
		this.musicTitle = musicTitle;
	}

	public String getMusicArtist() {
		return musicArtist;
	}

	public void setMusicArtist(String musicArtist) {
		this.musicArtist = musicArtist;
	}

	public String getMusicAlbum() {
		return musicAlbum;
	}

	public void setMusicAlbum(String musicAlbum) {
		this.musicAlbum = musicAlbum;
	}

	public int getMusicPlay() {
		return musicPlay;
	}

	public void setMusicPlay(int musicPlay) {
		this.musicPlay = musicPlay;
	}

	public Date getReleaseTitle() {
		return releaseTitle;
	}

	public void setReleaseTitle(Date releaseTitle) {
		this.releaseTitle = releaseTitle;
	}
	
	// toString 오버라이딩
	@Override
	public String toString() {
		return "MusicDto [musicNo=" + musicNo + ", musicTitle=" + musicTitle + ", musicArtist=" + musicArtist
				+ ", musicAlbum=" + musicAlbum + ", musicPlay=" + musicPlay + ", releaseTitle=" + releaseTitle + "]";
	}
}
