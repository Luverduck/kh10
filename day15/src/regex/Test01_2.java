package regex;

public class Test01_2 {

	public static void main(String[] args) {
		
		// ^(hi|hello)$ -> 문자열 hi와 hello 중 하나 -> '|'은 OR을 의미
		
		// 000부터 100 사이에 속하는가?
		// ^(0[0-9][0-9]|100)$	
		
		// 000부터 150 사이에 있는가?
		// ^(0[0-9][0-9]|1([0-4][0-9]|50)$
		
	}
}
