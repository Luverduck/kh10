package condition;

import java.lang.*;

public class Test01 {
	public static void main(String[] args) {
		
		//조건부 코드
		//-특정 상황에서만 실행되는 코드
		//
		
		//준비
		int number = 7;
		
		//계산
		int mod = number % 2; //mod : 나머지
		//boolean odd = 나머지가 1이면
		boolean odd = mod == 1; // 같다 = '=='
		//boolean even = 나머지가 0이면
		boolean even = mod == 0; 
		
		//출력
		if(odd == true){//이 영역은 odd라는 변수가 true일 때 나와야 한다
			System.out.println(number + "는 홀수입니다.");
		}
		if(even == true){//이 영역은 odd라는 변수가 false일 때 나와야 한다
			System.out.println(number + "는 짝수입니다.");
		}
		
		//둘 중 하나만 쓰고 odd가 true일 때 홀수, false일 때 짝수가 되도록 하는 것이 좋을듯
		//if(odd = false) {System.out.println(number + "는 짝수입니다.");}
		
	}

}
