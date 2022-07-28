package io;

import java.lang.*;
import java.util.Scanner;

public class Test07 {
	public static void main(String[] args) {
		
		//문자열 입력 = .next()
		Scanner sc = new Scanner(System.in); //입력시 띄어쓰기가 있으면 안됨
		
		System.out.println("닉네임 입력");
		String nickName = sc.next(); //문자열 입력 방법
		
		System.out.println("나이 입력");
		int age = sc.nextInt();
		
		sc.close();
		
		System.out.println("입력된 닉네임은 " + nickName + "입니다");
		System.out.println("나이는 " + age + "세 입니다");
	}

}
