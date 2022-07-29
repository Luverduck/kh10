package loop;

//타이머 만들기
//사용자가 분과 초를 설정하면 해당하는 시간만큼의 메세지 출력 후 종료되는 프로그램 구현
//'''
//분 입력 : 2
//초 입력 : 10
//'''

//2분 10초 남았습니다
//2분 9초 남았습니다
//...
//0분 2초 남았습니다
//0분 1초 남았습니다
//'''

import java.lang.*;

import java.util.Scanner;

public class Test04 {
	public static void main(String[] args) throws InterruptedException {
		
		Scanner sc = new Scanner(System.in);
		
		//준비 - 분, 초 입력
		System.out.print("분 입력 : ");
		int min = sc.nextInt();
		System.out.print("초 입력 : ");
		int sec = sc.nextInt();
		
		//계산
		int totalSec = min * 60 + sec; //시간 문제 기본 포멧
		
		//출력
		for(int i=totalSec ; i>=1 ; i=i-1) {
			System.out.println((i / 60) +"분 "+(i % 60) + "초 남았습니다");
			Thread.sleep(1000L);
		}
		
		sc.close();
		
	}

}
