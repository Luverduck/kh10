package exception;

import java.util.Scanner;

public class Test08_1 {

	public static void main(String[] args) {
		
		try(Scanner sc = new Scanner(System.in);)
		{
			Student s = new Student();
			
			System.out.print("이름 : "); 	s.setName(sc.next());
			System.out.print("국어 : "); 	s.setKorean(sc.nextInt());
			System.out.print("영어 : "); 	s.setEnglish(sc.nextInt());
			System.out.print("수학 : "); 	s.setMath(sc.nextInt());
			
			System.out.println(s.toString());
		}
		
		catch(Exception e) {
			//System.err.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
