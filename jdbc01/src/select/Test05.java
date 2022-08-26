package select;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import util.JdbcUtil;

public class Test05 {

	public static void main(String[] args) {
		
		// gest_book 테이블의 모든 데이터를 최신순으로 출력
		// - 단, 클래스명은 'GuestBookDto'라고 하세요
		// - 필드명은 데이터베이스 컬럼명과 동일하게 작성하세요
		
		// 1. template 불러오기
		JdbcTemplate template = JdbcUtil.getTemplate();
		
		// 2. SQL문 작성
		String sql = "select * from guest_book order by no desc";
		
		// 3. RowMapper 클래스 생성 - 변환 방법이 작성된 객체를 구현
		RowMapper<GuestBookDto> mapper = new RowMapper<GuestBookDto>() {
			@Override
			public GuestBookDto mapRow(ResultSet rs, int idx) throws SQLException {
				// GuestBookDto의 인스턴스 c 생성
				GuestBookDto c = new GuestBookDto();
				// 필드값 세팅
				c.setNo(rs.getInt("no"));
				c.setName(rs.getString("name"));
				c.setMemo(rs.getString("memo"));
				// 세팅된 인스턴스 c를 반환
				return c;
			}
		};
		
		// 4. List 생성 - 데이터 '순서'가 유지되어야 하기 때문
		List<GuestBookDto> list = template.query(sql, mapper);
		
		// 5. 출력
		for(GuestBookDto c : list) {
			System.out.println(c);
		}
	}
}
