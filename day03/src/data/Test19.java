package data;

//KH 찜질방에서는 장시간 머무르는 손님들을 없애기 위해 
//최초 입장 후 5시간이 지나면 10분당 1000원의 추가 요금을 부과합니다.
//어떤 손님이 9시 50분에 들어와서 16시 22분에 나가려고 할 때
//이 손님이 추가요금 대상인지 판정하여 출력하고 추가요금을 출력

import java.lang.*;

public class Test19 {
	public static void main(String[] args) {
		
		//준비
		int pricePerTime = 1000;
		int freeTime = 300;
		
		int inHour = 9;
		int inMinute = 50;
		int inTime = inHour * 60 + inMinute;
		
		int outHour = 16;
		int outMinute = 22;
		int outTime = outHour * 60 + outMinute;
		
		int time = outTime - inTime;
		//System.out.println(time);
		
		boolean priceTF = time - freeTime >= 0; //검산은 경계값 위주로 할 것 (경계값 TEST)
		System.out.println("추가요금 여부:" + priceTF);
		
		int netTime = time - freeTime; 
		//freeTime을 빼는 방식으로 하면 300분 미만일 때 (-)금액이 나오는데 어떻게 해야 하는지? '조건 논리'로 해결
		//System.out.println(netTime);
		
		int timeCount = netTime / 10; //바(/) 나눗셈의 결과는 나머지를 버린다 - Test08
		//System.out.println(timeCount);
		
		int price = pricePerTime * timeCount;
		System.out.println("추가요금:" + price);
	}

}
