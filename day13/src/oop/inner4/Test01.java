package oop.inner4;

public class Test01 {

	public static void main(String[] args) {
		
		// 인터페이스 역시 클래스를 만들 순 없다 - 추상 메소드 때문
		Button bt = new Button() {
			@Override
			public void push() {		// 익명 중첩 클래스로 추상 메소드를 해결해준다면 1회용 객체 생성 가능 (중요)
				System.out.println("버튼 클릭");
			}
		};
		bt.push();
		
		// 자바 1.8(Java 8)부터는 함수형 인터페이스, 추론라는 개념이 생긴다
		// - 함수형 인터페이스는 메소드가 하나뿐인 인터페이스를 말한다
		// - 어차피 익명 중첩 클래스로 객체를 만들거고 메소드가 하나라면 굳이 다 쳐야하는가?
		// - 메소드가 하나뿐인 함수형 인터페이스에 대해서 추론식 사용 가능 (코드를 줄일 수 있다)
		
		// 추론 범위
		Button exit = /*new Button() {
			public void push*/()-> {
			System.out.println("종료 버튼 클릭");
		};
		
		// 결론적으로 이렇게 완성된 문법 체계를 람다(Lamda)라고 한다
		Button exit1 = ()-> {
			System.out.println("종료 버튼 클릭");
		};
		exit1.push();
	}
}
