package com.kh.spring12;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootTest
public class Test02 {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Test
	public void basic02() {
		int no = 55;
		String name = "또가스";
		String type = "독";
		
		String sql = "insert into pocket_monster(no, name, type) values(?, ?, ?)";
		Object[] param = new Object[] {no, name, type};
		
		jdbcTemplate.update(sql, param);
	}
}
