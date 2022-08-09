package oop.inherit6;

public class Galaxy22s extends Android {

	// 생성자 - Android 상속
	public Galaxy22s(String number, String color) {
		super(number, color);
	}
	
	// Galaxy22s 고유 메소드 - 빅스비
	public void bixby() {
		System.out.println("Galaxy22s 음성인식 기능 실행");		// 여기(하위 클래스)에서 재정의 (기종명 때문)
	}
	
	// 공용 메소드(재정의) - 전화, 통화, 삼성페이
	public void call() {
		System.out.println("Galaxy22s 전화 기능 실행");		// 여기(하위 클래스)에서 재정의(기종명 때문)
	}
	
	public void message() {
		System.out.println("Galaxy22s 문자 기능 실행");		// 여기(하위 클래스)에서 재정의 (기종명 때문)
	}
	
	public void samsungPay() {
		System.out.println("Galaxy22s 삼성페이 기능 실행");		// 여기(하위 클래스)에서 재정의 (기종명 때문)
	}
	
}
