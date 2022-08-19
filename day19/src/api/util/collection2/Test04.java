package api.util.collection2;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Test04 {

	public static void main(String[] args) {
		
		// HashSet vs TreeSet 비교
		Set<String> a = new HashSet<>();
		Set<String> b = new TreeSet<>();
		
		// contains를 확인할 때 - HashSet 유리
		// 정렬을 해야 할 때 - TreeSet 유리
		
		a.add("마리오");		b.add("마리오");
		a.add("루이지");		b.add("루이지");
		a.add("꼬부기");		b.add("꼬부기");
		a.add("라이츄");		b.add("라이츄");
		a.add("뮤츠");		b.add("뮤츠");
		
		System.out.println("HashSet = " + a);
		System.out.println("TreeSet = " + b);
	}
}
