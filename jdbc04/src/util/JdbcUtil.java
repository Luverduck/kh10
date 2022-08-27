package util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import dto.BookDto;

// 매번 반복되는 도구 생성 코드를 간소화시키기 위한 클래스
public class JdbcUtil {
	
	// template 불러오기
	public static JdbcTemplate getTemplate() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUsername("khacademy");
		dataSource.setPassword("khacademy");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
		
		JdbcTemplate template = new JdbcTemplate(dataSource);
		
		return template;
	}
}
