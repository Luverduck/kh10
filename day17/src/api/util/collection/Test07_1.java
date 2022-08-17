package api.util.collection;

//이번 주 로또 예상번호를 추첨하여 출력
//단, 번호는 낮은 것부터 

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Test07_1 {

	public static void main(String[] args) {
		
		// 1부터 45를 저장하고 섞은 뒤 6개를 추첨하는 방법
		
		// List 생성
		List<Integer> list = new ArrayList<>();
		
		// List에 1부터 45 입력
		for(int i = 1 ; i <= 45 ; i ++) {
			list.add(i);
		}
		
		// List 섞기 (셔플)
		Collections.shuffle(list);
		
		// 추첨한 숫자를 저장하기 위한 List 생성
		List<Integer> choice = new ArrayList<>();
		
		// 앞에서부터 숫자 6개를 추출해서 choice에 입력
		for(int i = 0 ; i < 6 ; i ++) {
			choice.add(list.get(i));	// choice.add(Object o) : List에 값 추가
		}								// list.get(int index) : List의 i번째 값 반환
		
		// 정렬 (오름차순)
		Collections.sort(choice);
		
		// 출력
		System.out.println(choice);
	}
}
