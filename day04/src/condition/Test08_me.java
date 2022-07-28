package condition;

import java.lang.*;

public class Test08_me {
	public static void main(String[] args) {
		//다중 조건
		//(Q) 월이 주어져 있을 때 계절을 구하여 출력
		//-봄 : 3, 4, 5
		//-여름 : 6, 7, 8
		//-가을 : 9, 10, 11
		//-겨울 : 12, 1, 2
		
		//나눗셈 결과 몫이 같은 집합을 모아서 처리하는 방법으로 계산하면 되지 않을까?
		//몫이 다른 달 수가 포함된 겨울은 else로 처리
		
		int month = 8;
		
		if(month / 3 == 1) {
			System.out.println("봄");
		}
		
		else if(month / 3 == 2) {
			System.out.println("여름");
		}
		
		else if(month / 3 == 3) {
			System.out.println("가을");
		}
		
		else {
			System.out.println("겨울");
		}

	}

}
