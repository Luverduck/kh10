package loop;

//사용자에게 숫자를 5개 입력받는 프로그램 구현

import java.lang.*;

import java.util.Scanner;

public class Test02 {
	public static void main(String[] args) {
		
		//준비
		Scanner sc = new Scanner(System.in); //(주의) 도구는 반복문 내에서 만들지 않는다
		
		System.out.println("숫자 5개를 입력하세요");
		
		//숫자 5개를 입력받도록 (5번 입력 받도록)
		for(int i=0 ; i<5 ; i=i+1) {
			int a = sc.nextInt();
		}
		
		sc.close();
		
	}

}
