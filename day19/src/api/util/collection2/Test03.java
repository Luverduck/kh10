package api.util.collection2;

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

public class Test03 {

	public static void main(String[] args) {
		
		Set<Integer> like = new TreeSet<>();		// Set은 인터페이스라서 인스턴스 생성 불가, TreeSet은 구현체
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("번호 : ");
		int number = sc.nextInt();
		
		sc.close();
		
		if(like.contains(number)) {	// 만약 number가 있다면
			like.remove(number);	// 지우고
			System.out.println(number + "번 게시글에 좋아요를 취소했습니다");
		}
		
		else {						// 그렇지 않다면
			like.add(number);		// 추가
			System.out.println(number + "번 게시글에 좋아요를 눌렀습니다");
		}
	}
}
