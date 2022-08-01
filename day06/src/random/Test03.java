package random;

//랜덤으로 구구단 문제를 하나 출제하고 사용자가 정답을 입력하면 정답과 오답을 판정하는 프로그램을 구현하세요
//단, 문제는 2x1부터 9x9까지의 범위 내에서 출제해야 합니다

import java.util.Random;
import java.util.Scanner;

public class Test03 {
	public static void main(String[] args) {
		
		Random r = new Random();
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			int first = r.nextInt(8) + 2;		//2부터 9까지
			int second = r.nextInt(9) + 1;		//1부터 9까지
			
			System.out.print(first + " X " + second + " = ");
			
			int me = sc.nextInt();
			if(me == first * second) {
				System.out.println("정답");
				break;
			}
			else {
				System.out.println("오답");
			}
		}
		
		sc.close();
		
	}

}
