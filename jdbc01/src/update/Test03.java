package update;

import java.util.Scanner;

import org.springframework.jdbc.core.JdbcTemplate;

import util.JdbcUtil;

public class Test03 {

	public static void main(String[] args) {
		
		// customer 테이블의 정보를 수정하도록 프로그램을 구현
		// - 번호를 입력받아 해당 회원에게 원하는 만큼의 포인트를 증정
		
		// 입력
		Scanner sc = new Scanner(System.in);
		System.out.print("회원 번호 : ");
		int customer_num = sc.nextInt();
		sc.nextLine();
		System.out.print("부여할 포인트 : ");
		int customer_point = sc.nextInt();
		sc.nextLine();
		
		// template 불러오기
		JdbcTemplate template = JdbcUtil.getTemplate();	
		
		// SQL문 작성
		String sql = "update customer set customer_point = customer_point + ? where customer_num = ?";
		
		// 입력 배열
		Object[] param = new Object[] {customer_point, customer_num};
		
		// update(sql, param)을 진행한 결과를 반환 (성공시 0보다 큰 숫자 반환)
		int result = template.update(sql, param);
		
		// 결과 확인을 위해 출력을 바꿈
		if(result > 0) {
			System.out.println(result + "개 데이터 변경 성공");
		}
		else {
			System.out.println("존재하지 않는 번호입니다");
		}
		
		sc.close();
	}
}
