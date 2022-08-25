package insert;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Test04 {

	public static void main(String[] args) {

		// 포켓몬스터 테이블(pocket_monster) 테이블에 데이터를 등록할 수 있도록 구현
		// no number, name varchar2, type varchar2

		// 1. 데이터베이스 로그인
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUsername("khacademy");
		dataSource.setPassword("khacademy");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
		
		// 2. 구문 실행 도구 생성
		JdbcTemplate template = new JdbcTemplate(dataSource);

		// 3. SQL 구문 생성
		String sql = "insert into pocket_monster(no, name, type) values(?, ?, ?)";

		// 변수 준비
		int no = 2;
		String name = "이상해풀";
		String type = "풀";

		// 변수 배열 생성
		Object[] param = {no, name, type};

		// 3. 실행
		template.update(sql, param);

		// 확인용 출력
		System.out.println("완료!");
	}
}
