package data;

import java.lang.*;

public class Test08 {
	public static void main(String[] args) {
		
		//준비
		int firsthour = 12;
		int firstminute = 40;
		int lasthour = 16;
		int lastminute = 10;
		
		//계산	
		int firstTime = firsthour * 60 + firstminute;
		int lastTime = lasthour * 60 + lastminute;
		int time = lastTime - firstTime;
		int hour = time / 60;
		int minute = time % 60;
		//System.out.println(time);
		
		//계산
		int timeCount = time / 10; //0~9분까지는 무료 = 0~9분까지는 10으로 나누면 0이다(나머지 버림)
		int totalPrice = timeCount * 1000;
		
		//출력
		System.out.println("주차 요금은 다음과 같습니다");
		System.out.println(totalPrice);
		
		System.out.println("주차 시간");
		System.out.println(hour + "시간" + minute + "분");
			
	}

}
