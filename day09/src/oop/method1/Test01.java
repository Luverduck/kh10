package oop.method1;

public class Test01 {

	public static void main(String[] args) {
		
		Student a = new Student();
		//a.name = "피카츄";
		//a.score = 90;
		a.setting("피카츄", 90);
		
		//System.out.println(a.name);		//모든 학생 객체에 존재해야 하는 코드
		//System.out.println(a.score);		//클래스로 옮겨서 method로 만들면 method이름으로 출력 가능
		
		a.print();		//a에서 print라는 method를 실행
		
		Student b = new Student();
		a.setting("파이리", 90);
		a.print();
		
	}
	
}
