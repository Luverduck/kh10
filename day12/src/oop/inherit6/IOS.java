package oop.inherit6;

public class IOS extends Phone {

	// 생성자
	public IOS(String number, String color) {
		super(number, color);
	}

	// IOS 고유 메소드 - 시리
	public void siri() {
		System.out.println("음성인식 기능 실행");	// 가장 하위 클래스에서 재정의할 예정 (기종명 때문)
	}
}
