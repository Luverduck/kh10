package condition;

//KH 반점에서는 다음과 같은 메뉴를 판매하고 있습니다.
//-자장면 : 5000원
//-짬뽕 : 6000원
//매출을 올리기 위해서 총 3그릇 이상 주문하면 10%를 할인해 줍니다.
//임의의 자장면, 짬뽕 주문 수량에 대해 결제 금액을 계산하도록 구현

import java.lang.*;

public class Test05 {
	public static void main(String[] args) {

		// 준비
		int jjajangPrice = 5000, jjajangQuantity = 3;
		int champonPrice = 6000, champonQuantity = 5;
		int discount = 10;
		
		//계산
		int totalPrice = (jjajangPrice * jjajangQuantity) + (champonPrice * champonQuantity);
		int totalQuantity = jjajangQuantity + champonQuantity;
		
		//문제점
		//할인이 되는 경우와 안되는 경우는 가격만 달라지고 나머진 똑같은데
		//가격 계산만 따로 할 수는 없을까?
		//int total = 원래 금액 or 할인된 금액;
		
		int total;
		if(totalQuantity >= 3) {
			total = totalPrice * (100 - discount) / 100;
		}
		
		else {
			total = totalPrice;
		}
		
		//출력
		System.out.println("결제 금액은 " + total + "원 입니다");

	}

}
