package regex;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Test03 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// 닉네임 생성 규칙 정규표현식 
		String reg = "^[가-힣0-9]{2,10}$";
		
		// 닉네임 테스트용
		//String nickname = "ㅡㅡ";
		
		// 닉네임
		String nickname = sc.next();
		
		sc.close();
		
		// 판정
		boolean test = Pattern.matches(reg, nickname);
		
		// 출력
		System.out.println(test);
		
		if(test) {
			System.out.println("멋진 닉네임이네요!");
		}
		else {
			System.out.println("닉네임은 한글 또는 숫자 2~10자 내외로 작성하세요");
		}
	}
}
