package app;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import dto.MusicDto;
import util.JdbcUtil;

public class Test06 {

	public static void main(String[] args) {
		
		// 1. template 불러오기
		JdbcTemplate template = JdbcUtil.getTemplate();
		
		// 2. SQL문 작성
		String sql = "select * from music where music_title like '%'||?||'%' or music_artist like '%'||?||'%' or music_album like '%'||?||'%'";
		
		// 3. 입력 및 Object 배열 생성
		Scanner sc = new Scanner(System.in);
		System.out.print("검색어 : ");
		String search = sc.nextLine();
		
		Object[] param = new Object[] {search, search, search};
		
		// 4. RowMapper 생성 - RowMapper도 Dto안에 넣어두면 매번 반복해서 쓸 필요가 없다
		RowMapper<MusicDto> mapper = new RowMapper<MusicDto>(){
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
		
		// 5. List 생성
		List<MusicDto> list = template.query(sql, mapper, param);
		
		// 6. 출력
		for(MusicDto musicDto : list) {
			System.out.println(musicDto);
		}
	}
}
