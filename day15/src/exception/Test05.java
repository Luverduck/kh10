package exception;

import java.util.Scanner;
import java.util.regex.Pattern;

//다음 요구사항에 맞게 프로그래밍 하세요

//요구사항
//- 사용자에게 이름, 국어점수, 수학점수, 영어점수를 입력받아 총점과 평균을 구하는 프로그램을 만듭니다.
//- 사용자가 입력을 잘못한 경우 "잘못된 입력입니다. 처음부터 다시 진행해주세요." 라는 메세지를 출력하고 진행중인 프로그램을 종료합니다.
//- 다음 상황에 해당하지 않으면 입력을 잘못한 것으로 간주합니다.
//  - 이름은 한글로 2글자 이상 7글자 이하로 작성해야 합니다.
//  - 점수는 모두 0점이상 100점 이하의 정수인 경우만 가능합니다.
//- 입력이 정상적으로 진행된 경우에는 이름, 총점, 평균을 출력해주세요.

public class Test05 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// 입력 규칙 정규표현식
		String regexName = "^[가-힣]{2,7}$";
		String regexKorean = "^([0-9]|1[0-9]|2[0-9]|3[0-9]|4[0-9]|5[0-9]|6[0-9]|7[0-9]|8[0-9]|9[0-9]|100)$";
		String regexMath = "^([0-9]|1[0-9]|2[0-9]|3[0-9]|4[0-9]|5[0-9]|6[0-9]|7[0-9]|8[0-9]|9[0-9]|100)$";
		String regexEnglish = "^([0-9]|1[0-9]|2[0-9]|3[0-9]|4[0-9]|5[0-9]|6[0-9]|7[0-9]|8[0-9]|9[0-9]|100)$";
		
		try {
			// 입력
			System.out.print("이름 입력 : ");
			String name = sc.next();
			System.out.println();
			
			System.out.print("국어성적 입력 : ");
			String korean = sc.next();
			System.out.println();
			
			System.out.print("수학성적 입력 : ");
			String math = sc.next();
			System.out.println();
			
			System.out.print("영어성적 입력 : ");
			String english = sc.next();
			System.out.println();
			
			
			if(Pattern.matches(regexName, name)&&Pattern.matches(regexKorean, korean)&&Pattern.matches(regexMath, math)&&Pattern.matches(regexEnglish, english)) {
			
				String passName = name;
				int passKorean = Integer.parseInt(korean);
				int passMath = Integer.parseInt(math);
				int passEnglish = Integer.parseInt(english);
				
				// 총점, 평균
				int sum = passKorean + passMath + passEnglish;
				double avg = sum / 3.0;
				
				// 정보 출력
				System.out.println("이름 : " + passName);
				System.out.println("총점 : " + sum);
				System.out.println("평균 : " + avg);
			}
			else {
				// 1) 정수 1개를 추출한다 (예외를 강제로 일으키기 위함이므로 국어, 영어, 수학 성적중 아무거나 상관없다)
				int passKorean = Integer.parseInt(korean);
				
				// 2) 예외를 발생시키기 위해 추출한 정수를 0으로 나눈다 (억지로 에러를 발생시키는 방법 - 0으로 나누기)
				int errorMaker = passKorean / 0;
			}
		}
		
		catch(Exception e) {
			System.err.println("잘못된 입력입니다. 처음부터 다시 진행해주세요");
			System.exit(1);
		}
		
		sc.close();
	}
}
