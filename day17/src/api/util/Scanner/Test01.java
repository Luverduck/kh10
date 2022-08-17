package api.util.Scanner;

import java.util.Scanner;

public class Test01 {

	public static void main(String[] args) {
		
		String origin = "학교종이 땡땡땡 어서 모여라\n선생님이 우리를 기다리신다";
		
		// Scanner : 입력 분해 도구
		
		Scanner sc = new Scanner(origin);
		
		// .next() - 단어(공백 전까지)
		// .hasNext() - 읽을 수 있는 단어가 있는지 확인
/*		System.out.println(sc.hasNext());
		System.out.println(sc.next());
		System.out.println(sc.hasNext());
		System.out.println(sc.next());
		System.out.println(sc.hasNext());
		System.out.println(sc.next());
		System.out.println(sc.hasNext());
		System.out.println(sc.next());
		System.out.println(sc.hasNext());
		System.out.println(sc.next());
		System.out.println(sc.hasNext());
		System.out.println(sc.next());
		System.out.println(sc.hasNext());
		System.out.println(sc.next());
		System.out.println(sc.hasNext());
		System.out.println(sc.next());	// 더 읽을 단어가 없을 때 예외 발생		*/
		
		// while문으로 문자열 읽기
		while(true) {
			if(sc.hasNext() == false) {	// 읽을 수 있는 단어가 없을 때까지(false)
				break;
			}
			System.out.println(sc.next());
		}
		
		// while문을 더 간결하게 하는 방법
		while(sc.hasNext()) {	// sc.hasNext()는 boolean을 반환하므로
			System.out.println(sc.next());
		}
		
		sc.close();
	}
}
