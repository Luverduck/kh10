package api.util.collection2;

//사용자에게 글 번호를 입력받아 해당하는 번호의 게시물에 좋아요를 설정/해제하는 프로그램을 구현하세요
//요구사항
//- 사용자에게 글 번호를 입력받는다
//- 글 번호를 Set을 이용하여 저장하거나 삭제하도록 구현한다
//- 좋아요를 누른 적이 없는 글 번호가 입력된 경우 ?번 글에 좋아요를 눌렀습니다 출력 후 저장소에 번호를 저장한다
//- 좋아요를 누른 적이 있는 글 번호가 입력된 경우 ?번 글에 좋아요를 취소했습니다 출력 후 저장소에서 번호를 제거한다
//- 0을 입력하면 프로그램을 종료하고 종료 직전까지 좋아요를 누른 모든 게시글의 번호를 오름차순으로 출력한다.

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Test03 {

	public static void main(String[] args) {
		
		// Set 생성
		Set<Integer> data = new TreeSet<>();
		
		// Scanner 인스턴스 생성
		Scanner sc = new Scanner(System.in);
		
		// 글 번호 저장
		int count = 0;
		while(true) {
			// 사용자 입력(글 번호)
			System.out.print("글 번호를 입력하세요 : ");
			int number = sc.nextInt();
			
			// 0을 입력할 때
			if(number == 0) {	 
				break;			// 구문 탈출 ('0번 글에 좋아요를 눌렀습니다'를 없애기 위해 순서를 앞으로 바꿈)
			}
			
			// 좋아요를 누른 적이 있다면 (이미 Set에 해당 글 번호가 있음)
			if(data.contains(number)) {	
				System.out.println(number + "번 글에 좋아요를 취소했습니다");
				System.out.println();
				data.remove(number);	// Set에 글 번호 제거
				count --;
			}
			
			// 좋아요를 누른 적이 없다면 (Set에 해당 글 번호가 없음)
			else {
				System.out.println(number + "번 글에 좋아요를 눌렀습니다");
				System.out.println();
				data.add(number);		// Set에 글 번호 추가
				count ++;
			}
		}
				
		System.out.println("count = " + count);
		// 출력 (Set은 어차피 오름차순으로 자동 정렬되어 출력한다)
		for(int i = 0 ; i < count ; i ++) {
			System.out.println(((TreeSet<Integer>) data).pollFirst());
		}
		
		sc.close();
	}
}
