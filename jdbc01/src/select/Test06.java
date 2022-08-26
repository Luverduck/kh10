package select;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import util.JdbcUtil;

public class Test06 {

	// customer 테이블의 모든 데이터를 번호순으로 출력
	// - 단, 클래스명은 'CustomerDto'라고 하세요
	// - 필드명은 데이터베이스 컬럼명과 동일하게 작성하세요
	
	public static void main(String[] args) {
		
		// 1. template 불러오기
		JdbcTemplate template = JdbcUtil.getTemplate();
		
		// 2. SQL문 작성
		String sql = "select * from customer order by customer_num asc";
		
		// 3. RowMapper 클래스 작성
		RowMapper<CustomerDto> mapper = new RowMapper<CustomerDto>() {
			@Override
			public CustomerDto mapRow(ResultSet rs, int idx) throws SQLException {
				// CustomerDto의 인스턴스 생성
				CustomerDto c = new CustomerDto();
				// 필드 세팅
				c.setCustomerNum(rs.getInt("customer_Num"));
				c.setCustomerId(rs.getString("customer_Id"));
				c.setCustomerTel(rs.getString("customer_tel"));
				c.setCustomerRegistration(rs.getString("customer_registration"));
				c.setCustomerPurchase(rs.getString("customer_purchase"));
				c.setCustomerPoint(rs.getInt("customer_point"));
				c.setCustomerLv(rs.getString("customer_lv"));
				return c;
			}
		};
		
		// 4. List 생성
		List<CustomerDto> list = template.query(sql, mapper);
		
		// 출력
		for(CustomerDto c : list) {
			System.out.println(c);
		}
	}
}
