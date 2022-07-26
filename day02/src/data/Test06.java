package data;

import java.lang.*;

public class Test06 {
	public static void main(String[] args) {
		//정수와 정수의 특징
		//정수는 소수점이 없는 숫자
		//-int : 2^32 범위의 정수를 저장할 수 있는 단위(약 42억 개). 기본값
		//-byte : 2^8 범위의 정수를 저장할 수 있는 단위(256개). 파일에서 사용
		//-short : 2^16 범위의 정수를 저장할 수 있는 단위(65536개). 사용 안함
		//-long : 2^64 범위의 정수를 저장할 수 있는 단위(약 1800경)
		
		//1. 정해진 크기를 벗어나면 저장이 불가능하다
		//int a = 100.5; (변수 종류 오류)
		//byte b = 1000; (범위 초과)
		//int c = 3000000000; (범위 초과)
		
		//2. 계산 과정에서 범위를 초과하면 순환된다(순환형 구조)
		int d = 2000000000 + 1000000000;
		System.out.println(d);
		
		long e = 3000000000L;
		System.out.println(e);
		
		long f = 2000000000L + 1000000000L;
		System.out.println(f);
		
		//3. 정수는 어떤 계산을 해도 정수가 나온다
		System.out.println(10 / 3); //몫
		System.out.println(10 % 3); //나머지
		
	}

}
