package com.kh.springhome.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.springhome.entity.MusicDto;

@Repository
public class MusicDaoImpl implements MusicDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	// MusicDao의 추상 메소드(insert 메소드) 오버라이딩
	@Override
	public void insert(MusicDto musicDto) {
		String sql = "insert into music(music_no, music_title, music_artist, music_album, music_play, release_title) values(music_seq.nextval, ?, ?, ?, 0, ?)";
		Object[] param = new Object[] {musicDto.getMusicTitle(), musicDto.getMusicArtist(), musicDto.getMusicAlbum(), musicDto.getReleaseTitle()};
		jdbcTemplate.update(sql, param);
	}

}
