package api.util.collection;

//이번 주 로또 예상번호를 추첨하여 출력
//단, 번호는 낮은 것부터 

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Test07 {

	public static void main(String[] args) {
		
		// List 생성
		List<Integer> list = new ArrayList<>();
		
		// 번호 추첨
		Random r = new Random();
		for(int i = 0 ; i < 6 ; i ++) {
			int numR = r.nextInt(45) + 1;	// 1 ~ 45 중 하나 생성
			if(list.contains(numR)) {		// 기존 배열에 생성값이 존재한다면
				i --;						// 반복수 -1 (되감기)
			}
			else {							// 그렇지 않다면
				list.add(numR);				// List에 해당 숫자 대입
			}
		}
		
		// 정렬 (오름차순)
		Collections.sort(list);
		
		// 출력
		System.out.println(list);
	}
}
