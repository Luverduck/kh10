package oop.keyword10;

import java.util.Random;

public class Test04 {
	
	public static void main(String[] args) {		
	
		// 동전 던지기
		Random r = new Random();
		int coin = r.nextInt(2);		
		if(coin == Coin.FRONT) {		// Coin.FRONT : Coin 클래스의 FRONT 상수를 호출한다
			System.out.println("앞");
		}
		else {
			System.out.println("뒤");
		}
	}
}
