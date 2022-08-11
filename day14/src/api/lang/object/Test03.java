package api.lang.object;

public class Test03 {

	public static void main(String[] args) {
		
		Student a = new Student("피카츄", 50);
		Student b = new Student("피카츄", 50);
		Student c = new Student("피카츄", 60);
		Student d = new Student("라이츄", 60);
		
		// 객체간의 비교는 원시형처럼 단순하지 않다
		// - 상황에 따라, 기준에 따라 달라진다
		
		System.out.println(a == b);			// 객체 비교에서 '==' 사용시 참조형 변수의 주소가 같은지를 비교한다 (원시형 자료에서만 사용)
											// 두 일련번호 a와 b가 쳐다보는 대상(주소)이 같은가?
		
		System.out.println(a.equals(b));	// equals를 재정의하면 '같다'라고 생각할 수 있는 기준을 정할 수 있다
											// Java API에 equals(Object);로 나오는데 Object를 '아무거나'로 해석한다
		
		// - 비교 연산(==)이 아니라 equals()를 재정의하여 객체를 비교한다 (같다, 다르다)
		System.out.println(b.equals(c));
		
		System.out.println(c.equals(d));
		
		
		// Object 클래스란
		// 1) 나 혼자는 의미가 없다
		// 2) 보관을 하거나
		// 3) 기준을 잡아주는 클래스
	}
}
