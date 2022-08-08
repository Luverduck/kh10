package oop.keyword1;

public class Calculator {

	// 멤버 필드
	private int left;	// 저장할 필요가 없는 일회용 정보
	private int right;
	
	// getter & setter
	public int getLeft() {		// 멤버 필드가 필요없으면 setter, getter도 필요가 없어진다
		return left;
	}
	public void setLeft(int left) {
		this.left = left;
	}
	public int getRight() {
		return right;
	}
	public void setRight(int right) {
		this.right = right;
	}
	
	// getter (정답)
	public int getAnswer() {
		return this.left * this.right;
	}
	
	public Calculator(int left, int right) {
		this.setLeft(left);
		this.setRight(right);
	}
}
