package oop.inherit4;

public class IPhone14 extends Phone {

	public void print() {
		
		// 상위 클래스에서 number 필드의 접근 제한을 private로 하면 하위 클래스에서 사용할 수 없다
		System.out.println("번호 : " + number);	
		System.out.println("번호 : " + this.number);		// this : 현재 클래스를 지칭, 여기서는 자식 클래스인 IPhone14
		System.out.println("번호 : " + super.number);	// super : 부모 클래스를 지칭
	}
		
	// 만약 이미 자식 클래스에 test() 클래스가 있다면 어떻게 동작? -> 자식 클래스의 test()가 동작
		
	// Phone의 test 메소드를 재정의(Override)
	// - 재정의는 원본과 동일하게 구현
	// - 재정의가 가능하다는 것은 원한다면 내용을 고쳐서 사용할 수도 있다는 뜻
	public void test() {
		System.out.println("재정의한 테스트");
	}
	
	// 재정의를 허락/거절할 수도 있음
	
	
	// 부모 클래스에 생성자가 있다면 
	// 자식 클래스는 반드시 해당 생성자를 고려하여 생성자를 구현해야 한다
	public IPhone14(String number) {
		super(number);		// 부모 클래스의 생성자로 number를 전달
	}
}
