package io;

//PC방 요금이 시간당 1000원 입니다
//사용자의 시작시각, 종료 시각을 입력받아서 이용 요금을 계산하도록 구현
//(10원 단위는 버림 처리)

import java.lang.*;
import java.util.Scanner;

public class Test06 {
	public static void main(String[] args) {
			
		//준비
		int pricePerHour = 1000;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("시작 시간 입력");
		int in = sc.nextInt();
		System.out.println("종료 시간 입력");
		int out = sc.nextInt();
		
		int inHour = in / 100, inMinute = in % 100;
		int outHour = out / 100, outMinute = out % 100;
		sc.close();
		
		//계산
		int inTime = inHour * 60 + inMinute;
		int outTime = outHour * 60 + outMinute;
		int time = outTime - inTime;
		
		double pricePerMinute = pricePerHour / 60.0;
		
		int price = (int)(time * pricePerMinute);
		int netPrice = price / 100 * 100;
		
		//출력
		System.out.println("이용 요금 : " + netPrice + "원");
				
	}
	
}
