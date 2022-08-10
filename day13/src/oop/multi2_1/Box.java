package oop.multi2_1;

public class Box {

	// private Bus item;				// 버스를 1개 저장할 수 있는 변수 공간을 만들겠다
	// private Electronic item;			// 전자제품 중 하나를 저장할 수 있는 공간을 만들겠다 (드론, 킥보드)
	// private Reserve item;			// 예약가능한 제품을 한 개 저장할 수 있는 자리를 만들겠다
	private Transportation item;		// 교통수단 중 하나를 저장할 수 있는 자리를 만들겠다
	public void setItem(Transportation item) {
		this.item = item;
	}
	public Transportation getItem() {
		return this.item;
	}
	
	// 인터페이스를 만들어 놓으면 이런게 가능
}
