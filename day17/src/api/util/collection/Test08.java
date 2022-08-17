package api.util.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

// 네이버 사다리 만들기
// 네이버에서 '사다리 타기'를 검색하여 나오는 프로그램을 그래픽을 제외하고 구현

public class Test08 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// 참여 인원수
		System.out.print("참여 인원의 수 : ");
		int people = sc.nextInt();	// 인원수(반복횟수)
		sc.nextLine();	// 엔터 제거
		
		// 이름에 대한 List
		List<String> names = new ArrayList<>();
		
		// names에 입력 넣기
		for (int i = 1; i <= people; i++) {
			System.out.print(i + "번째 입력 : ");
			names.add(sc.nextLine());
		}
		
		System.out.println();
		
		// 행동에 대한 List
		List<String> actions = new ArrayList<>();
		
		// actions에 입력 넣기
		for(int i = 1 ; i <= people ; i ++) {
			System.out.print(i + "번째 입력 : ");
			actions.add(sc.nextLine());
		}
		
		System.out.println();
		
		// actions 셔플 (actions의 데이터 순서 섞기)
		Collections.shuffle(actions);
		
		// 출력
		for(int i = 0 ; i < names.size() ; i ++) {
			System.out.println(names.get(i) + " : " + actions.get(i));
		}
		
		sc.close();
	}
}
