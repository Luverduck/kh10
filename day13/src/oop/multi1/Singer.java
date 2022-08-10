package oop.multi1;

// interface 
// - 다중 상속 전용 클래스
// - 다중 상속에서 문제가 발생할 수 있는 요소를 모두 제거한 클래스

// - super 클래스와의 모호성을 제거하기 위해 필드와 생성자 생성을 금지하지만 '추상 메소드'는 가능

public interface Singer {
	
	// 필드 - 변수 생성 금지, 상수(public static final)만 가능
	public static final int a = 6;
	//private double pi = 3.14;		->	only public, static & final are permitted
	
	// 생성자 : 생성자의 목적은 필드를 초기화하기 위함이지만 필드를 만들 수 없으므로 생성 절대 금지
	
	// 추상 메소드(만 가능, 식별자를 default로 하면 억지로 메소드를 만들 수는 있음) (public abstract를 자동으로 생성하므로 식별자와 abstract를 쓸 필요가 없다
	/*public abstract*/ void sing();
	
}
