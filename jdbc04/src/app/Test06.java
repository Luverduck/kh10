package app;

import java.util.Scanner;

import org.springframework.jdbc.core.JdbcTemplate;

import util.JdbcUtil;

public class Test06 {

	public static void main(String[] args) {
		
		// app.Test06 - 사용자가 원하는 번호에 해당하는 도서의 정보(이름, 출판사, 저자, 장르)를 변경
		
		// 1. template 불러오기
		JdbcTemplate template = JdbcUtil.getTemplate();
		
		// 2. SQL문 작성
		String sql = "update book set book_name = ?, book_writer = ?, book_publisher = ?, book_genre = ? where book_serial = ?;";
		
		// 3. 입력 및 배열 생성
		Scanner sc = new Scanner(System.in);
		System.out.print("정보를 변경할 도서 번호 입력 : ");
		int bookSerial = sc.nextInt();
		sc.nextLine();
		System.out.print("변경(도서명) : ");
		String bookName = sc.nextLine();
		System.out.print("변경(저자명) : ");
		String bookWriter = sc.nextLine();
		System.out.print("변경(출판사) : ");
		String bookPublisher = sc.nextLine();
		System.out.print("변경(장르) : ");
		String bookGenre = sc.nextLine();
		
		Object[] param = new Object[] {bookName, bookWriter, bookPublisher, bookGenre, bookSerial};
		
		// 4. 출력
		int result = template.update(sql, param);
		if(result > 0) {
			System.out.println("도서 정보가 변경되었습니다");
		}
		else {
			System.out.println("해당 번호의 도서가 없습니다");
		}
		
		sc.close();
	}
}
