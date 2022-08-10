package oop.multi2_1;

// Generic type : 자료형을 미리 정해두지 않고 그때그때 정해서 사용
public class MultiBox <E> {	// <E> : 만들 때 인터페이스를 지정하지 않도록
	private E item;
	
	public void setItem(E item) {
		this.item = item;
	}
	public E getItem() {
		return this.item;
	}
}
