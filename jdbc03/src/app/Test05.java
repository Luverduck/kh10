package app;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import dto.MusicDto;
import util.JdbcUtil;

public class Test05 {

	public static void main(String[] args) {
		
		// 1. template 불러오기
		JdbcTemplate template = JdbcUtil.getTemplate();

		// 2. SQL문 작성
		String sql = "select * from music order by music_play desc";

		// 3. RowMapper 생성
		RowMapper<MusicDto> mapper = new RowMapper<MusicDto>() {
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

		// 4. List 생성
		List<MusicDto> list = template.query(sql, mapper);

		// 5. 출력
		for (MusicDto musicDto : list) {
			System.out.println(musicDto);
		}
	}
}
