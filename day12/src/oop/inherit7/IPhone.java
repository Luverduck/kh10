package oop.inherit7;

// 추상 클래스 (아직까지는 상위 분류)
public abstract class IPhone extends Phone {

	// 생성자 - Phone 상속
	public IPhone(String name, String color) {
		super(name, color);
	}

	// 추상 메소드 - 시리
	public abstract void siri();
}
