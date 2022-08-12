package exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Test04 {

	public static void main(String[] args) {
		
		//(Q) 예외를 통합처리 했을 때 무슨 작업을 해야 하는가? 각각의 예외에 대해 구분은 가능한가?
		
		try {	// 아무 문제 없을 때 실행될 코드 (Plan A)
			Scanner sc = new Scanner(System.in);
		
			System.out.print("술값 : ");
			int total = sc.nextInt();
		
			System.out.print("인원 : ");
			int people = sc.nextInt();
		
			sc.close();
		
			int price = total / people;
			int etc = total % people;
		
			System.out.println("1인당 " + price + "원");
			System.out.println("자투리 " + etc + "원");
		}
		
		// 예외 구분을 원한다면 instanceOf 대신 catch를 하나 더 만드느 것이 좋다
		catch(ArithmeticException e) {
			
		}
		
		// 예외 통합처리 구문
		catch(Exception e) {	// Plan B
			//System.err.println("에러 발생");
			//System.err.println(e);	// 예외 정보가 담긴 객체
			  // 1) 예외의 이름
			  // 2) 예외의 내용(안나올수도 있음)
			//System.err.println(e.getClass()); 		// 예외 클래스 정보	
			//System.err.println(e.getMessage()); 		// 예외 메세지 정보 (사용자에게 보여줄만한 에러의 정보, 없을 수도 있음)
			
			//instanceOf 사용 가능하지만 예외를 통합처리하기로 했으므로 사용하지 않음
			if(e.getMessage() == null) {
				System.err.println("오류 발생");
			}
			else {
				System.err.println("오류 발생 : " + e.getMessage());
			}
			
			// 예외처리를 하지 않은 것처럼 stack trace를 출력하고 싶을 수도 있다
			//e.printStackTrace(); -	> 개발이 끝나면 삭제
		}
	}
}
