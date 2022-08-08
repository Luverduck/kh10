package oop.keyword10;

import java.util.Random;

public class Test01 {

	public static void main(String[] args) {
		
		// 동전 던지기
		Random r = new Random();
		int coin = r.nextInt(2);		// 0부터 2개 (0일 때 앞 / 1일 때 뒤) - 주석이 없다면 이해하기가 어렵다
		if(coin == 0) {
			System.out.println("앞");
		}
		else {
			System.out.println("뒤");
		}
		
		
	}
}
