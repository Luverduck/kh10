package app;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import dto.MusicDto;
import util.JdbcUtil;

public class Test09 {

	public static void main(String[] args) {
		
		// 노래 한 곡에 대한 정보만 출력 -> primarity를 기준
		
		// 비추천 방식 : RowMapper로 List를 만들고 index=0의 값 추출
		
		// 준비
		int musicNo = 9;
		
		// DB
		JdbcTemplate template = JdbcUtil.getTemplate();
		
		// SQL문
		String sql = "select * from music where music_no = ?";
		
		Object[] param = {musicNo};
		
		
		// ResultSetExtractor
		ResultSetExtractor<MusicDto> extractor = new ResultSetExtractor<MusicDto>() {
			@Override
			public MusicDto extractData(ResultSet rs) throws SQLException, DataAccessException {
				if(rs.next()) {	// rs에 데이터가 있다면
					MusicDto musicDto = new MusicDto();
					musicDto.setMusicNo(rs.getInt("music_no"));
					musicDto.setMusicTitle(rs.getString("music_title"));
					musicDto.setMusicArtist(rs.getString("music_artist"));
					musicDto.setMusicAlbum(rs.getString("music_album"));
					musicDto.setMusicPlay(rs.getInt("music_play"));
					musicDto.setReleaseTitle(rs.getString("release_title"));
					return musicDto;
				}
				else {	// rs에 데이터가 없다면
					return null;
				}
			}
		};
		
		// SQL구문, param, extractor를 이용하여 조회 명령
		MusicDto musicDto = template.query(sql, extractor, param);	// 없으면 null이 들어가고 있으면 MusicDto가 들어감
		if(musicDto == null) {
			System.out.println("존재하지 않는 음원 번호");
		}
		else {
			System.out.println(musicDto);
		}
	}
}
