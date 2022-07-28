package io;

//PC방 요금이 시간당 1000원 입니다
//사용자의 시작시각, 종료 시각을 입력받아서 이용 요금을 계산하도록 구현
//(10원 단위는 버림 처리)

import java.lang.*;
import java.util.Scanner;

public class Test06_me {
	public static void main(String[] args) {
		
		int pricePerHour = 1000;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("입실[h] : ");
		int inHour = sc.nextInt();
		System.out.print("입실[min] : ");
		int inMinute = sc.nextInt();
		int in = inHour * 60 + inMinute;
		
		System.out.print("퇴실[h] : ");
		int outHour = sc.nextInt();
		System.out.print("퇴실[min] : ");
		int outMinute = sc.nextInt();
		int out = outHour * 60 + outMinute;
		
		sc.close();
		
		int time = out - in;
		System.out.println("총 사용 시간 : " + time + "분");
		
		int price = pricePerHour * time / 60;
		int netPrice = price / 100 * 100; 	//(복습) 소수점 2째 자리까지 남기는 방법
		System.out.println("총 이용 요금 : " + netPrice + "원");
		
		//또는 형 변환(casting) 이용
		double pricePerMinute = pricePerHour / 60.0; //나눌 때 60.0(double)로 나눌 것
		int price1 = (int)(pricePerMinute * time) / 100 * 100;
		System.out.println("총 이용 요금 : " + price1 + "원");
		
		
		
	}
	
	

}
