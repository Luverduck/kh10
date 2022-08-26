package app;

import java.util.Scanner;

import org.springframework.jdbc.core.JdbcTemplate;

import util.JdbcUtil;

public class Test04 {

	public static void main(String[] args) {
		
		// 1. template 불러오기
		JdbcTemplate template = JdbcUtil.getTemplate();
		
		// 2. SQL문 작성
		String sql = "delete music where music_no = ?";
		
		// 3. 입력 및 Object 배열 생성
		Scanner sc = new Scanner(System.in);
		int musicNo = sc.nextInt();
		
		Object[] param = new Object[] {musicNo};

		// 4. 실행
		int result = template.update(sql);
	}
}
