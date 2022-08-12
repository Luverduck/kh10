package regex;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Test02 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// id 생성 규칙 정규표현식
		String reg = "^[a-z][a-z0-9]{7,19}$";
		
		// id 입력 테스트용
		//String id = "Qsasdsdjkfl";
		
		// id 입력
		String id = sc.next();
		
		sc.close();
		
		// 판정
		boolean test = Pattern.matches(reg, id);	// 왼쪽 : 검사식, 오른쪽 : 검사값 (순서를 지킬 것)
		
		// 결과 출력
		System.out.println(test);
		
		if(test) {
			System.out.println("멋진 아이디네요!");
		}
		else {
			System.out.println("아이디는 영문 소문자로 시작하며 숫자를 포함한 8~20자 이내");
		}
		
	}
}
