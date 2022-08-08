package oop.keyword4;

public class Test01 {

	public static void main(String[] args) {	// - main 메소드 <- 외부의 JVM(자바 가상 머신)이 호출 
												// - public : 접근 제한을 public으로 해야 외부에서 호출 가능
												// - static : main 메소드는 객체 없이도 호출 가능하도록 한다
												// - void : main 메소드 실행이 완료된 후 반환하는 값
												// - String[] : 다른 프로그램에서 나온 문자열 여러 개를 전달받을 수 있다 (프로그램간의 연계)
												// - args : arguments
		// 1. 11의 제곱
		System.out.println(Robot.square(11));
		
		// 2. 신장 180cm, 체중 80kg인 사람의 BMI 계산
		System.out.println(Robot.bmi(80, 180));
		
		// 3. 1999년생의 지하철 요금
		System.out.println(Robot.price(1999));
		
		// 4. 밑변 5, 높이 7인 삼각형의 넓이
		System.out.println(Robot.triangle(5, 7));
		
		// 5. 반지름 7인 원의 넓이
		System.out.println(Robot.circle(7));
	}
}
