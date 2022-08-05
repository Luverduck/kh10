package oop.constructor1;

public class Test01 {
	
	public static void main(String[] args) {
		
		Student a = new Student("피카츄", 50);	// () 속에는 메소드 입력하는 칸
//		a.setting("피카츄", 50);		//이름이나 점수를 설정하지 않으면 안되도록
		a.print();
		
		
	}

}
