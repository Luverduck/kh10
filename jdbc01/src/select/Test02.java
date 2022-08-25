package select;

import org.springframework.jdbc.core.JdbcTemplate;
import util.JdbcUtil;

public class Test02 {

	public static void main(String[] args) {

		// 조회(select)
		// select * from fifa;

		JdbcTemplate template = JdbcUtil.getTemplate();

		String sql = "select * from fifa";

		// Object[] param = {};
		// template.update(sql, param);
		int result = template.update(sql);

		System.out.println("result = " + result);
	}
}
