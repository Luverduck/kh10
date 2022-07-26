package data;

import java.lang.*;

public class Test10 {
	public static void main(String[] args) {
		//실수의 종류와 특징
		//실수는 소수점이 있는 숫자
		
		//표현 범위에 따라
		//-float : 2^32 (4byte, 32bit)
		//-double : 기본값, 2^64 (8byte, 64bit)

		float a = 1.5f; //long은 1과 헷갈릴 수 있으므로 대문자 사용
		double b = 1.5;
		
		System.out.println(a);
		System.out.println(b);
		
		//[1] 실수는 부정확하다 - 실수가
		float c = 1.23491239012830812093812032985703f;
		System.out.println(c);
		
		double d = 1.21238098243589734290573920790732312;
		System.out.println(d);
		
		//[2] 실수가 하나라도 포함되면 결과값은 실수가 된다
		System.out.println(10 / 3); //정수 나누기 정수
		System.out.println(10 / 3.0); //정수 나누기 실수
		System.out.println(10 / 3d); //double을 나타낼 때 d를 붙일 수도 있다 (보통 사용하지 않음)
		System.out.println(10 / 3f); //정수 나누기 실수
		
	}
}
