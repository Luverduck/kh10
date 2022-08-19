package api.util.collection2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Test06 {

	public static void main(String[] args) {
		
		// 집합 연산
		Set<Integer> a = new TreeSet<>();
		a.add(1);
		a.add(2);
		a.add(3);
		
		Set<Integer> b = new TreeSet<>();
		b.add(3);
		b.add(4);
		b.add(5);
		
		// ** 집합 연산은 Set으로 할 것 (List로 하면 중복허용 때문에 원하는 결과가 안나옴)
		
		// 합집합
		// - Set을 합칠 때 1, 2, 3, 4, 5 (중복 제거)
		Set<Integer> c = new TreeSet<>();
		c.addAll(a);
		c.addAll(b);	// 순서를 바꿔도 똑같음
		System.out.println("합집합 : " + c);
		
		// 교집합
		Set<Integer> d = new TreeSet<>();
		d.addAll(a);
		d.retainAll(b);
		System.out.println("교집합 : " + d);
		
		// 차집합 (a-b, b-a)
		Set<Integer> e = new TreeSet<>();
		e.addAll(a);
		e.removeAll(b);
		System.out.println("차집합 : " + e);	// b-a시 3, 4가 나옴
	}
}
