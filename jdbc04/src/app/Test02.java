package app;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import dto.BookDto;
import util.JdbcUtil;

public class Test02 {

	public static void main(String[] args) {
		
		// app.Test02 - 사용자에게 등록된 모든 도서 목록을 출력
		
		// 1. template 불러오기
		JdbcTemplate template = JdbcUtil.getTemplate();
		
		// 2. SQL문 작성
		String sql = "select * from book order by book_serial asc";
		
		// 3. 입력 및 배열 - 입력이 필요없으므로 생략
		
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
		
		
		// 5. List 생성 및 메핑
		//List<BookDto> list = template.query(sql, mapper);
		
		// ** BookDto에 있는 Mapper를 불러오기
		List<BookDto> list = template.query(sql, BookDto.getMapper());
		
		// 6. 출력
		for(BookDto bookDto : list) {
			System.out.println(bookDto);
		}
	}
}
