package oop.keyword3;

public class Test01 {

	public static void main(String[] args) {
		
		// 간단한 계산을 위해 메소드를 변경
		// Calculator c = new Calculator(); 객체를 만들 필요가 없다
		
		// static 메소드는 아무데서나 클래스명만 알면 객체 없이 사용이 가능하다
		System.out.println(Calculator.getAnswer(3, 5));
		System.out.println(Calculator.getAnswer(4, 6));
	}
}
