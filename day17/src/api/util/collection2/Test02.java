package api.util.collection2;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

// 로또 추첨 문제를 Set으로 풀어보세요

public class Test02 {

	public static void main(String[] args) {
		
		// Set 생성
		Set<Integer> lotto = new TreeSet<>();
		
		// Random 인스턴스 생성
		Random r = new Random();
		
		// 1부터 45까지 랜덤으로 번호 6개를 뽑아서 Set에 입력
		for(int i = 0 ; i < 6 ; i ++) {
			int numR = r.nextInt(45) + 1;
			if(lotto.contains(numR)) {
				i --;
			}
			else {
				lotto.add(numR);
			}
		}
		
		// lotto에 입력된 숫자 출력
		System.out.println(lotto);
	}
}
