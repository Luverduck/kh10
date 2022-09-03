package select;

import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import util.JdbcUtil;

public class Test04 {

	public static void main(String[] args) {
		
		// select는 insert, update, delete와 같은 방법으로는 사용 불가
		// (추가) 
		// - 테이블을 객체 형태로 변환해서 List로 추출해야 한다 -> List<Country> = new List<>();
		// - 자바는 테이블의 한 줄이 어떻게 객체에 추가되어야 하는지를 모른다
		
		// 1. template 불러오기
		JdbcTemplate template = JdbcUtil.getTemplate();
		
		// 2. SQL문 작성
		String sql = "select * from fifa";
		
		// 변환방법이 작성된 객체를 구현 - RowMapper 클래스 사용
		// RowMapper : row를 객체에 mapping해주는 클래스
		// 람다식 방식
		RowMapper<Country> mapper = (rs, idx)-> {
			Country c = new Country();
			c.setRank(rs.getInt("rank"));
			c.setNation(rs.getString("nation"));
			c.setScore(rs.getDouble("score"));
			return c;
		};
		
		// List 생성
		//List<Coutry> list = template.query(sql, 변환방법);
		//template에 SQL문과 변환방법을 알려줌
		List<Country> list = template.query(sql, mapper);
		
		for(Country c : list) {
			System.out.println(c);
		}
	}
}
