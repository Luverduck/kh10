package oop.modifier1;

public class Test01 {

	public static void main(String[] args) {
		
		Student a = new Student("홍길동", 50);
		
		//a.score = 50;			//접근 불가 - 변수에 직접 접근하는 것을 막음
		a.setScore(-60);		//접근 가능
		
		a.print();
	}
	
}
