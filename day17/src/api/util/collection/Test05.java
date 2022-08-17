package api.util.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 기억력 테스트 게임
// 사용자에게 나라 이름을 입력받아 List에 저장하도록 구현
// 단, 입력한 적 있는 나라 이름을 다시 입력한 경우 입력을 중지하고 프로그램 종료
// 프로그램 종료 시 여태까지 입력한 나라 이름을 순서대로 출력하도록 구현

public class Test05 {

	public static void main(String[] args) {
		
		// List 생성
		List<String> list = new ArrayList<>();
		
		// Scanner 생성
		Scanner sc = new Scanner(System.in);
		
		// 반복문
		while(true) {
			
			// 나라 입력
			System.out.print("나라 이름 : ");
			String input = sc.next();		// 입력을 받은 후 바로 List에 넣지 말고 확인해보기
			
			if(list.contains(input)) {		// 기존 List에 이미 해당 입력이 포함되어 있으면
				break;						// 구문 종료
			}
			
			else {							// 그렇지 않다면
				list.add(input);			// 기존 List에 해당 입력을 추가
			}			
		}
		
		System.out.println();
		
		// 출력
		System.out.println("지금까지 입력한 나라");
		for(int i = 0 ; i < list.size() ; i ++) {
			System.out.println(list.get(i));
		}
	}
}
