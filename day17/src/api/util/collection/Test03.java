package api.util.collection;

import java.util.ArrayList;
import java.util.List;

public class Test03 {

	public static void main(String[] args) {
		
		// List의 주요 명령
		List<String> list = new ArrayList<>();
		
		// 데이터 추가	 (list의 인덱스는 0부터 시작한다)
		list.add("피카츄");
		list.add("파이리");
		list.add("꼬부기");
		list.add("라이츄");
		list.add("또가스");
		
		// 검색
		// (Q) 피카츄가 list에 있습니까?
		System.out.println(list.contains("피카츄"));	// .contains(Object O) : 해당 자료를 포함하고 있는지 (boolean)
		System.out.println(list.indexOf("꼬부기"));	// .indexOf(Object O) : 해당 자료가 있는 index 번호 반환 (int)
		
		System.out.println();
		
		// (Q) 2번 위치에 들어있는 것은 무엇입니까?
		System.out.println(list.get(2));			// .get(int index) : 해당 index 번호에 있는 데이터 반환
		
		System.out.println();
		
		// (Q) 피카츄 제거
		list.remove("피카츄");						// .remove(Object o) : 해당 자료 제거
		
		
		// 출력(확인용)
		System.out.println(list);
		System.out.println(list.isEmpty());		// .isEmpty() : 비어 있는지
		System.out.println(list.size());		// .size() : 데이터의 갯수
	}
}
