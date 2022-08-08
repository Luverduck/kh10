package oop.keyword8;

// 목표 : 한 번 정해지면 절대로 크기가 변하지 않는 창(window) 만들기

public class Window {

	// 객체가 생성되면 값이 무조건 들어가므로 final 항목의 오류가 발생한다
	//private final int width;			// 이대로 쓰면 width, height에 0이 들어간다는 경고
	//private final int height;
	
	// 해결책
	// 1. 필드에 값을 직접 대입한다
	//private final int width = 640;		// 화면 크기를 640 * 480으로 고정	
	//private final int height = 480;
	
	// 2. 모든 생성자에서 값을 초기화한다
	private final int width;
	private final int height;
	public Window(int width, int height) {	// 생성자에서 값을 초기화
		this.width = width;
		this.height = height;
	}
	
	// (주의) final 필드는 절대로 setter 메소드를 만들 수 없다 (setter는 값을 바꾸는 메소드)
	//public void setWidth(int Width) {
	//	this.width = width;
	//}
	
	
}
