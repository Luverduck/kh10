package app;

import java.util.Scanner;

import org.springframework.jdbc.core.JdbcTemplate;

import util.JdbcUtil;

public class Test01 {

	public static void main(String[] args) {
		
		// app.Test01 - 사용자에게 필요한 정보를 입력받아 도서를 등록
		
		// 1. template 불러오기
		JdbcTemplate template = JdbcUtil.getTemplate();
		
		// 2. SQL문 작성
		String sql = "insert into book(book_serial, book_name, book_writer, book_publisher, book_price, book_genre, creation_time) values(book_seq.nextval, ?, ?, ?, ?, ?, sysdate)";
		
		// 3. 입력 및 배열 생성
		Scanner sc = new Scanner(System.in);
		System.out.print("도서명 : ");
		String bookName = sc.nextLine();
		System.out.print("작가 : ");
		String bookWriter = sc.nextLine();
		System.out.print("출판사 : ");
		String bookPublisher = sc.nextLine();
		System.out.print("가격 : ");
		long bookPrice = sc.nextLong();
		sc.nextLine();
		System.out.print("장르 : ");
		String bookGenre = sc.nextLine();
		
		Object[] param = new Object[] {bookName, bookWriter, bookPublisher, bookPrice, bookGenre};
		
		// 4. 실행
		int result = template.update(sql, param);
		if(result > 0) {
			System.out.println("도서를 등록했습니다");
		}
		else {
			System.out.println("올바른 도서 정보를 입력해주세요");
		}
		
		sc.close();
	}
}
