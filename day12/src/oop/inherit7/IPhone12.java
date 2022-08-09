package oop.inherit7;

// 추상 클래스가 아님
// 실제 객체를 만드는 클래스
public class IPhone12 extends IPhone {	// 추상 메소드 call, sms에 대해서 정의해야한

	// 생성자
	public IPhone12(String name, String color) {
		super(name, color);
	}

	// 상속받은 추상(abstract) 메소드는 반드시 재정의를 해야 한다
	@Override	// annotation, 명찰 역할 (바로 아래 있는 대상의 역할을 정의)
	public void siri() {
		System.out.println("아이폰 12 음성인식 실행");
	}

	@Override
	public void call() {
		System.out.println("아이폰 12 전화 실행");
	}

	@Override
	public void sms() {
		System.out.println("아이폰 12 문자 실행");
	}

	// IPhone12 고유 메소드
	public void itunes() {
		System.out.println("아이폰12 아이튠즈 실행");
	}
}
