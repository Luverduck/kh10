package update;

import java.util.Scanner;

import org.springframework.jdbc.core.JdbcTemplate;

import util.JdbcUtil;

public class Test02 {

	public static void main(String[] args) {
		
		// guest_book 테이블의 번호를 수정하도록 프로그램을 구현
		// - 번호를 이용하여 작성자와 메모를 수정
		
		// 입력
		Scanner sc = new Scanner(System.in);
		System.out.print("변경할 글의 번호 : ");
		int no = sc.nextInt();
		sc.nextLine();
		System.out.print("작성자명 변경 : ");
		String name = sc.nextLine();
		System.out.print("메모 변경 : ");
		String memo = sc.nextLine();
		
		JdbcTemplate template = JdbcUtil.getTemplate();
		
		String sql = "update guest_book set name = ?, memo = ? where no = ?";
		
		Object[] param = new Object[] {name, memo, no};
		
		int result = template.update(sql, param);
		
		if(result > 0) {
			System.out.println(result + "개 데이터 변경 성공");
		}
		else {
			System.out.println("존재하지 않는 번호입니다");
		}
		
		sc.close();
	}
}
