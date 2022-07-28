package condition;

//지하철 요금은 다음과 같습니다.
//-성인(20~64세) : 1250원
//-청소년(14~19세) : 720원
//-어린이(8~13세) : 450원
//-영유아(~7세) : 무료
//출생년도 4자리가 주어졌을 때 지하철 요금을 계산하여 출력하는 프로그램 구현

import java.lang.*;

public class Test09 {
	public static void main(String[] args) {

		int now = 2022;
		int birth = 1957;
		
		int age = now - birth + 1;

		if (age <= 7 && age >= 1) {			//7을 초과하는지 먼저 판단
			System.out.println("무료");
		} 
		
		//&& : and
		//|| : or
		
		//else가 age > 7 || age < 1를 의미하는지??
		
		else if (age <= 13) {				//else(7을 초과한다면) 13를 초과하는지 판단
			System.out.println("450원");	
		} 
		
		//else가 age > 13을 의미하는지?
		//else if를 적용할 때 가장 첫 번째 썻던 if 조건은 영향을 받지 않는 것인지??
		
		else if (age <= 19) {
			System.out.println("720원");		//else(13를 초과한다면) 19을 초과하는지 판단
		} 
		else if (age <= 64) {
			System.out.println("1250원");	//else(20을 초과한다면) 64를 초과하는지 판단
		} 
		else {
			System.out.println("무료");
		}
		
		int price;
		if (age < 8 || age >= 65) {			//7을 초과하는지 먼저 판단
			price = 0;
			}
		else if (age >= 20) {
			price = 1250;
			}
		else if (age >= 14) {
			price = 720;
			}
		else {
			price = 450;
		} 
		
		System.out.println("요금 : " + price + "원");

	}

}
