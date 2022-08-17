package api.util.collection;

import java.util.ArrayList;
import java.util.TreeSet;

public class Test01 {

	public static void main(String[] args) {
		
		// Java Collection Framework (JCF)
		// - Java API에서 제공하는 대용량 데이터 저장 시스템
		// - 배열을 대체하거나 호환 가능한 클래스 모음
		// - 자바의 배열은 크기가 생성시 정해지는 정적 저장소 (생성 후에는 변경 불가)
		// - Collection은 불확실한 데이터 개수를 처리하는 것을 목적으로 만들어졌다
		
		// Set -> 정해진 순서
		
		// List -> 들어온 순서
		
		TreeSet a = new TreeSet();			// 가나다 순으로 데이터를 저장하는 저장소
		ArrayList b = new ArrayList();		// 들어온 순서대로 데이터를 저장하는 저장소 (저장 형태가 배열과 비슷한 형태)
		
		// 데이터 추가 명령 : add
		a.add("아이유");		b.add("아이유");
		a.add("윤하");		b.add("윤하");
		a.add("진");			b.add("진");
		a.add("박재범");		b.add("박재범");
		a.add("싸이");		b.add("싸이");
		
		System.out.println("a = " + a);
		System.out.println("b = " + b);
	}
}
