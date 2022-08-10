package oop.multi1;

// 슈퍼클래스와 동시에 상속시 슈퍼클래스 상속의 위치가 더 앞임
// extends 슈퍼클래스 implements 인터페이스1, 인터페이스2, ...

public class Kim implements Singer, Magician {	// 인터페이스를 상속받기 위한 implements
										// 여러 인터페이스 상속시 implements 인터페이스1, 인터페이스 2, ...
	@Override
	public void sing() {
		System.out.println("죽을만큼 보고싶다~");
	}

	@Override
	public void show() {
		System.out.println("나와라 비둘기~");	
	}
}
