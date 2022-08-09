package oop.inherit6;

public class Phone {

	// 공용 필드 - 기종명, 전화번호, 색상
	protected String number;
	protected String color;
	
	// getter & setter
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	// 생성자 - 전화번호는 반드시 입력
	public Phone(String number, String color){
		this.number = number;
		this.color = color;
	}

	// 공용 메소드 - 전화, 문자
	public void call() {	
		System.out.println("????의 전화 기능 실행");	// 가장 하위 클래스에서 재정의할 예정 (기종명 때문)
	}
	
	public void message() {
		System.out.println("????의 문자 기능 실행");	// 가장 하위 클래스에서 재정의할 예정 (기종명 때문)
	}
}
