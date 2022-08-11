package api.lang.String;

import java.util.Scanner;

// 욕설 필터링 프로그램
// 사용자에게 입력받은 문자열 중에서 욕설에 해당하는 단어를 블라인드(**) 처리하도록 구현

// ** 문자열을 띄어쓰기까지 입력받는 명령 : String text = sc.nextLine();

// 실제 욕 대신 욕같은 단어로 대채합니다
// 신발, 수박, 시베리아, 십장생, 개나리, 주옥, 조카, 시방, 된장, 십자수

// - 블라인드 처리시 별 개수는 3개로 고정합니다

// (추가) 필터링할 때 별 개수(*)를 단어 글자 수와 맞추세요

public class Test06_me {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// 입력 - 띄어쓰기를 포함하도록 ( sc.nextLine() )
		String text = sc.nextLine();
		
		// 바꾸기 전 출력
		System.out.println(text);
		
		// 욕설 목록
		String[] array = new String[] {"신발", "수박", "시베리아", "십장생", "개나리", "주옥", "조카", "시방", "된장", "십자수"};
		
		// 배운 것 정리
		// 글자수 출력 - .length()
		// 글자 포함 판정 - .contains​(CharSequence s)
		// 한 글자 추출 명령 .charAt​(int index)
		// 문자열의 일부 추출 : .substring​(int beginIndex, int endIndex)
		// 문자열 반복 : .repeat​(int count)
		// 문자열 치환 : .replace​(CharSequence target, CharSequence replacement)
		
		// 필터링
		String star = "*";
		String starFixed;
		for(int i = 0 ; i < array.length ; i ++) {
			if(text.contains(array[i])) {		// array[i]의 욕이 들어있다면 (contains)
				
				// 해당 욕설의 갯수만큼 별(*)을 만듬
				starFixed = star.repeat(array[i].length());
				
				// 해당 욕설을 fix로 치환(replace) - 별의 갯수는 starFixed (array[i].length 개)
				text = text.replace(array[i], starFixed);	// 바꾼 데이터를 기존 데이터에 덮어쓰기 한다
			}
		}
		
		// 바꾼 후 출력
		System.out.println(text);
	}
}
