package oop.setter1;

public class Test01 {

	public static void main(String[] args) {
		
		Car a = new Car("아반떼", 200, -4, 2000000);
		
		//(문제점) 변수는 이상데이터 방지가 불가능 (ex 음수값)
		//a.name = "아반떼";
		//a.speed = 200;
		//a.passenger = 4;
		//a.price = 15000000;
		
		//(해결책) 메소드는 필터링 가능 - 세터(setter) 메소드
		//a.setName("아반떼");
		//a.setSpeed(200);
		//a.setPassenger(4);
		//a.setPrice(-2000000);
		
		a.print();
	}
}
