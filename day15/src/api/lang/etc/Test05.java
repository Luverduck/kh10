package api.lang.etc;

public class Test05 {

	public static void main(String[] args) {
		
		// String 합성 (StringBuffer, StringBuilder) -> StringBuffer와 StringBuilder의 차이?? "동기화 지원 여부"
		// - 문자열의 덧셈이 성능이 좋지 않은 이유는 문자열이 불변(immutable)이기 때문 - String에 값이 저장되면 그 값은 절대 바뀌지 않음
		
		// StringBuffer는 동기화를 지원한다 -> 멀티쓰레드 환경에서 사용
		// StringBuilder는 동기화를 지원하지 않는다 -> 속도는 빠르지만 안정성이 떨어진다 -> 멀티쓰레드 환경에서 사용하기 어렵다
		
		long a = System.currentTimeMillis();
		
		//String star = "";
		StringBuffer buffer = new StringBuffer();
		for(int i = 0 ; i < 1000 ; i ++) {
			buffer.append("*");
		}
		
		long b = System.currentTimeMillis();
		
		System.out.println(buffer.toString());
		System.out.println(b-a);
		
		// ** 시간 복잡도
		// 횟수가 10배가 늘어났을 때 10배 
	}
}
