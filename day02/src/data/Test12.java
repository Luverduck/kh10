package data;

import java.lang.*;

public class Test12 {
	public static void main(String[] args) {
		//정수와 실수의 비교 및 변환
		//-정수 : byte(1), short(2), int(4), long(8)
		//-실수 : float(4), double(8)

		//규칙
		//1. 작은 형태의 데이터는 큰 형태로 저장할 수 있다
		//2. 큰 형태의 데이터는 작은 형태로 저장할 수 없다, 데이터 손실 발생할 수 있음
		//3. 실수는 무조건 정수보다 크다

		int a = 10;
		long b = a; //long이 더 크므로 int를 long에 저장할 수 있다 (자동 변환)
		
		long c = 10L;
		int d = (int)c; // long이 더 크므로 long을 int로 저장할 수 없다 (자동 변환 불가능, 변환 연산시 가능)
		
		long e = 10L;
		float f = e; //long -> float 시 자동 변환
		
		//float g = 1.5f;
		//long h = g; //float -> long 시 강제 변환 (자동 변환 불가능)
		
	}

}
