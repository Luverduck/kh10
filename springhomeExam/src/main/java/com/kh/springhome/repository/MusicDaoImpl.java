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

import com.kh.springhome.entity.MusicDto;
import com.kh.springhome.vo.MusicLatestListVO;
import com.kh.springhome.vo.MusicYearCountVO;

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

	// 삭제
	@Override
	public boolean delte(int musicNo) {
		String sql = "delete music where music_no = ?";
		return jdbcTemplate.update(sql, musicNo) > 0;
	}

	// 추상 메소드 오버라이딩 - Top 10
	@Override
	public List<MusicDto> selectTopTen() {
		String sql = "select * from (select TMP.*, rownum music_rate from (select * from music order by music_play desc)TMP) where music_rate <= 10";
		return jdbcTemplate.query(sql, mapper);
	}

	// 추상 메소드 오버라이딩 - Top N
	@Override
	public List<MusicDto> selectTopN(int limit) {
		String sql = "select * from (select TMP.*, rownum music_rate from (select * from music order by music_play desc)TMP) where music_rate between 1 and ?";
		Object[] param = new Object[] {limit};
		return jdbcTemplate.query(sql, mapper, param);
	}
	
	// 추상 메소드 오버라이딩 - Top N to N
	@Override
	public List<MusicDto> selectTopNtoN(int begin, int end) {
		String sql = "select * from (select TMP.*, rownum music_rate from (select * from music order by music_play desc)TMP) where music_rate between ? and ?";
		Object[] param = new Object[] {begin, end};
		return jdbcTemplate.query(sql, mapper, param);
	}
	
	// MusicYearCountVO를 위한 Mapper
	RowMapper<MusicYearCountVO> countMapper = new RowMapper<>() {
		@Override
		public MusicYearCountVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			MusicYearCountVO vo = new MusicYearCountVO();
			vo.setRank(rs.getInt("rank"));
			vo.setYear(rs.getInt("year"));
			vo.setCnt(rs.getInt("cnt"));
			return vo;
		}
	};
	
	// 추상 메소드 오버라이딩 - 연도별 발매수
	@Override
	public List<MusicYearCountVO> releaseByYear() {
		// to_char(release_title, 'yyyy')
		// extractor(year from release_title)
		String sql = "select to_char(release_title, 'yyyy') year, count(*) cnt from music group by to_char(release_title, 'yyyy') order by year desc";
		return jdbcTemplate.query(sql, countMapper);
	}
	
	// 추상 메소드 오버라이딩 - 연도별 발매수 + 순위
	@Override
	public List<MusicYearCountVO> releaseByYearWithRank() {
		// to_char(release_title, 'yyyy')
		// extractor(year from release_title)
		String sql = "select TMP.*, rank() over(order by cnt desc) rank from (select extract(year from release_title) year, count(*) cnt from music group by extract(year from release_title) order by year desc)TMP";
		return jdbcTemplate.query(sql, countMapper);
	}

	// MusicLatestListVO를 위한 Mapper
	private RowMapper<MusicLatestListVO> listMapper = new RowMapper<>() {
		@Override
		public MusicLatestListVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			return MusicLatestListVO.builder()
					.musicNo(rs.getInt("music_no"))
					.musicTitle(rs.getString("music_title"))
					.musicArtist(rs.getString("music_artist"))
					.releaseTitle(rs.getDate("release_title"))
					.build();
		}
	};
	
	// 추상 메소드 오버라이딩 - 최근에 등록된 음원
	@Override
	public List<MusicLatestListVO> musicLatest() {
		String sql = "select music_no, music_title, music_artist, release_title from (select TMP.*, rownum rn from(select * from music order by release_title desc)TMP) where rn between 1 and 5";
		return jdbcTemplate.query(sql, listMapper);
	}

	@Override
	public List<MusicLatestListVO> musicLatest(Integer musicEnd) {
		String sql = "select music_no, music_title, music_artist, release_title from (select TMP.*, rownum rn from(select * from music order by release_title desc)TMP) where rn between 1 and ?";
		Object[] param = new Object[] {musicEnd};
		return jdbcTemplate.query(sql, listMapper, param);
	}
}
