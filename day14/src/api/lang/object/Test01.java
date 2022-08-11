package api.lang.object;

public class Test01 {

	public static void main(String[] args) {
		
		// Object의 객체 생성
		Object a = new Object();
		Object b = new Object();
		
		// Object가 가진 멤버필드 탐색 
		// 없음
		
		// Object가 가진 메소드 탐색
		System.out.println(a.toString());		// a의 요약정보 (16진수 일련번호
		System.out.println(b.toString());		// b의 요약정보 
		
		System.out.println(a.hashCode());		// a의 일련번호 (10진수 일련번호)
		System.out.println(b.hashCode());		// b의 일련번호
		
		System.out.println();
	}
}
