package regex;

// 사용자에게 생년월일을 YYYY-MM-DD 형식으로 입력받아 올바른 날짜 형식인지 검사하세요
// 연도는 1900년부터 2099년까지 가능합니다
// 최초 검사식을 만들 때는 모든 달은 31일까지 있다고 가정하고 만듭니다
// 1번을 풀고 나서 큰달과 작은달을 구분해서 만듭니다(2월은 28일로 가정)
// 2번을 풀고 나서 윤년을 고려하도록 만듭니다

import java.util.regex.Pattern;

public class Test04_2 {

	public static void main(String[] args) {
		
		// 입력
		String data = "1992-02-29";
		
		// 년도 추출
		//System.out.println(data.substring(5, 7));
		String year = data.substring(0, 4);		// 2022인 문자열을 숫자로 바꿔야 한다 - Integer.parseInt​(String s)
		int yearValue = Integer.parseInt(year);
		
		// 윤년 판정
		boolean leapYear = yearValue % 4 == 0 && yearValue % 100 != 0 && yearValue % 400 == 0;
		
		// 생년월일 검사용 정규식 (2월은 28일)
		String regex;
		if(leapYear) {
			regex = "^(19[0-9]{2}|20[0-9]{2})-(02-(0[1-9]|1[0-9]|2[0-9])|(0[469]|11)-(0[1-9]|1[0-9]|2[0-9]|30)|(0[13578]|1[02])-(0[1-9]|1[0-9]|2[0-9]|3[01]))$";
		}
		else {
			regex = "^(19[0-9]{2}|20[0-9]{2})-(02-(0[1-9]|1[0-9]|2[0-8])|(0[469]|11)-(0[1-9]|1[0-9]|2[0-9]|30)|(0[13578]|1[02])-(0[1-9]|1[0-9]|2[0-9]|3[01]))$";
		}
		
		// 판정
		boolean check = Pattern.matches(regex, data);
		
		// 출력
		System.out.println(check);
	}
}
