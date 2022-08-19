package api.util.collection2;

// 다음 요구사항에 따른 계산을 수행하여 결과를 출력하시오.
// 철수와 영희는 각자 국내에서 상영하는 영화를 다음과 같이 봤습니다.
// 철수 : 이상한 나라의 수학자, 더 배트맨, 인민을 위해 복무하라, 블랙라이트
// 영희 : 더 배트맨, 스파이더맨 : 노웨이 홈, 블랙라이트, 우리가 사랑이라고 믿는 것
// (Q) 철수와 영희가 둘 다 본 영화 목록을 출력하세요
// (Q) 철수와 영희 중 한 명만 본 영화 목록을 출력하세요
 
import java.util.Set;
import java.util.TreeSet;

public class Test07 {

	public static void main(String[] args) {
		
		// 철수의 Set 생성
		Set<String> chul = Set.of("이상한 나라의 수학자", "더 배트맨", "인민을 위해 복무하라", "블랙라이트");
		
/*		Set<String> chul = new TreeSet<>();
		chul.add("이상한 나라의 수학자");
		chul.add("더 배트맨");
		chul.add("인민을 위해 복무하라");
		chul.add("블랙라이트");
*/		
		
		// 영희의 Set 생성
		Set<String> young = Set.of("더 배트맨", "스파이더맨 : 노웨이 홈", "블랙라이트", "우리가 사랑이라고 믿는 것");
		
/*		Set<String> young = new TreeSet<>();
		young.add("더 배트맨");
		young.add("스파이더맨 : 노웨이 홈");
		young.add("블랙라이트");
		young.add("우리가 사랑이라고 믿는 것");
*/		
		// 둘 다 본 영화 (교집합)
		Set<String> common = new TreeSet<>();
		common.addAll(chul);
		common.retainAll(young);
		System.out.println("둘 다 본 영화");
		for(String name : common) {
			System.out.println("--> " + name);
		}
		
		// 둘 중 한명만 본 영화
		// 1. (A ∪ B) - (A ∩ B)
		Set<String> complement = new TreeSet<>();
		complement.addAll(chul);
		complement.addAll(young);
		complement.removeAll(common);
		System.out.println("둘 중 한명만 본 영화");
		for(String name : complement) {
			System.out.println("--> " + name);
		}
		
		// 2. (A - B) ∪ (B - A)
		Set<String> e = new TreeSet<>();
		e.addAll(chul);
		e.removeAll(young);
		
		Set<String> f = new TreeSet<>();
		f.addAll(young);
		f.removeAll(chul);
		
		Set<String> g = new TreeSet<>();
		g.addAll(e);
		g.addAll(f);
		System.out.println("둘 중 한 명만 본 영화");
		for(String name : g) {
			System.out.println("-> " + name);
		}
	}
}
