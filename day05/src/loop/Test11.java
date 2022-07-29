package loop;

import java.lang.*;

public class Test11 {
	public static void main(String[] args) {
		
		//합계 구하기 (for을 이용한)
		//ex : 1부타 10까지 더한 결과를 출력하세요
		
		//int total = 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10;
		//System.out.println("합계 = " + total);
		
		int total = 0;
		for(int i=1; i<=100; i++) {
			total += i; //1~10
		}
		
		System.out.println(total);
		
		//동일한 코드						//+= 연산자 : 대입 연산자 중 하나로 앞의 변수에 뒤에 값을 더하라
		//int total = 0;				//초기값 0
		//total += 1;					//변수에 저장된 이전값에 오른쪽 값을 더하라
		//total += 2;
		//total += 3;
		//total += 4;
		//total += 5;
		//total += 6;					//더하는 과정을 반복
		//total += 7;
		//total += 8;
		//total += 9;
		//total += 10;
		//System.out.println(total);	//최종적으로 변수에 저장된 값을 출력하라
		
		int a = 0;
		a += 1;
		a += 2;
		a += 3;
		a += 4;
		a += 5;
		a += 6;
		a += 7;
		a += 8;
		a += 9;
		a += 10;
		System.out.println(a);
		
	}

}
