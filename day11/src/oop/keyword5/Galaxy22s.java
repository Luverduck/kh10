package oop.keyword5;

public class Galaxy22s {

	// 멤버 필드
	private String company;		// 제조사
	private String color;		// 색상
	private String number;		// 전화번호
	private int memory;			// 저장공간 용량
	
	// getter & setter
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public int getMemory() {
		return memory;
	}
	public void setMemory(int memory) {
		this.memory = memory;
	}
	
	// 생성자
	public Galaxy22s(String color, String number, int memory) {
		this.company = "삼성";
		this.color = color;
		this.number = number;
		this.memory = memory;
	}
	
	// 출력
	public void print() {
		System.out.println(this.company);
		System.out.println(this.color);
		System.out.println(this.number);
		System.out.println(this.memory);
		System.out.println();
	}
}
