package oop.modifier2;

import java.util.Scanner;

public class Test02 {

	public static void main(String[] args) {
		
		//객체를 먼저 생성하는 경우
		Score a = new Score();
		
		Scanner sc = new Scanner(System.in);	//Scanner 사용 여부(입력을 줄지 말지)는 main 메소드에 작성한다
		
		System.out.print("이름 : ");
		a.setName(sc.next());
		
		System.out.print("학년 : ");
		a.setLevel(sc.nextInt());
		
		System.out.print("국어 점수 : ");
		a.setKorean(sc.nextInt());
		
		System.out.print("영어 점수 : ");
		a.setEnglish(sc.nextInt());
		
		System.out.print("수학 점수 : ");
		a.setMath(sc.nextInt());
		
		sc.close();
		
		a.print();
	}
}
