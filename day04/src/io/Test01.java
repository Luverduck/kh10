package io;

import java.lang.*;

public class Test01 {
	public static void main(String[] args) {
		//I/O - Input / Output, 입출력
		//표준 출력 - System.out 을 이용하여 글자를 내보내는 행위
		//표준 입력 - System.in 을 이용하여 글자를 받아들이는 행위
		
		//System.out.println(); - 화면에 글자를 내보내고 줄을 바꾸는 명령 (print + line)
		System.out.println("Hello"); 
		System.out.println("Hello");
		
		//System.out.print(); - 화면에 글자를 내보내는 명령 (줄바꿈 x)
		System.out.print("Hello"); 
		System.out.print("Hello");
		System.out.print("\n"); //직접 줄바꿈을 하는 것
		System.out.print("Hello");
		System.out.print("\n");
		
		//System.out.printf(); - C언어 개발자를 위해 만든 출력 명령
		System.out.printf("%d + %d = %d \n", 10, 20, 30);
		
		
	}

}
