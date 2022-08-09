package oop.inherit6;

public class GalaxyFold3 extends Android {

	// 생성자 - Android 상속
	public GalaxyFold3(String number, String color) {
		super(number, color);
	}

	// GalaxyFord3 고유 메소드 - 홍채인식
	public void iris() {
		System.out.println("GalaxyFold3 홍채인식 기능 실행");		// 여기(하위 클래스)에서 재정의 (기종명 때문)
	}
	
	// 공용 메소드(재정의) - 전화, 통화, 삼성페이
	public void call() {
		System.out.println("GalaxyFold3 전화 기능 실행");			// 여기(하위 클래스)에서 재정의 (기종명 때문)
	}
		
	public void message() {
		System.out.println("GalaxyFold3 문자 기능 실행");			// 여기(하위 클래스)에서 재정의 (기종명 때문)
	}
		
	public void samsungPay() {
		System.out.println("GalaxyFold3 삼성페이 기능 실행"); 		// 여기(하위 클래스)에서 재정의 (기종명 때문)
	}
}
