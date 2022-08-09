package oop.inherit4;

// 상위 클래스의 필드, 메소드, 생성자 구현시 주의해야 할 점
public class Phone {

	// 필드 - 접근제한
	// - 접근제한을 private로 설정하면 자식 클래스에서도 접근이 불가능하다
	// - 접근제한을 protected로 설정하면 자식 클래스에서도 접근 가능
	protected String number;
	
	// 접근 제한이 약한 순서
	// public 		
	// protected	
	// package		
	// private		
	
	// 메소드 - 재정의(Override) 여부		// Overloading과 Override 비교?
	// - 메소드에 final 키워드를 붙이면 재정의가 앞으로 영원히 불가능
	// public final void test() {	// 재정의를 금지하기 위한 final
	public void test() {
		System.out.println("테스트");
	}
	
	// 메소드 재정의를 허락/거절할 수 있다
	// 상위 클래스를 만들 때 재정의 여부를 지정할 수 있다
	
	// ** 상위클래스 생성시
	// 필드는 접근제한 유무를 고려할 것
	// 메소드는 재정의 여부를 고려할 것
	// ** 생성자는 필수항목에 대한 처리를 고려할 것
	
	// 생성자 - 반드시 설정해야 할 필수값을 지정 -> 상속받는 클래스에 제약이 생김
	public Phone(String number) {
		this.number = number;
	}
	// 자식 클래스 IPhone14에 number를 반드시 고려해야 한다
}
