package exception;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Test05_5 {

	public static void main(String[] args) {
		
		// 이름, 국어점수, 영어점수, 수학점수를 입력받아 총점과 평균을 계산하는 프로그램
		
		try {
			Scanner sc = new Scanner(System.in);
			
			System.out.print("이름 : ");
			String name = sc.next();
			if(!Pattern.matches("[가-힣]{2,7}", name)) {
				//throw new Exception();	// 강제로 예외 발생 (catch로 강제 이동시키는 코드)
				
				//throw new Exception(String str); 이용
				throw new Exception("이름은 한글 2~7글자로 작성해야 합니다");
			}
			
			System.out.print("국어 : ");
			int korean = sc.nextInt();
			if(korean < 0 || korean > 100) {
				//throw new Exception();	// 강제로 예외 발생 (catch로 강제 이동시키는 코드)
				
				//throw new Exception(String str); 이용
				throw new Exception("국어 점수는 0~100점으로만 설정 가능합니다");
			}
			
			System.out.print("수학 : ");
			int math = sc.nextInt();
			if(math < 0 || math > 100) {
				//throw new Exception();	// 강제로 예외 발생 (catch로 강제 이동시키는 코드)
				
				//throw new Exception(String str); 이용
				throw new Exception("수학 점수는 0~100점으로만 설정 가능합니다");
			}
			
			System.out.print("영어 : ");
			int english = sc.nextInt();
			if(english < 0 || english > 100) {
				//throw new Exception();	// 강제로 예외 발생 (catch로 강제 이동시키는 코드)
				
				//throw new Exception(String str); 이용
				throw new Exception("영어 점수는 0~100점으로만 설정 가능합니다");
			}
			
			sc.close();
			
			int total = korean + math + english;
			float average = total / 3f;
			
			System.out.println("이름 : " + name);
			System.out.println("총점 : " + total + "점");
			System.out.println("평균 : " + average + "점");
		}
		
		catch(Exception e) {
			// 상황에 따라 다른 예외처리 메세지를 입력하는 방법 - .getMessage()
			if(e.getMessage() == null) {	// null은 equals가 불가능하다
				System.err.println("입력이 잘못되었습니다");
			}
			else {
				System.err.println("오류 : " + e.getMessage());
			}
		}
	
	}
}
