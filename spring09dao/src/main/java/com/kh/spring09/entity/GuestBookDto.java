package com.kh.spring09.entity;

// DTO(Data Transfer Object) : 변환용 객체
public class GuestBookDto {

	// 필드
	private int no;
	private String name;
	private String memo;
	
	// 생성자
	public GuestBookDto() {
		super();
	}
	
	// getter & setter
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}

	// toString 오버리이딩
	@Override
	public String toString() {
		return "GuestBookDto [no=" + no + ", name=" + name + ", memo=" + memo + "]";
	}
}
