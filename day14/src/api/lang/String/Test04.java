package api.lang.String;

public class Test04 {

	public static void main(String[] args) {
		
		// 기타 문자열 명령
		String a = "안녕하세요";
		
		// 한 글자 추출 명령 .charAt​(int index)
		for(int i = 0 ; i < a.length() ; i ++) {
			char ch = a.charAt(i);				// 추출한 글자가 '가'부터 '힣' 사이에 있으면 한글로 간주할 수 있다 -> 한글만으로 구성된 문자열인지 검사할 수 있다
			System.out.println(a.charAt(i));	// 문자열 a의 0번부터 4번까지 한글자씩 출력
		}
		//System.out.println(a.charAt(0));		// a의 0번 index 글자를 반환 -> '안'
		
		
		// 문자열의 일부 추출 : .substring​(int beginIndex, int endIndex)
		System.out.println(a.substring(1));		// index 1번인 '녕'부터 이후 글자 전부다 출력		// index는 배열의 index 규칙을 따름 (0번부터 시작)
		System.out.println(a.substring(2, 4));	// index 2번인 '하' 앞부터 '요' 앞까지 추출
		
		
		// 문자열 반복 : .repeat​(int count)
		String b = "hello";
		System.out.println(b.repeat(5));
		
		
		// 문자열 치환 : .replace​(CharSequence target, CharSequence replacement)
		String c = "나는 피자가 좋아요";
		System.out.println(c);
		System.out.println(c.replace("자바", "피자"));	// "자바"를 "피자"로 바꾼다		// c.replace(무엇을, 얼마로)
	}
}
