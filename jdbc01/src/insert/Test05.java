package insert;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Test05 {

	public static void main(String[] args) {
		
		// 방명록(guest_book) 테이블에 데이터를 등록할 수 있도록 구현
		// no number, name varchar2, memo varchar2
		
		// 준비
		String name = "나";
		String memo = "저두용";
		
		// 1. 데이터베이스 로그인
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUsername("khacademy");
		dataSource.setPassword("khacademy");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
		
		// 2. 구문 실행 도구 생성
		JdbcTemplate template = new JdbcTemplate(dataSource);
		
		// 3. SQL 구문 생성
		//String sql = "insert into guest_book(no, name, memo) values(test_seq.nextval, ?, ?)";
		String sql = "insert into guest_book(no, name, memo) values(guest_book_seq.nextval, ?, ?)";
		
		// 변수 배열 생성
		Object[] param = {name, memo};
		
		// 3. 실행
		template.update(sql, param);
		
		// 4. 확인용 출력
		System.out.println("완료!");
	}
}
