package app;

import java.util.Scanner;

import org.springframework.jdbc.core.JdbcTemplate;

import util.JdbcUtil;

public class Test08 {

	public static void main(String[] args) {
		
		// app.Test08 - 사용자가 원하는 번호에 해당하는 도서의 정보를 삭제
		
		// 1. template 불러오기
		JdbcTemplate template = JdbcUtil.getTemplate();
		
		// 2. SQL문 작성
		String sql = "delete book where book_serial = ?";
		
		// 3. 입력 및 배열 생성
		Scanner sc = new Scanner(System.in);
		System.out.print("삭제할 도서 번호 입력 : ");
		int bookSerial = sc.nextInt();
		sc.nextLine();
		
		Object[] param = new Object[] {bookSerial};
		
		// 4. 출력
		int result = template.update(sql, param);
		if(result > 0) {
			System.out.println("도서 정보 삭제 완료");
		}
		else {
			System.out.println("해당 번호의 도서가 없습니다");
		}
		
		sc.close();
	}
}
