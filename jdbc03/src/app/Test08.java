package app;

import org.springframework.jdbc.core.JdbcTemplate;

import util.JdbcUtil;

public class Test08 {

	public static void main(String[] args) {
		
		// 1. template 불러오기
		JdbcTemplate template = JdbcUtil.getTemplate();
		
		// 2. SQL문 작성 (합계)
		String sql = "select sum(music_play) from music";
				
		// 3. 출력
		int sum = template.queryForObject(sql, int.class);
		System.out.println("sum = " + sum);
		
		// .class는 모든 클래스에 자동으로 생기는 클래스 정보 객체
		
		/*
		// 2. SQL문 작성 (평균)
		String sql = "select avg(music_play) from music";
		
		// 3. 출력
		double avg = template.queryForObject(sql, double.class);
		System.out.println("avg = " + avg);
		*/
	}
}
