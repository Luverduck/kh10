package loop;

//사용자에게 10개의 숫자를 입력받아 짝수와 홀수의 개수를 각각 구하여 출력

import java.lang.*;

import java.util.Scanner;

public class Test10 {
	public static void main(String[] args) {
		
		//10개의 숫자를 입력
		Scanner sc = new Scanner(System.in);
		
		int countEven = 0;			//짝수의 갯수 초기값 0
		int countOdd = 0;			//홀수의 갯수 초기값 0
		
		for(int i=0; i<10; i++) {	//반복해야 할 것 : 입력을 10번 받도록 반복
			System.out.print((i+1) + "번째 숫자 입력 : ");
			int a = sc.nextInt();	//받은 입력 10개 - 반복입력이므로 for구문 내에서만 정의된다
			
			if(a % 2 == 0) {		//2로 나눠진다면(짝수라면)
				countEven++;		//짝수 갯수 + 1
			}
			else {					//그렇지 않다면(홀수라면)
				countOdd++;			//홀수 갯수 + 1
			}
			
		}
		sc.close();
		
		System.out.println("짝수의 갯수 : " + countEven);
		System.out.println("홀수의 갯수 : " + countOdd);

	}
}
