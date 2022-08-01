package random;

//주사위를 100번 던졌을 때 홀수와 짝수가 각각 몇 번씩 나오는지 계산하여 출력하세요

import java.util.Random;

public class Test05 {
	
	public static void main(String[] args) {
		
		Random r = new Random();
		
		int oddCount = 0;
		int evenCount = 0;
		for(int i = 0 ; i < 100 ; i++) {	//탈출 조건이 숫자(횟수)이므로 for로 작성
			int dice = r.nextInt(6) + 1;	//1부터 6까지
			if(dice % 2 == 0) {
				oddCount++;
			}
			else {
				evenCount++;
			}
		}
		
		System.out.println("홀수 : " + oddCount);
		System.out.println("짝수 : " + evenCount);
		
	}
}
