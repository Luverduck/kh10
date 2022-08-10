package oop.poly1;

import java.util.Random;

public class Test03 {

	public static void main(String[] args) {
		
		// 랜덩으로 휴대폰 1개를 만들어서 통화 기능을 실행
		// [약속] 0 - 갤럭시 폴드 3 / 1 - 아이폰 13
		
		Random r = new Random();
		
		int choice = r.nextInt(2);
		
		// Phone phone = 갤럭시 객체 or 아이폰 객체4
		Phone phone;
		if(choice == 0) {
			phone = new GalaxyFold3();		// GalaxyFold3 	--> Phone으로 보관 (업 캐스팅 - 상위 자료형으로 보관하는 것)
		}
		else {
			phone = new IPhone13();			// IPhone13		--> Phone으로 보관 (업 캐스팅)
		}
		
		// Phone의 하위 클래스 중 하나를 랜덤으로 만들어서 보관하다가 call을 출력
		phone.call();
	}
}
