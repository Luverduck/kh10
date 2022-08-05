package oop.modifier2;

import java.util.Scanner;

public class Test01 {

	public static void main(String[] args) {
		
		//객체 생성을 입력 후에 하는 방법
		
		Scanner sc = new Scanner(System.in);	//Scanner 사용 여부(입력을 줄지 말지)는 main 메소드에 작성한다
		
		System.out.print("이름 : ");
		String name = sc.next();
		
		System.out.print("학년 : ");
		int level = sc.nextInt();
		
		System.out.print("국어 점수 : ");
		int korean = sc.nextInt();
		
		System.out.print("영어 점수 : ");
		int english = sc.nextInt();
		
		System.out.print("수학 점수 : ");
		int math = sc.nextInt();
		
		sc.close();
		
		Score a = new Score(name, level, korean, english, math);
		
		a.print();
	}
}
