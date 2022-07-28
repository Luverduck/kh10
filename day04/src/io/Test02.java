package io;

import java.io.IOException;
import java.lang.*;

public class Test02 {
	public static void main(String[] args) throws IOException {
		
		//System.in 만을 사용하여 입력을 받는 예제
		//(문제점) 
		//1. 하나의 명령이 한 글자만 입력받는다
		//2. 입력을 아스키코드표 숫자로 변화해서 받는다
		//3. 예외 처리를 해야 한다 - throws IOException {
		//4. 자료형 선택을 할 수 없다
		
		int a = System.in.read(); 
		System.out.println("a =" + a);
		
		int b = System.in.read(); 
		System.out.println("b =" + b);
		
		int c = System.in.read(); 
		System.out.println("c =" + c);
		
		int d = System.in.read(); 
		System.out.println("d =" + d);
		
		int e = System.in.read(); 
		System.out.println("e =" + e);
		
	}

}
