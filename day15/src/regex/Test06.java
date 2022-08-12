package regex;

import java.util.regex.Pattern;

public class Test06 {

	public static void main(String[] args) {
		
		// 반드시 1개 이상 포함되는 경우에 대한 처리
		
		// 입력한 비밀번호
		String password = "Hello1234!@#$";
		
		// 비밀번호 생성 규칙에 대한 정규표현식
		String regex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[!@#$])[A-Za-z0-9!@#$]{8,16}$";
		
		// 판정
		boolean check = Pattern.matches(regex, password);
		
		// 결과
		System.out.println("결과 : " + check);
		
		
		// 긍정 탐색 : ^(?=.*[A-Z])[A-Za-z0-9!@#$]{8,16}$	뒤에 나오는 문자 중 반드시 A-Z중 하나는 나오도록 한다
		// 부정 탐색 : ^(!=.*[A-Z])[A-Za-z0-9!@#$]{8,16}$	뒤에 나오는 문자 중 반드시 A-Z중 하나도 나오지 않도록 한다
		
		// ^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[!@#$])[A-Za-z0-9!@#$]{8,16}$
		// 뒤에 나오는 문자에 [A-Z] 중 하나, [a-z] 중 하나, [0-9] 중 하나, !@#$ 중 하나가 반드시 나와야 한다
		
	}
}
