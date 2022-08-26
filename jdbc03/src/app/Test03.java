package app;

import java.util.Scanner;

import org.springframework.jdbc.core.JdbcTemplate;

import util.JdbcUtil;

public class Test03 {

	public static void main(String[] args) {
		
		// 1. template 불러오기
		JdbcTemplate template = JdbcUtil.getTemplate();
		
		// 2. SQL문
		String sql = "update music set music_play = music_play + 1 where music_no = ?";
		
		// 3. 입력 및 배열 생성
		Scanner sc = new Scanner(System.in);
		System.out.print("음원 번호 : ");
		int musicNo = sc.nextInt();
		sc.nextLine();
		Object[] param = new Object[] {musicNo};
		
		// 4. 실행
		int result = template.update(sql, param);
		
		if(result > 0) {
			System.out.println("재생 성공");
		}
		else {
			System.out.println("존재하지 않는 음원 번호");
		}
		
		sc.close();
	}
}
