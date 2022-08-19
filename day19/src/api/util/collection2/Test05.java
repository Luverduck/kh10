package api.util.collection2;

import java.util.ArrayList;
import java.util.List;

public class Test05 {

	public static void main(String[] args) {
		
		// 집합 연산
		List<Integer> a = new ArrayList<>();
		a.add(1);
		a.add(2);
		a.add(3);
		
		List<Integer> b = new ArrayList<>();
		b.add(3);
		b.add(4);
		b.add(5);
		
		// 합집합
		// - List를 합칠 때 1, 2, 3, 3, 4, 5 (중복 허용) -> 중복을 제거하려면 Set을 이용해야 한다
		List<Integer> c = new ArrayList<>();
		c.addAll(a);
		c.addAll(b);	// 순서를 바꾸면 3, 4, 5, 1, 2, 3
		System.out.println(c);
		
		// 교집합
		
		
		// 차집합 (a-b, b-a)
	}
}
