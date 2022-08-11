package api.lang.String;

// '바나나'라는 제시어가 주어져 있을 때
// 사용자에게 입력받은 글자가 제시어와 이어지는지 검사하여 출력하는 프로그램 구현

// (추가) 
// 반복적으로 수행하면 끝말잇기 혹은 쿵쿵따를 만들 수 있습니다
// 끝말잇기는 2글자 이상, 쿵쿵따는 반드시 3글자

import java.util.Scanner;
import java.util.Random;

public class Test05_1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		//준비
		String[] words = new String[] {
				"바나나", "타이어", "카센터", "사거리", "신발끈"
		};
		
		Random r= new Random();
		int index = r.nextInt(words.length);
		String given = words[index];
		
		while(true) {
			System.out.print(given + "! 쿵쿵따! ->");
			String input = sc.next();
			
			//계산
			//- given과 input이 이어집니까? - .charAt() 사용
			boolean good = given.charAt(given.length() - 1) == input.charAt(0);
			//good = good && input.length() == 3;
			good &= input.length() == 3;
			
			//출력
			if(good) {
				//System.out.println("이어져");
				given = input; 	//제시어 교체
			}
			else {
				//System.out.println("안이어져");
				break;
			}
		}
		
		sc.close();
	}
}
