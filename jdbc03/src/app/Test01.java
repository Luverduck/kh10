package app;
 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import dto.MusicDto;
import util.JdbcUtil;

public class Test01 {

	public static void main(String[] args) {

		// 1. template 불러오기
		JdbcTemplate template = JdbcUtil.getTemplate();

		// 2. SQL문 작성
		String sql = "insert into music(music_no, music_title, music_artist, music_album, music_play, release_title) values(music_seq.nextval, ?, ?, ?, 0, to_Date(?, 'YYYY-MM-DD'))";

		// 3. 입력 및 Object 배열 생성
		Scanner sc = new Scanner(System.in);
		System.out.print("음원 타이틀 : ");
		String musicTitle = sc.nextLine();
		System.out.print("음원 가수명 : ");
		String musicArtist = sc.nextLine();
		System.out.print("음원 앨범이름 : ");
		String musicAlbum = sc.nextLine();
		System.out.print("음원 발매일 : ");
		String releaseTitle = sc.nextLine();

		Object[] param = new Object[] { musicTitle, musicArtist, musicAlbum, releaseTitle };

		// 4. 실행
		int result = template.update(sql, param);

		if (result > 0) {
			System.out.println("등록 완료");
		} else {
			System.out.println("등록 실패");
		}

		sc.close();
	}
}
