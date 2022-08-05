package oop.setter1;

public class Car {
	
	//field
	String name;
	int speed;
	int passenger;
	int price;
	
	//setter method
	//- 이름을 지을 때 'set 변수명'으로 작성, 변수명 첫글자는 무조건 대문자로
	//- if / switch 등을 이용하면 변수 입력에 대한 조건을 적용할 수 있음
	void setName(String name) {
		this.name = name;		
	}
	void setSpeed(int speed) {
		if(speed > 0) {	//입력받은 속도가 0보다 클 때만 입력이 되도록
			this.speed = speed;
		}
	}
	void setPassenger(int passenger) {
//		[1] passenger가 0 초과일때만 입력하세요
//		if(passenger > 0) {
//			this.passenger = passenger;
//		}
		
//		[2] passenger가 0 이하라면 설정하지 마세요
//		- return은 메소드를 종료하는 명령
		if(passenger <= 0) {	
			return;			//0 이하라면 구문 종료(return)
		}
	}
	void setPrice(int price) {
//		[1] 가격이 0 초과일때만 입력하세요
//		if(price > 0) {
//			this.price = price;
//		}
		
//		[2]
		if(price < 0) {
			return;
		}
	}
	
	//출력 메소드
	void print() {
		System.out.println("이름 : " + this.name);
		System.out.println("최고 속도 : " + this.speed);
		System.out.println("동승자수 : " + this.passenger);
		System.out.println("가격 : " + this.price);
	}
}
