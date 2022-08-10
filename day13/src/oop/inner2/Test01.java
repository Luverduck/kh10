package oop.inner2;

public class Test01 {

	public static void main(String[] args) {
		
		Button bt1 = new Button();
		bt1.push();
		
		// 익명 중첩 클래스 (anonymous nested class)
		// - 객체를 만들면서 즉석에서 클래스를 구성하여 특정 기능을 재정의한다
		// - 1회용 상속 효과 발생
		
		// 버튼의 push를 메뉴 버튼을 클릭하는 것으로 바꿀 때
		Button menu = new Button() {
			@Override	// 1회용으로 Button의 push 메소드를 상속받음 (1회용 상속 구현)
			public void push() {
				System.out.println("메뉴 버튼 클릭");
			}
		};
		menu.push();
		
		// 버튼의 push를 종료 버튼을 클릭하는 것으로 바꿀 때
		Button exit = new Button() {
			@Override
			public void push() {
				System.out.println("종료 버튼 클릭");
			}
		};
		exit.push();
	}
}
