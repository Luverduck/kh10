package api.util.collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Test02 {

	public static void main(String[] args) {
		
		// Generic type : 자료형을 미리 정해두지 않고 그때그때 정해서 사용
		// <E> : 만들 때 인터페이스를 지정하지 않도록
		
		// List <E>
		
		// ArrayList() : 초기 용량이 10인 빈 List를 생성
		ArrayList a = new ArrayList();		// 저장할 형태를 미 지정(자동으로 Object가 됨)
		
		a.add(100);
		a.add("Hello");
		
		// List를 만들 때 반드시 저장할 형태를 명시해야 한다
		ArrayList<Object> b = new ArrayList<Object>();	// 저장할 형태 : Object
		ArrayList<String> c = new ArrayList<String>();	// 저장할 형태 : String
		
		//c.add(100);		// type 불일치, 저장 불가
		c.add("Hello");		// type 일치, 저장
		
		// 오른쪽의 Generic type는 생략 가능 (왼쪽은 반드시 입력)
		ArrayList<String> d = new ArrayList<>();
		
		// 가급적 List로 업캐스팅하여 생성한다
		// 최종 List 생성 형태
		List<String> e = new ArrayList<>();
		List<String> f = new LinkedList<>();
		
		// ArrayList와 LinkedList의 차이??
	}
}
