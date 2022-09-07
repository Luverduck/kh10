package com.kh.springhome.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

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
	
	// RowMapper
	private RowMapper<MusicDto> mapper = new RowMapper<>() {
		@Override
		public MusicDto mapRow(ResultSet rs, int rowNum) throws SQLException {
			MusicDto musicDto = new MusicDto();
			musicDto.setMusicNo(rs.getInt("music_no"));
			musicDto.setMusicTitle(rs.getString("music_title"));
			musicDto.setMusicArtist(rs.getString("music_artist"));
			musicDto.setMusicAlbum(rs.getString("music_album"));
			musicDto.setMusicPlay(rs.getInt("music_play"));
			musicDto.setReleaseTitle(rs.getDate("release_title"));
			return musicDto;
		}
	};
	
	// MusicDao의 추상 메소드(selectList 메소드) 오버라이딩
	// 조회 - 전체 목록
	@Override
	public List<MusicDto> selectList() {
		String sql = "select * from music order by music_no asc";
		return jdbcTemplate.query(sql, mapper);
	}
	
	// 조회 - 검색
	@Override
	public List<MusicDto> selectList(String type, String keyword) {
		String sql = "select * from music where instr(#1, ?) > 0 order by #1 asc";
		sql = sql.replace("#1", type);
		Object[] param = new Object[] {keyword};
		return jdbcTemplate.query(sql, mapper, param);
	}

	private ResultSetExtractor<MusicDto> extractor = new ResultSetExtractor<>() {
		@Override
		public MusicDto extractData(ResultSet rs) throws SQLException, DataAccessException {
			if(rs.next()) {
				MusicDto musicDto = new MusicDto();
				musicDto.setMusicNo(rs.getInt("music_no"));
				musicDto.setMusicTitle(rs.getString("music_title"));
				musicDto.setMusicArtist(rs.getString("music_artist"));
				musicDto.setMusicAlbum(rs.getString("music_album"));
				musicDto.setMusicPlay(rs.getInt("music_play"));
				musicDto.setReleaseTitle(rs.getDate("release_title"));
				return musicDto;
			}
			else {
				return null;	
			}
		}
	};
	
	// 상세 조회
	@Override
	public MusicDto selectOne(int musicNo) {
		String sql = "select * from music where music_no = ?";
		Object[] param = new Object[] {musicNo};
		return jdbcTemplate.query(sql, extractor, param);
	}

	// 수정
	@Override
	public boolean update(MusicDto musicDto) {
		String sql = "update music set music_title = ?, music_artist = ?, music_album = ?, music_play = ?, release_title = ? where music_no = ?";
		Object[] param = new Object[] {musicDto.getMusicTitle(), musicDto.getMusicArtist(), musicDto.getMusicAlbum(), musicDto.getMusicPlay(), musicDto.getReleaseTitle(), musicDto.getMusicNo()};
		return jdbcTemplate.update(sql, param) > 0;
	}
}
