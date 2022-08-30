package com.kh.spring09.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

public class BookDto {

	// 필드
	int bookSerial;
	String bookName;
	String bookWriter;
	String bookPublisher;
	int bookPrice;
	String bookGenre;
	String creationTime;
	
	// 생성자
	public BookDto() {
		super();
	}
	
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
	public int getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(int bookPrice) {
		this.bookPrice = bookPrice;
	}
	public String getBookGenre() {
		return bookGenre;
	}
	public void setBookGenre(String bookGenre) {
		this.bookGenre = bookGenre;
	}
	public String getCreationTime() {
		return creationTime;
	}
	public void setCreationTime(String creationTime) {
		this.creationTime = creationTime;
	}
	
	// toString 오버라이딩
	@Override
	public String toString() {
		return "BookDto [bookSerial=" + bookSerial + ", bookName=" + bookName + ", bookWriter=" + bookWriter
				+ ", bookPublisher=" + bookPublisher + ", bookPrice=" + bookPrice + ", bookGenre=" + bookGenre
				+ ", creationTime=" + creationTime + "]";
	}
	
	// RowMapper
	public static RowMapper<BookDto> mapper = new RowMapper<BookDto>() {
		@Override
		public BookDto mapRow(ResultSet rs, int idx) throws SQLException {
			BookDto bookDto = new BookDto();
			bookDto.setBookSerial(rs.getInt("book_serial"));
			bookDto.setBookName(rs.getString("book_name"));
			bookDto.setBookWriter(rs.getString("book_writer"));
			bookDto.setBookPublisher(rs.getString("book_publisher"));
			bookDto.setBookPrice(rs.getInt("book_price"));
			bookDto.setBookGenre(rs.getString("book_genre"));
			bookDto.setCreationTime(rs.getString("creation_time"));
			return bookDto;
		}
	};
	
	public static RowMapper<BookDto> getMapper(){
		return mapper;
	}
	
	// ResultSetExtractor
	public static ResultSetExtractor<BookDto> extractor = new ResultSetExtractor<BookDto>() {
		@Override
		public BookDto extractData(ResultSet rs) throws SQLException, DataAccessException {
			if(rs.next()) {
				BookDto bookDto = new BookDto();
				bookDto.setBookSerial(rs.getInt("book_serial"));
				bookDto.setBookName(rs.getString("book_name"));
				bookDto.setBookWriter(rs.getString("book_writer"));
				bookDto.setBookPublisher(rs.getString("book_publisher"));
				bookDto.setBookPrice(rs.getInt("book_price"));
				bookDto.setBookGenre(rs.getString("book_genre"));
				bookDto.setCreationTime(rs.getString("creation_time"));
				return bookDto;
			}
			else {
				return null;
			}
		}
	};
	
	public static ResultSetExtractor<BookDto> getExtractor() {
		return extractor;
	}
}
