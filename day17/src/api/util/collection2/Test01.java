package api.util.collection2;

import java.util.Set;
import java.util.TreeSet;

public class Test01 {

	public static void main(String[] args) {
		
		// Set
		// - 중복이 없는 저장소
		// - 순서가 정해진 저장소 (ㄱㄴㄷ순으로 저장된다 - 오름차순)
		
		TreeSet a = new TreeSet();
		TreeSet<String> b = new TreeSet<>();	// int 저장할 떄는 Integer로 쓰기 (Wrapper class)
		
		// 업캐스팅
		Set<String> c = new TreeSet<>();
		
		// 추가 - .add()
		c.add("마리오");
		c.add("루이지");
		c.add("쿠파");
		c.add("피오나");
		c.add("마리오");	// Set은 중복을 허용하지 않는다 -> 중복이 필요없는 경우에만 사용한다 
						// ex) 중복없이 1부터 45까지 중 6개를 뽑는 로또 번호
		
		// 출력
		System.out.println(c);
		
		// .size() : Set의 크기
		System.out.println(c.size());
		
		// .contains(Object o) : 포함 여부
		System.out.println(c.contains("피카츄"));
		
		// .remove(Object o) : 데이터 제거 (저장하는 순서가 없으므로 해당 값을 직접 입력해서 지운다)
		c.remove("루이지");
		System.out.println(c);
		
		// (주의) Set은 .get() 이 없다 (순서 index가 없음)
	}
}
