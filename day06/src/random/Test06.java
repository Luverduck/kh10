package random;

//부루마블이라는 게임을 하다가 무인도에 갖혔습니다
//무인도에서 탈출하려면 주사위 두 개를 던져 5-5가 나오거나 6-6이 나와야 합니다
//무인도에서 탈출할 때까지 주사위를 던지고, 탈출하면 던진 주사위의 횟수가 출력되도록 구현하세요

import java.util.Random;

public class Test06 {
	
	public static void main(String[] args) {
		
		Random r = new Random();
		
		int count = 0;
		
		while(true) {
			
			//주사위 2개를 던진 결과 (반복해야 할 변수)
			int first = r.nextInt(6) + 1;
			int second = r.nextInt(6) + 1;
			
			count++;
			
			if((first == 5 && second == 5) || (first == 6 && second == 6)) {
				break;
			}
			
		}
		
		System.out.println("탈출 성공!");
		System.out.println("총 던진 주사위 횟수 : " + count);
		
	}

}
