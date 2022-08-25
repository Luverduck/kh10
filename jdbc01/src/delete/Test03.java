package delete;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import util.JdbcUtil;

public class Test03 {

	public static void main(String[] args) {
		
		// select는 insert, update, delete와 같은 방법으로는 사용 불가
		// (추가) 
		// - 테이블을 객체 형태로 변환해서 List로 추출해야 한다 -> List<Country> = new List<>();
		// - 자바는 테이블의 한 줄이 어떻게 객체에 추가되어야 하는지를 모른다
		
		// 1. template 불러오기
		JdbcTemplate template = JdbcUtil.getTemplate();
		
		// 2. SQL문 작성
		String sql = "select * from fifa";
		
		// 변경 방법이 작성된 객체를 구현 - RowMapper 클래스 사용
		RowMapper<Country> mapper = new RowMapper<Country>() {
			@Override
			public Country mapRow(ResultSet rs, int idx) throws SQLException {
				// rs에 들어있는 데이터를 꺼내서 country로 복사하는 코드
				// - rs에서 데이터를 꺼내는 명령 : rs.getString(), rs.getInt(), ...
				Country c = new Country();
				
				// c.setRank(rs에 들어있는 데이터 중에서 rank 컬럼의 값);
				c.setRank(rs.getInt("rank"));
				c.setNation(rs.getString("nation"));
				c.setScore(rs.getDouble("score"));
				
				// 설정된 c를 반환
				return c;
			}
		};
		
		// List 생성
		//List<Coutry> list = template.query(sql, 변경방법);
		List<Country> list = template.query(sql, mapper);
		
		for(Country c : list) {
			System.out.println(c);
		}
	}
}
