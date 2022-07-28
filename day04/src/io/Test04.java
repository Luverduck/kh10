package io;

import java.lang.*;
import java.util.Scanner;

public class Test04 {
	public static void main(String[] args) {
		
		//중국집 금액 계산 프로그램
		
		//준비
		
		//사장님이 정하는 정보
		int jja = 5000;
		int cham = 6000;
		
		//손님이 정하는 정보 (입력) //생성 코드
		Scanner sc = new Scanner(System.in);
		
		System.out.println("자장면 개수를 입력하세요");
		int jjaCount = sc.nextInt();
		
		System.out.println("짬뽕 개수를 입력하세요");
		int chamCount = sc.nextInt();
		
		//정리 코드
		sc.close();
		
		//계산
		int jjaTotal = jja * jjaCount;
		int chamTotal = cham * chamCount;
		int total = jjaTotal + chamTotal;
		
		//출력
		System.out.println("결제 금액 : " + total);
		
	}

}
