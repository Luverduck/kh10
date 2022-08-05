package oop.constructor2;

public class Test01 {
	
	public static void main(String[] args) {
		
		Player a = new Player("마리오", "전사", 50);
		
		Player b = new Player("루이지", "마법사");		//생성자에서 레벨을 입력하지 않으면 1이 되도록 설정했음
		
		Player c = new Player("피오나", "마법사");
		
		
		//b의 레벨이 올랐다고 할 때
		//b.level++; 	//객체지향에서 비추천	//클래스에서 수정하 것
		b.levelUP();	//추천				//클래서에서 레벨업 메소드를 출력
		
		a.print();
		b.print();
		c.print();
		
	}

}
