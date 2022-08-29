package dto;

import java.sql.Date;	// sql.date는 DB 연동을 위한
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class BookDto {

	// 필드
	private int bookSerial;
	private String bookName;
	private String bookWriter;
	private String bookPublisher;
	private long bookPrice;
	private String bookGenre;
	private Date creationTime;
	
	// getter & setter
	public int getBookSerial() {
		return bookSerial;
	}

	public void setBookSerial(int bookSerial) {
		this.bookSerial = bookSerial;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookWriter() {
		return bookWriter;
	}

	public void setBookWriter(String bookWriter) {
		this.bookWriter = bookWriter;
	}

	public String getBookPublisher() {
		return bookPublisher;
	}

	public void setBookPublisher(String bookPublisher) {
		this.bookPublisher = bookPublisher;
	}

	public long getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(long bookPrice) {
		this.bookPrice = bookPrice;
	}

	public String getBookGenre() {
		return bookGenre;
	}

	public void setBookGenre(String bookGenre) {
		this.bookGenre = bookGenre;
	}

	public Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}
	
	// 생성자
	public BookDto() {
		super();
	}

	// toString 오버라이딩
	@Override
	public String toString() {
		return "BookDto [bookSerial=" + bookSerial + ", bookName=" + bookName + ", bookWriter=" + bookWriter
				+ ", bookPublisher=" + bookPublisher + ", bookPrice=" + bookPrice + ", bookGenre=" + bookGenre
				+ ", creationTime=" + creationTime + "]";
	}
	
	// RowMapper를 DTO에 미리 넣어놓기
	private static RowMapper<BookDto> mapper = new RowMapper<BookDto>() {
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
	
	public static RowMapper<BookDto> getMapper(){
		return mapper;
	}
}
