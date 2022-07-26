package data;

//KH PC방에서는 1시간에 1200원의 요금을 받고 있습니다.
//만약 요금이 10원단위로 나올 경우 해당 요금은 받지 않습니다
//(ex) 1250원이면 1200원만 받습니다
//12시 40분부터 16시 10분까지 이용한 고객의 요금을 출력

import java.lang.*;

public class Test09 {
	public static void main(String[] args) {

		//준비
		int inHour = 12, inMinute = 40;
		int outHour = 16, outMinute = 10;
		int pricePerHour = 1200;
		
		//계산
		int inTime = inHour * 60 + inMinute;
		int outTime = outHour * 60 + outMinute;
		int time = outTime - inTime;
		
		int pricePerMinute = pricePerHour / 60;
		
		int price = time * pricePerMinute;
		
		int hour = time / 60;
		int minute = time % 60;
		
		int fixPrice = price / 100 * 100;
		
		//출력
		System.out.println("이용 시간은 다음과 같습니다");
		System.out.println(time);
		System.out.println("이용 요금은 다음과 같습니다");
		System.out.println(fixPrice);
		
		
	}

}
