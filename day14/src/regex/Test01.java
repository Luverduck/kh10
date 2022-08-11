package regex;

import java.util.regex.Pattern;

public class Test01 {

	public static void main(String[] args) {
	
		// 정규 표현식 (Regular Expression) 
		
		// (Q) phone의 값이 올바른 휴대전화번호인지 검사하시오
		// 올바른 형태 - 01X-XXXX-XXXX
		String phone = "010-1234-5678";
		
		//String regex = "^01[016789]-[123456789][0123456789][0123456789][0123456789]-[0123456789][0123456789][0123456789][0123456789]$";
		//String regex = "^01[016-9]-[1-9][0-9][0-9][0-9]-[0-9][0-9][0-9][0-9]$";
		//String regex = "^01[016-9]-[1-9][0-9]{3}-[0-9]{4}$";
		String regex = "^01[016-9]-[1-9][0-9]{2, 3}-[0-9]{4}$";			// 가운데가 3자리일 때(2)와 4자리일 때(3)
		
		// regex는 기준 데이터, phone은 검사할 데이터
		boolean test = Pattern.matches(regex, phone);
		
		System.out.println(test);
	}
}
