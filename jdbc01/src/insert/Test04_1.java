package insert;

import java.util.Scanner;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Test04_1 {

	public static void main(String[] args) {

		// 포켓몬스터 테이블(pocket_monster) 테이블에 데이터를 등록할 수 있도록 구현
		// no number, name varchar2, type varchar2

		Scanner sc = new Scanner(System.in);
		
		// 준비
		System.out.println("번호 : ");
		int no = sc.nextInt();
		sc.nextLine();
		System.out.println("이름 : ");
		String name = sc.nextLine();
		sc.nextLine();
		System.out.println("타입 : ");
		System.out.println();
		String type = sc.nextLine();
		sc.nextLine();
		
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

		// 변수 배열 생성
		Object[] param = {no, name, type};

		// 3. 실행
		template.update(sql, param);

		// 확인용 출력
		System.out.println("완료!");
	}
}
