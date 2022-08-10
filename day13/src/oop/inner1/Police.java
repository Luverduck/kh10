package oop.inner1;

public class Police {

	// 필드, 메소드, 생성자
	
	// 중첩 클래스 (nested class)
	// - 클래스 간의 소유 관계를 표현 (경찰이 권총을 소유한다 = 경찰만 권총을 소유할 수 있다)
	// - 클래스 내부에서 사용할 객체 설계
	
	private Gun gun;
	
	public Police() {
		this.gun = new Gun;		// 경찰 객체 생성시 gun을 갖도록
	}
	
	private static class Gun {	
		// 필드, 메소드, 생성자
		
	}
	
	// 종류
	// - 일반 중첩 클래스 (* 중요)
	// - static 중첩 클래스
	// - 지역 중첩 클래스 (X)
	// - 익명 중첩 클래스 (*********** 중요)
	
	// 1) private class Gun{} : 일반 중첩 클래스
	// 2) private static class Gun{} : static 중첩 클래스
	
	/* 3) 
	public void print() {
		class Gun{}			: 지역 중첩 클래스 - 메소드 내부에서만 사용 가능 (잘 사용하지 않는다)
	}
	*/
	
}
