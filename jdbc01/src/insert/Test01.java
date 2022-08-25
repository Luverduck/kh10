package insert;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Test01 {

	public static void main(String[] args) {
		
		// JDVC (Java DataBase Connectivity)
		
		// 목표 : khacademy 계정의 fifa 테이블에 데이터 insert 하기
		// 구문 : insert into fifa(rank, nartion, score) values(4, '아르헨티나', 1770.65);
		
		// 진행 순서
		// 1. 데이터베이스 로그인
		// 2. 구문 준비
		// 3. 구문 전송 및 실행
		// 4. 데이터베이스 로그아웃 (보통 생략)
		
		// 1. 데이터베이스 로그인
		// - 로그인을 도와주는 도구 생성 (Spring에 있는 도구 사용)
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		// - 드라이버 클래스 정보, 접속 정보, 계정 정보, 비밀번호 정보를 설정
		dataSource.setUsername("khacademy");
		dataSource.setPassword("khacademy");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
		
		// 2. 구문실행 도구 생성 (Spring에 있는 도구)
		JdbcTemplate template = new JdbcTemplate(dataSource);
		
		// 3. 구문 생성
		String sql = "insert into fifa(rank, nation, score) values(4, '아르헨티나', 1770.65)";
		
		// 3. 실행
		template.update(sql);
		
		System.out.println("완료!");
	}
}
