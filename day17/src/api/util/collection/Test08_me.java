package api.util.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

// 네이버 사다리 만들기
// 네이버에서 '사다리 타기'를 검색하여 나오는 프로그램을 그래픽을 제외하고 구현

public class Test08_me {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// 참여 인원수
		System.out.print("참여 인원의 수 : ");
		int num = sc.nextInt();
		
		// list1
		List<String> list1 = new ArrayList<>();
		
		// list2 (셔플용)
		List<String> list2 = new ArrayList<>();
		
		// list1에 입력 넣기
		for(int i = 1 ; i <= num ; i ++) {
			System.out.print(i + "번째 입력 : ");
			list1.add(sc.next());
		}
		
		System.out.println();
		
		// list2에 입력 넣기
		for(int i = 1 ; i <= num ; i ++) {
			System.out.print(i + "번째 입력 : ");
			list2.add(sc.next());
		}
		
		System.out.println();
		
		// list2 셔플 (list2의 순서 섞기)
		Collections.shuffle(list2);
		
		// 출력
		for(int i = 0 ; i < list1.size() ; i ++) {
			System.out.println(list1.get(i) + " : " + list2.get(i));
		}
		
		sc.close();
	}
}
