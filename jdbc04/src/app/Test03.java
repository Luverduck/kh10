package app;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import dto.BookDto;
import util.JdbcUtil;

public class Test03 {

	public static void main(String[] args) {
		
		// app.Test03 - 사용자가 입력한 검색어에 해당하는 장르의 도서를 출력
		
		// 1. template 불러오기
		JdbcTemplate template = JdbcUtil.getTemplate();
		
		// 2. SQL문 작성
		String sql = "select * from book where book_genre like '%'||?||'%'";
		
		// 3. 입력 및 배열
		Scanner sc = new Scanner(System.in);
		System.out.print("검색어 입력 : ");
		String keyword = sc.nextLine();
		
		Object[] param = new Object[] {keyword};
		
		// 4. RowMapper 생성
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
		
		// 5. List 생성
		List<BookDto> list = template.query(sql, mapper, param);
		
		// 6. 출력
		for(BookDto bookDto : list) {
			System.out.println(bookDto);
		}
		
		sc.close();
	}
}
