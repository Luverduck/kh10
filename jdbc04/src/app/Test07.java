package app;

import java.util.Scanner;

import org.springframework.jdbc.core.JdbcTemplate;

import util.JdbcUtil;

public class Test07 {

	public static void main(String[] args) {
		
		// app.Test07 - 사용자가 원하는 번호에 해당하는 도서의 판매가를 변경
		
		// 1. template 불러오기
		JdbcTemplate template = JdbcUtil.getTemplate();
		
		// 2. SQL묹 작성
		String sql = "update book set book_price = ? where book_serial = ?";
		
		// 3. 입력 및 배열 생성
		Scanner sc = new Scanner(System.in);
		System.out.print("변경할 도서의 번호 : ");
		int bookSerial = sc.nextInt();
		sc.nextLine();
		System.out.print("변경값(가격) : ");
		long bookPrice = sc.nextLong();
		sc.nextLine();
		
		Object[] param = new Object[] {bookPrice, bookSerial};
		
		// 4. 출력
		int result = template.update(sql, param);
		if(result > 0) {
			System.out.println("도서 가격 변경 완료");
		}
		else {
			System.out.println("해당 번호의 도서가 없습니다");
		}
		
		sc.close();
	}
}
