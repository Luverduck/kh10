package api.lang.String;

// 욕설 필터링 프로그램
// 사용자에게 입력받은 문자열 중에서 욕설에 해당하는 단어를 블라인드(**) 처리하도록 구현

// ** 문자열을 띄어쓰기까지 입력받는 명령 : String text = sc.nextLine();

// 실제 욕 대신 욕같은 단어로 대채합니다
// 신발, 수박, 시베리아, 십장생, 개나리, 주옥, 조카, 시방, 된장, 십자수

// - 블라인드 처리시 별 개수는 3개로 고정합니다

// (추가) 필터링할 때 별 개수(*)를 단어 글자 수와 맞추세요

public class Test06 {

	public static void main(String[] args) {
		
		// 입력
		String text = "이런 신발끈 개나리 같은 수박씨를 보았나";
		
		// 바꾸기 전 출력
		System.out.println(text);
		
		// 필터링
		//text = text.replace("신발", "**");
		//text = text.replace("개나리", "***");
		
		String[] filter = new String[] {"신발", "개나리"};
		//System.out.println(text.replace(filter[0], "**"));
		//System.out.println(text.replace(filter[1], "***"));
		
		for(int i = 0 ; i < filter.length ; i ++) {
			text = text.replace(filter[i], "***");
		}
		
		// 바꾼 후 출력
		System.out.println(text);
	}
}
