package data;

import java.lang.*;

public class Test16 {
	public static void main(String[] args) {
		//문자열 (String)
		//-쌍따옴표("")를 이용해서 글자를 저장
		//-크기는 만들어봐야 알 수 있다 (주문제작 형태)
		//-참조형(reference type) <-> int, char, long 등은 원시형 데이터
		//-부가적인 명령들을 사용할 수 있다 (형태 : a.기능)
		
		
		String a = "hello";
		System.out.println(a);
		
		System.out.println(a.length());
		System.out.println(a.toUpperCase());
		
		//-문자열은 덧셈이 가능하다	김 + 철수 = 김철수
		System.out.println("hello" + "java");
		
		int money = 500;
		System.out.println("소지금은 " + money + "원 입니다");
		
		//-출력이 되지 않는 특이한 형태의 글자들이 있다.
		//String b = "가	나	다	라	마"; //tap 키 = ₩t(\t)를 사용하여 구분 
		String b = "가\t나\t다\t라\t마"; // ₩는 , \는 표준
		System.out.println(b);
		
		//escape 문자
		//-\t : tab
		//-\n : 줄바꿈
		
		String x = "가\n나\n다\n라\n마"; // ₩n(\n) : 줄바꿈
		System.out.println(x);
		
		//문자열 변수를 만들어 다음 글자룰 저장 후 출력
		//-나는 지금 "피자"가 먹고 싶어요
		String c = "나는 지금 \"피자\"가 먹고 싶어요"; // \와 "가 묶여 글자임을 인식
		System.out.println(c);
		
		String d = "D:\\study"; // \를 2개 쓰면 문자로 인식하여 \를 1개를 출력
		System.out.println(d);
		
		
	}

}
