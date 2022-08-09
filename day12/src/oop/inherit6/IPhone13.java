package oop.inherit6;

public class IPhone13 extends IOS {

	// 생성자 - IOS 상속
	public IPhone13(String number, String color) {
		super(number, color);
	}
	
	// 고유 메소드 - 페이스타임
	public void facetime() {
		System.out.println("IPhone13 영상통화 기능 수행");
	}
	
	// IPhone12 고유 메소드 - 아이튠즈
	public void itunes() {
		System.out.println("IPhone13 아이튠즈 기능 실행");		// 여기(하위 클래스)에서 재정의 (기종명 때문)
	}
		
	// 공용 메소드(재정의) - 전화, 통화, 시리
	public void call() {
		System.out.println("IPhone13 전화 기능 실행");			// 여기(하위 클래스)에서 재정의 (기종명 때문)
	}
				
	public void message() {
		System.out.println("IPhone13 문자 기능 실행");			// 여기(하위 클래스)에서 재정의 (기종명 때문)
	}
				
	public void siri() {
		System.out.println("IPhone13 음성인식 기능 실행");		// 여기(하위 클래스)에서 재정의 (기종명 때문)
	}
}
