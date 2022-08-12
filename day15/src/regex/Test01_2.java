package regex;

public class Test01_2 {

	public static void main(String[] args) {
		
		// ^(hi|hello)$ -> 문자열 hi와 hello 중 하나 -> '|'은 OR을 의미
		
		// 000부터 100 사이에 속하는가?
		// ^(0[0-9][0-9]|100)$	
		
		// 000부터 150 사이에 있는가?
		// ^(0[0-9][0-9]|1([0-4][0-9]|50)$
		
		// 이메일 예시
		// ^[a-z0-9]{8,20}@(hanmail\.net|naver\.com|gmail\.com)$
		// .을 나타내기 위해서는 앞에 \를 붙인다
	}
}
