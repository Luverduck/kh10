package app;

import org.springframework.jdbc.core.JdbcTemplate;

import util.JdbcUtil;

public class Test07 {

	public static void main(String[] args) {
		
		// 집계함수에 대한 결과 조회
		// - sum, avg, max, count
		
		// - 집계함수의 결과는 ResultSet이지만 데이터는 하나밖에 없다
		// - select에서 사용했던 ResultSet을 출력하는 방법
		
		// 1. template 불러오기
		JdbcTemplate template = JdbcUtil.getTemplate();
		
		// 2. 
		String sql = "select count(*) from music";
		
		// 3. RowMapper 클래스는 필요없음
		
		// queryForObject(sql, 얻어낼 데이터의 자료형) : Object 1개를 얻어내는 명령
		int count = template.queryForObject(sql, int.class);
		
		System.out.println("count = " + count);
	}
}
