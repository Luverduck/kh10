package api.lang.String;

public class Test01 {

	public static void main(String[] args) {
		
		// String 클래스 - 문자열을 다루는 클래스
		String a = "hello";
		System.out.println("a = " + a);
		
		// String​(char[] value)
		char[] ch = new char[] {'h', 'e', 'l', 'l', 'o'};
		String b = new String(ch);
		System.out.println("b = " + b);
		
		// String​(String original)
		String c = new String("hello");
		System.out.println("c = " + c);
		
		// a, b, c는 모두 객체이므로 비교 연산자(==)로 같음을 알 수 없다
		
		// 문자열 비교
		System.out.println(a == b);			// 두 참조변수 a, b의 주소를 비교하기 때문
		System.out.println(a.equals(b));	// a와 b의 문자열 값이 같습니까?	-	equals로 비교
		
		// 문자열에는 대소문자가 있다
		String e = "JAVA";
		String f = "Java";
		System.out.println(e.equals(f));	// Java는 대소문자 구별을 한다 (대문자와 소문자가 같다고 생각하지 않음)
		
		// 1) 대문자를 모두 소문자로 바꾸거나 소문자를 모두 대문자로 바꿔서 비교하는 방법
			// - toUpperCase
			System.out.println(e.toUpperCase().equals(f.toLowerCase()));	
		
			// - toLowerCase
			System.out.println(e.toLowerCase().equals(f.toLowerCase()));	
		
		// 2) 대소문자를 무시하고 비교하는 명령
			// - equalsIgnoreCase
			System.out.println(e.equalsIgnoreCase(f));
		
		// 에외? - a와 d는 '같다'
		String d = "hello";			// 그냥 equals로 비교하기
		
		// 자바에서 new(신규) 없이 쓸 수 있는 것
		// 1) 배열(array)
		// 2) 문자열(String)
	}
}
