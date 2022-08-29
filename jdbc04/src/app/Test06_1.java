package app;

import java.util.Scanner;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JdbcUtil;


public class Test06_1 {
	
	public static void main(String[] args) {
		
		//app.Test06 - 사용자가 원하는 번호에 해당하는 도서의 정보(이름, 출판사, 저자, 장르)를 변경
		// - 정보 중 일부만 변경하려고 하는 경우 EX) 해당 번호 도서의 이름만 변경

		//준비
		int bookSerial = 1;
		String bookName = "바꿀이름";
		String bookWriter = "바꿀저자";
		String bookPublisher = "바꿀출판사";
		String bookGenre = "바꿀장르";

		//처리
		JdbcTemplate template = JdbcUtil.getTemplate();
		
		String sql = "update book "
						+ "set "
							+ "book_name = ?, "
							+ "book_writer = ?, "
							+ "book_publisher = ?, "
							+ "book_genre = ? "
						+ "where book_serial = ?";
		
		Object[] param = {
				bookName, bookWriter, bookPublisher, bookGenre, bookSerial
		};
		
		int result = template.update(sql, param);
		
		if(result > 0) {
			System.out.println("정보 변경이 완료되었습니다");
		}
		
		else {
			System.out.println("존재하지 않는 도서번호입니다");
		}
	}
}

