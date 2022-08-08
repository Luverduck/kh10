package oop.keyword10;

import java.util.Random;

public class Test02 {
	
	// 외부에서 호출할 수 있도록 필드로 선언한다
	// [약속] 0 : 앞, 1 : 뒤
	public static final int FRONT = 0, BACK = 1;	// 변수명은 대문자로 한다 (약속)
	// - 외부에서 부르기 위해 접근 제한 public으로 설정
	// - 객체 없이 편하게 부르기 위해 static 처리 (static 을 붙여야 아래 static main에 부를 수 있음)
	// - 데이터의 변경 없으니 안전하게 쓰라고 final 처리
	// - Test03.FRONT 또는 Test03.BACK 으로 호출
	
	// - public static final ~ 는 상수라 부른다

	public static void main(String[] args) {		// 메소드 안에서 만든 변수는 메소드 밖에서 사용할 수 없다
													// 메소드가 실행됬을 때만 사용할 수 있는 것이기 때문
		// 값을 미리 정해둔다!
		// [약속] (0 : 앞, 1 : 뒤)
		// final int front = 0, back = 1;	// final 붙임
		
		// 동전 던지기
		Random r = new Random();
		int coin = r.nextInt(2);		// 0부터 2개 (0일 때 앞 / 1일 때 뒤) - 주석이 없다면 이해하기가 어렵다
		if(coin == FRONT) {
			System.out.println("앞");
		}
		else {
			System.out.println("뒤");
		}
		
		
	}
}
