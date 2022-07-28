package io;

import java.lang.*;
import java.util.Scanner; //Scanner를 위한 import

public class Test03 {
	public static void main(String[] args) {
		
		//보조 도구(Scanner)를 사용한 입력
		//(1) Scanner는 기본적으로 제공되는 도구가 아니다
		//(2) 만들어서 사용해야 한다
		
		//도구 생성
		//-new는 오른 쪽에 제시된 도구를 생성하는 명령
		Scanner sc = new Scanner(System.in);
		
		//int a = 10; 원시형
		//String b = "hello; 참조형
		
		//정수 입력
		int a = sc.nextInt(); //정수 입력까지 대기중
		System.out.println("a = " + a);
		
		float b = sc.nextFloat();
		System.out.println("b = " + b);
		
		double c = sc.nextDouble();
		System.out.println("c = " + c);
		
		//다 썼으면 만든 도구 정리
		sc.close();
		
	}

}
