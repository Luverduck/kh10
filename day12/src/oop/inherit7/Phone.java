package oop.inherit7;

// 추상 클래스(abstract class)
// - 직접 객체를 만들지는 않으며 오직 상속을 위한 상위 클래스
// - 추상 메소드를 가진다
// - abstract가 붙는다
public abstract class Phone {

	// 필드
	protected String name, color;

	// 생성자
	public Phone(String name, String color) {
		this.name = name;
		this.color = color;
	}
	
	// 추상 메소드
	public abstract void call();	// call()이라는 기능이 있어야 하지만 아직 내용은 모름 
	public abstract void sms();		// sms()이라는 기능이 있어야 하지만 아직 내용은 모름 
	
}
