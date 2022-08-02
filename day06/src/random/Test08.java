package random;

import java.util.Random;

public class Test08 {

	public static void main(String[] args) {
		
		//확률 구현하기
		//- 랜덤은 범위 내의 값이 동일한 확률로 나온다 
		//  (0과 10 사이가 나오도록 할 경우 1이 나올 경우와 2가 나올 경우 각각에 대한 가중치가 없음)
		//- 일정 개수의 숫자 범위 내에서 원하는 개수를 지정하여 검사
		//ex) 100개의 숫자 중 2개를 정하면 2%
		
		Random r = new Random();
		
		//5% 확률 구현
		//1부터 100까지 각각의 숫자가 나올 확률은 1%로 같다
		//5 이하가 되는 경우는 1 or 2 or 3 or 4 or 5이므로 'range < 5'는 5%를 의미하게 된다 
		int range = r.nextInt(100) + 1;
		System.out.println("range = " + range);
		
		if(range <= 5) {
			System.out.println("당첨");
		}
		else {
			System.out.println("꽝");
		}
		
	}
}
