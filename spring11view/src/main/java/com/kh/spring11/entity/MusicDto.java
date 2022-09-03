package com.kh.spring11.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

public class MusicDto {

	// 필드
	private int musicNo;
	private String musicTitle;
	private String musicArtist;
	private String musicAlbum;
	private int musicPlay;
	private String releaseTitle;
	
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

	public String getReleaseTitle() {
		return releaseTitle;
	}

	public void setReleaseTitle(String releaseTitle) {
		this.releaseTitle = releaseTitle;
	}

	public static void setMapper(RowMapper<MusicDto> mapper) {
		MusicDto.mapper = mapper;
	}

	public static void setExtractor(ResultSetExtractor<MusicDto> extractor) {
		MusicDto.extractor = extractor;
	}

	
	// toString 오버라이딩
	@Override
	public String toString() {
		return "MusicDto [musicNo=" + musicNo + ", musicTitle=" + musicTitle + ", musicArtist=" + musicArtist
				+ ", musicAlbum=" + musicAlbum + ", musicPlay=" + musicPlay + ", releaseTitle=" + releaseTitle + "]";
	}
	
	// RowMapper
	private static RowMapper<MusicDto> mapper = new RowMapper<MusicDto>() {
		@Override
		public MusicDto mapRow(ResultSet rs, int idx) throws SQLException {
			MusicDto musicDto = new MusicDto();
			musicDto.setMusicNo(rs.getInt("music_no"));
			musicDto.setMusicTitle(rs.getString("music_title"));
			musicDto.setMusicArtist(rs.getString("music_artist"));
			musicDto.setMusicAlbum(rs.getString("music_album"));
			musicDto.setMusicPlay(rs.getInt("music_play"));
			musicDto.setReleaseTitle(rs.getString("release_title"));
			return musicDto;
		}
	};
	
	public static RowMapper<MusicDto> getMapper(){
		return mapper;
	}
	
	// ResultSetExtractor
	private static ResultSetExtractor<MusicDto> extractor = new ResultSetExtractor<MusicDto>() {
		@Override
		public MusicDto extractData(ResultSet rs) throws SQLException, DataAccessException {
			if(rs.next()) {
				MusicDto musicDto = new MusicDto();
				musicDto.setMusicNo(rs.getInt("music_no"));
				musicDto.setMusicTitle(rs.getString("music_title"));
				musicDto.setMusicArtist(rs.getString("music_artist"));
				musicDto.setMusicAlbum(rs.getString("music_album"));
				musicDto.setMusicPlay(rs.getInt("music_play"));
				musicDto.setReleaseTitle(rs.getString("release_title"));
				return musicDto;
			}
			else {
				return null;
			}
		}
	};
	
	public static ResultSetExtractor<MusicDto> getExtractor(){
		return extractor;
	};
}
