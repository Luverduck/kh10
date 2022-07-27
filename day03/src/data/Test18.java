package data;

// 2000년생이 편의점에 와서 담배를 사려고 합니다.
// 구매 가능한지를 판정해서 출력
// 담배는 한국 나이로 20세 이상이면 구매가 가능합니다.

import java.lang.*;

public class Test18 {
	public static void main(String[] args) {
		
		//한국식 나이는 태어난 해부터 현재까지의 숫자 개수
		//-두 개의 숫자 사이의 개수
		
		//준비
		int now = 2022;
		int birth = 2000;
		int age = now - birth + 1; //한국 나이는 태어날 때부터 1살 이므로 '해당년도 - 출생년도'에서 +1을 한다
		
		//계산
		boolean purchase = age >= 20;
		
		//출력
		System.out.println(purchase);

	}

}
