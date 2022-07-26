package data;

import java.lang.*;

public class Test05 {
	public static void main(String[] args) {
		
		//준비
		int americanoPrice = 1300;
		int americanoCount = 4;
		int lattePrice = 2000;
		int latteCount = 3;
		
		//계산
		int americanoTotal = americanoPrice * americanoCount;
		int latteTotal = lattePrice *  latteCount;
		int totalPrice = americanoTotal + latteTotal;
		
		//출력
		System.out.println("총 결제 금액은 다음과 같습니다");
		System.out.println(totalPrice);
		
	}

}
