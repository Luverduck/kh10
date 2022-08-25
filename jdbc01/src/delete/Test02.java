package delete;

import java.util.Scanner;

import org.springframework.jdbc.core.JdbcTemplate;

import util.JdbcUtil;

public class Test02 {
	
	public static void main(String[] args) {

		// guest_book 테이블의 데이터를 삭제하는 프로그램
		// - primary key인 번호(no)를 이용하여 삭제하도록 구현
		
		// 입력
		Scanner sc = new Scanner(System.in);
		System.out.print("번호 입력 :");
		int no = sc.nextInt();
		sc.nextLine();
		
		// 입력 배열
		Object[] param = new Object[] {no};
		
		// 방명록(guest_book)의 데이터 삭제
		JdbcTemplate template = JdbcUtil.getTemplate();
		
		// SQL문 작성
		String sql = "delete guest_book where no = ?";
		
		// 처리
		int result = template.update(sql, param);
		
		if(result > 0) {
			System.out.println(result + "개 방명록 삭제 완료");
		}
		else {
			System.out.println("존재하지 않는 방명록 번호입니다");
		}
		
		sc.close();
	}
}
