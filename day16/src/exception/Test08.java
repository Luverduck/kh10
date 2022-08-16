package exception;

import java.util.Scanner;

public class Test08 {

	public static void main(String[] args) {
		
		try(Scanner sc = new Scanner(System.in);)
		{
			System.out.print("이름 : ");	String name = sc.next();
			System.out.print("국어 : "); int korean = sc.nextInt();
			System.out.print("영어 : "); int english = sc.nextInt();
			System.out.print("수학 : "); int math = sc.nextInt();
			
			Student s = new Student(name, korean, english, math);
			System.out.println(s.toString());	
		}
		
		catch(Exception e) {
			//System.err.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
