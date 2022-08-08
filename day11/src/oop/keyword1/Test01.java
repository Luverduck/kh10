package oop.keyword1;

public class Test01 {

	public static void main(String[] args) {
		
		// 간단한 계산에 객체 지향을 사용하는 것은 비효율적이다
		Calculator c = new Calculator(3, 5);
		System.out.println(c.getAnswer());
	}
}
