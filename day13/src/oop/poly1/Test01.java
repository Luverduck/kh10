package oop.poly1;

public class Test01 {

	public static void main(String[] args) {
		
		// 정적 객체 생성
		GalaxyFold3 a = new GalaxyFold3();
		// a.samsungPay();
		a.call();		// 참조 변수 a가 GalaxyFold3의 call(); 메소드를 출력
	
		// 동적 객체 생성 - 상위클래스에 보관
		Phone b = new GalaxyFold3();
		// b.samsungPay();
		b.call();		//
		
		Phone c = new IPhone13();
		c.call();
		
		// 다형성의 조건
		// 1) 상속
		// 2) 메소드 재정의
	}
}
