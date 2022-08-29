package app;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import dto.BookDto;
import util.JdbcUtil;

public class Test05 {

	public static void main(String[] args) {
		
		// app.Test05 - 사용자가 입력한 번호에 해당하는 도서의 정보를 출력 -> 단일 조회
		
		// 1. template 불러오기
		JdbcTemplate template = JdbcUtil.getTemplate();
		
		// 2. SQL문 작성
		String sql = "select * from book where book_serial = ?";
		
		// 3. 입력 및 배열
		Scanner sc = new Scanner(System.in);
		System.out.print("도서 번호 입력 : ");
		int bookSerial = sc.nextInt();
		sc.nextLine();
		
		Object[] param = new Object[] {bookSerial};
		
		// 4. RowMapper 생성
		/*
		RowMapper<BookDto> mapper = new RowMapper<BookDto>() {
			@Override
			public BookDto mapRow(ResultSet rs, int idx) throws SQLException {
				BookDto bookDto = new BookDto();
				bookDto.setBookSerial(rs.getInt("book_serial"));
				bookDto.setBookName(rs.getString("book_name"));
				bookDto.setBookWriter(rs.getString("book_writer"));
				bookDto.setBookPublisher(rs.getString("book_publisher"));
				bookDto.setBookPrice(rs.getLong("book_price"));
				bookDto.setBookGenre(rs.getString("book_genre"));
				bookDto.setCreationTime(rs.getDate("creation_time"));
				return bookDto;
			}
		};
		*/
		
		// 5. List 생성 - 단일 조회에서는 List를 생성하지 않음
		
		// 5. BookDto의 인스턴스 생성
		BookDto bookDto = template.query(sql, BookDto.getExtractor(), param);
		
		// 6. 출력
		if(bookDto == null) {
			System.out.println("존재하지 않는 도서 번호");
		}
		else {
			System.out.println(bookSerial + "번 도서 정보");
			System.out.println(bookSerial);
		}
		
		sc.close();
	}
}
