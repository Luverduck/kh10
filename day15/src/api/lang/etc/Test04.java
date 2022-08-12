package api.lang.etc;

public class Test04 {

	public static void main(String[] args) {
		
		// String 합성 (StringBuffer, StringBuilder) -> StringBuffer와 StringBuilder의 차이??
		// - 문자열의 덧셈이 성능이 좋지 않은 이유는 문자열이 불변(immutable)이기 때문 - String에 값이 저장되면 그 값은 절대 바뀌지 않음
		// - 
		
		// 별 생성 코드 -> 문자열 덧셈은 성능적인 측면에서 치명적인 단점이 있다
		long a = System.currentTimeMillis();
		
		String star = "";
		for(int i = 0 ; i < 1000 ; i ++) {	// 100만 이상 시 엄청 오래 걸림
			star += "*";
		}
		System.out.println(star);
		
		long b = System.currentTimeMillis();
		
		System.out.println(b-a);
		
		// ** 시간 복잡도
		// 횟수가 10배가 늘어났을 때 10배 
	}
}
