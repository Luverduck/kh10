package oop.inherit6;

public class Android extends Phone {

	// 생성자
	public Android(String number, String color) {
		super(number, color);
	}

	// Android 고유 메소드 - 삼성페이
	public void samsungPay() {
		System.out.println("????의 삼성페이 기능 실행");		// 가장 하위 클래스에서 재정의할 예정 (기종명 때문)
	}
	
}
