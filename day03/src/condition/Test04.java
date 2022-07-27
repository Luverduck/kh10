package condition;

//4자리로 출생년도가 중졌을 때(ex : 1995)
//이 사람이 지하철 무임승차 대상인지 확인해서 알려주도록 구현
//(65세 이상의 어르신과 7세 이하의 영유아가 무임승차 대상입니다)

import java.lang.*;

public class Test04 {
	public static void main(String[] args) {
	
		//준비 - 출생년도 4자리
		int now = 2022;
		int birth = 1995;
		
		//계산 - 나이
		int age = now - birth + 1;
		System.out.println("나이 : " + age); //나이 구하는 방법 - Test
		
		boolean priceTF = age <= 7 || age >= 65;
		System.out.println("무임승차 대상 여부 : " + priceTF);
		
		if(priceTF == true) {
			System.out.println("무임승차 대상이 맞습니다");
		}
		
		if(priceTF == false) {
			System.out.println("무임승차 대상이 아닙니다");
		}
		
		//또는
		if(age <= 7 || age >= 65) {
			System.out.println("무임승차 대상이 맞습니다");
		}
		
		if(age > 7 || age < 65) {
			System.out.println("무임승차 대상이 아닙니다");
		}
		
		//또는 (if ~ else ~ 구문)
		if(age <= 7 || age >= 65) {
			System.out.println("무임승차 대상이 맞습니다");
		}
		else {
			System.out.println("무임승차 대상이 아닙니다");
		}
		
		
	}

}
