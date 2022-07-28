package condition;

//KH 여행사는 '무조건 1명 1박에 10만원'이라는 슬로건으로 영업을 하고 있습니다.
//추가로 여름 여행객을 유치하기 위해 다음과 같은 이벤트를 하기로 결정했습니다.
//-여름(6,7,8월)에 여행가는 사람은 무조건 이용요금 25% 할인
//다음 정보가 주어졌을 때 예상 경비를 계산하여 출력하도록 프로그래밍 하세요
//1.인원수(명)
//2.여행기간(월)
//3.여행계획중인 달(1월~12월 사이)

import java.lang.*;

public class Test07 {
	public static void main(String[] args) {
		
		int pricePerCountSpan = 100000;
		
		int travelCount = 1;
		int travelSpan = 1;
		
		int travelMonth = 6;
		int discount = 25;
		
		boolean discountTF =  6 <= travelMonth && travelMonth <= 8;
		
		int price;
		if(discountTF) {
			price = (pricePerCountSpan * travelCount * travelSpan) * (100 - discount) / 100;
			//((100 - discount) / 100); 로 할 때 왜 0이 나왔는가?
		}
		else {
			price = pricePerCountSpan * travelCount * travelSpan;
		}
		
		System.out.println(price);
		
	}

}
