package loop4;

import java.util.Scanner;

public class Test01 {
	
	public static void main(String[] args) {
		
		//do ~ while 반복문
		//- 사용 빈도가 매우 낮음
		//- 선 실행, 후 검사
		//- do로 입력을 먼저 받은 후 잘못 입력하면 while의 조건에 맞게 다시 입력
		
		//ex) 0부터 100 사이의 숫자(올바른 점수)가 입력되면 종료하는 반복문
		Scanner sc = new Scanner(System.in);
		
		//do ~ while의 문제점
		int score;
		do {	
			System.out.print("점수 : ");
			score = sc.nextInt();			//1. do 안에서 만든 변수 score를 while에서 못쓴다
		}
		while(score < 0 || score > 100);	//2. while 끝에 세미콜론(;)을 반드시 써야 한다 (if나 while은 안씀)
		//잘못 입력했다면
		
		//3. while문으로 완전히 대체할 수 있다
		//int score1;
		//while(true) {
		//	System.out.print("점수 : ");
		//	score1 = sc.nextInt();
			
		//	if(score1 >= 0 && score1 <= 100) {
		//		break;
		//	}
		//}
		
		System.out.println("입력된 점수는 " + score + "점 입니다");
		
		sc.close();
		
	}

}
