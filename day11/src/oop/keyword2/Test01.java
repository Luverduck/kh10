package oop.keyword2;

public class Test01 {

	public static void main(String[] args) {
		
		// 간단한 계산을 위해 메소드를 변경
		Calculator c = new Calculator();
		System.out.println(c.getAnswer(3, 5));
		System.out.println(c.getAnswer(4, 6));
	}
}
