package data;

import java.lang.*;

public class Test15 {
	public static void main(String[] args) {
		
		//문자 (char, 2byte)
		//-유니코드 한 글자를 저장할 수 있는 형태
		//-외따옴표('') 사용 <-> 쌍따옴표("")는 문자열로 인식
		//-문자열의 부품 역할을 수행
		//-각각의 글자는 숫자 번호를 가지고 있다
		
		char a = 'H';
		System.out.println(a);
		System.out.println((int)a);
		
		a += 32; //a를 32 증가시켜라(더해넣어라)
		System.out.println(a);
		
		char b='밥';		
		System.out.println(b);
		System.out.println((int)b);
		
	}

}
