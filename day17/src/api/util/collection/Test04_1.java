package api.util.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// List에 다음 데이터를 추가하고 무작위로 1개를 추첨하도록 구현하시오
// 자바, 파이썬, 루비, 안드로이드, 자바스크립트

import java.util.Random;

public class Test04_1 {

	public static void main(String[] args) {
		
		// List에 값 입력
		// - 배열처럼 한번에 데이터까지 초기화하면서 생성
		
		// Java 8+
		//List<String> list = Arrays.asList("자바", "파이썬", "루비", "안드로이드", "자바스크립트");
		
		// Java 9+
		List<String> list = List.of("자바", "파이썬", "루비", "안드로이드", "자바스크립트");
		
		// 난수 생성
		Random r = new Random();
		int numR = r.nextInt(list.size());
		
		// 추첨 출력
		System.out.println(list.get(numR));
		
	}
}
