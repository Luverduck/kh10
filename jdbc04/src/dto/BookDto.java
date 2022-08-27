package dto;

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
	private String creationTime;
	
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
	public String getCreationTime() {
		return creationTime;
	}
	public void setCreationTime(String creationTime) {
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
}