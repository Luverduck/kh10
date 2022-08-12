package regex;

// 사용자에게 생년월일을 YYYY-MM-DD 형식으로 입력받아 올바른 날짜 형식인지 검사하세요
// 연도는 1900년부터 2099년까지 가능합니다
// 최초 검사식을 만들 때는 모든 달은 31일까지 있다고 가정하고 만듭니다
// 1번을 풀고 나서 큰달과 작은달을 구분해서 만듭니다(2월은 28일로 가정)
// 2번을 풀고 나서 윤년을 고려하도록 만듭니다

import java.util.regex.Pattern;

public class Test04 {

	public static void main(String[] args) {
		
		// 입력
		String data = "1992-03-20";
		
		// 생년월일 검사용 정규식
		String regex = "^(19[0-9]{2}|20[0-9]{2})-(0[1-9]|1[0-2])-(0[1-9]|1[1-9]|2[1-9]|3[0-1])$";
		
		// 판정
		boolean check = Pattern.matches(regex, data);
		
		// 출력
		System.out.println(check);
	}
}
