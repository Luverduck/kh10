package api.util.collection;

import java.util.ArrayList;
import java.util.List;

// List에 다음 데이터를 추가하고 무작위로 1개를 추첨하도록 구현하시오
// 자바, 파이썬, 루비, 안드로이드, 자바스크립트

import java.util.Random;

public class Test04 {

	public static void main(String[] args) {
		
		// List 생성
		List<String> list = new ArrayList<>();
		
		// List에 값 입력
		list.add("자바");
		list.add("파이썬");
		list.add("루비");
		list.add("안드로이드");
		list.add("자바스크립트");
		
		// 출력 (확인용)
		//System.out.println(list);
		
		// List의 길이
		//System.out.println(list.size());
		
		// 난수 생성
		Random r = new Random();
		int numR = r.nextInt(list.size());
		
		// 추첨 출력
		System.out.println(list.get(numR));
		
	}
}
