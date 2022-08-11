package api.lang.String;

// '바나나'라는 제시어가 주어져 있을 때
// 사용자에게 입력받은 글자가 제시어와 이어지는지 검사하여 출력하는 프로그램 구현

// (추가) 
// 반복적으로 수행하면 끝말잇기 혹은 쿵쿵따를 만들 수 있습니다
// 끝말잇기는 2글자 이상, 쿵쿵따는 반드시 3글자

import java.util.Scanner;

public class Test05_me {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("시작 단어를 입력해 주세요");
		String me = sc.next();		// 첫 번째 단어 입력
		
		while(true) {
			String you = sc.next(); 	// 두 번째 단어 입력
			
			boolean connect = me.charAt(me.length() - 1) == you.charAt(0);
			boolean textlimit = me.length() >= 2 && you.length() >= 2;
			
			if(connect && textlimit) {
				me = you;
			}
			else {
				System.out.print("다시 입력해주세요 ");
			}
		}
	}
}
