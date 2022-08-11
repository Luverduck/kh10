package api.lang.object;

import java.util.Random;
import java.util.Scanner;

public class Test02 {

	public static void main(String[] args) {
		
		// Object는 모든 데이터의 최상위 클래스이다
		// -> 다형성의 최고 정점에 있다
		// -> '아무거나' 저장 가능하다	(업캐스팅)
		
		Object a = "hello";
		Object b = 10;
		Object c = 3.14;
		Object d = true;
		
		Object array = new int[5];
		Object r = new Random();
		Object sc = new Scanner(System.in);
		
		// Object 상태일 때는 고유 기능을 사용할 수 없다
		// -> 하지만 어떤 형태인지 검사는 가능하다
		System.out.println(a.getClass());		// 보관하고있는 것이 무슨 형태인지 출력
		System.out.println(b.getClass());
		
		// (Q) a는 String 형태인가요??
		System.out.println(a instanceof String);	// a의 자료형이 String인가에 대한 true 또는 false 출력
		System.out.println(a instanceof Random);
		
		// (Q) 내가 만든 클래스도 Object의 자식인가?
		Object s = new Student();					// 내가 만든 클래스도 Object로 보관된다
	}
}
