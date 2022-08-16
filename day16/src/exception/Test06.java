package exception;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Test06 {
	public static void main(String[] args) {
		
		// try ~ with 구문 (Java 8+)
		// - 자동 close를 수행하는 try 구문
		// - 기존 try 구문에 resource를 선언하는 구역이 추가되었다
		// - close()가 가능한 객체를 선언하면 자동으로 try 종료 시 close()를 수행
		// - AutoClosable의 자식 클래스만 선언 가능
		// (주의) TRY 종료 후에도 사용하고 싶을 경우 (close를 하기 싫을 경우) 사용하면 안됨
		
		try(// resource
			Scanner sc = new Scanner(System.in);	// AutoClosable 인터페이스가 있으므로 가능
			// Random r = new Random();				// AutoClosable 인터페이스가 없으므로 입력 불가
		) {// Plan A
			
			System.out.print("이름 : ");
			String name = sc.next();
			if (!Pattern.matches("^[가-힣]{2,7}$", name)) {
				// catch로 강제 이동시키는 코드
				// throw new Exception();
				throw new Exception("이름은 한글 2~7글자로 작성해야 합니다");
			}

			System.out.print("국어 : ");
			int korean = sc.nextInt();
			if (korean < 0 || korean > 100) {
				// throw new Exception();
				throw new Exception("국어점수는 0~100점으로만 설정 가능합니다");
			}

			System.out.print("영어 : ");
			int english = sc.nextInt();
			if (english < 0 || english > 100) {
				throw new Exception("영어점수는 0~100점으로만 설정 가능합니다");
			}

			System.out.print("수학 : ");
			int math = sc.nextInt();
			if (math < 0 || math > 100) {
				throw new Exception("수학점수는 0~100점으로만 설정 가능합니다");
			}

			int total = korean + english + math;
			float average = total / 3f;

			System.out.println("이름 : " + name);
			System.out.println("총점 : " + total + "점");
			System.out.println("평균 : " + average + "점");
		}

		catch (Exception e) {// Plan B
			if (e.getMessage() == null) {
				System.err.println("입력이 잘못되었습니다");
			} else {
				System.err.println("오류 : " + e.getMessage());
			}
		}

	}
}