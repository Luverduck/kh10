package api.util.collection2;

import java.util.Iterator;
import java.util.Scanner;

//사용자에게 글 번호를 입력받아 해당하는 번호의 게시물에 좋아요를 설정/해제하는 프로그램을 구현하세요
//요구사항
//- 사용자에게 글 번호를 입력받는다
//- 글 번호를 Set을 이용하여 저장하거나 삭제하도록 구현한다
//- 좋아요를 누른 적이 없는 글 번호가 입력된 경우 ?번 글에 좋아요를 눌렀습니다 출력 후 저장소에 번호를 저장한다
//- 좋아요를 누른 적이 있는 글 번호가 입력된 경우 ?번 글에 좋아요를 취소했습니다 출력 후 저장소에서 번호를 제거한다
//- 0을 입력하면 프로그램을 종료하고 종료 직전까지 좋아요를 누른 모든 게시글의 번호를 오름차순으로 출력한다.

import java.util.Set;
import java.util.TreeSet;

public class Test03_2 {

	public static void main(String[] args) {
		
		Set<Integer> like = new TreeSet<>();		// Set은 인터페이스라서 인스턴스 생성 불가, TreeSet은 구현체
		
		Scanner sc = new Scanner(System.in);
		
		// 반복 -> 0을 입력할 때까지
		while(true) {
			System.out.print("번호 : ");
			int number = sc.nextInt();
			
			if(number == 0) {			// 만약 number가 0이라면 (0번 게시글에 좋아요를 출력하지 않기 위해 앞에 씀)
				break;					// 구문 탈출
			}
			
			if(like.contains(number)) {	// 만약 number가 있다면
				like.remove(number);	// 지우고
				System.out.println(number + "번 게시글에 좋아요를 취소했습니다");
			}
			
			else {						// 그렇지 않다면
				like.add(number);		// 추가
				System.out.println(number + "번 게시글에 좋아요를 눌렀습니다");
			}
		}
		
		// 목록 출력
		//System.out.println(like);	// Set의 모양으로 출력
		
		// Set의 값을 하나씩 빼서 출력하는 방법??
		// 개별 접근은 불가능하지만 전체를 다 추출하는 것은 가능하다
		// 1. Iterator(반복자) 라는 별개의 저장소로 이동
		// - .hasNext() : 포함 여부 판정
		// - .next() : 공백 전까지의 값을 반환
		Iterator<Integer> iter = like.iterator();
		while(iter.hasNext()) {
			int number = iter.next();
			System.out.println(number);
			//System.out.println(iter.next());
		}
		
		// 2. 확장형 for 구문 사용 -> List, Set 뿐만 아니라 배열에서도 가능
		//for(like에 있는 데이터 갯수만큼 몽땅) {
		for(int number : like) {	//like에 있는 데이터 갯수만큼 몽땅
			System.out.println(number);
		}
		
		// 3. 배열로 복사하거나 List로 복사 (비추천 - 메모리 낭비가 심함)
		
		sc.close();
	}
}
