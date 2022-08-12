package exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Test03 {
	public static void main(String[] args) {
		//(Q) 예외의 종류가 너무 많으므로 통합하여 처리할 수 있는가?
		
		try {//아무 문제 없을 때 실행될 코드(Plan A)
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
		//catch(RuntimeException e) {//RuntimeException에 대한 Plan B
		catch(Exception e) {//Exception에 대한 Plan B
		//catch(Throwable e) {//Throwable에 대한 Plan B
		//catch(Object e) {//error
			System.err.println("에러 발생");
		}
	}
}
