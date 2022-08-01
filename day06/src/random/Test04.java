package random;

//사용자가 3번 틀릴 때까지 무작위로 구구단 문제를 출제하는 프로그램을 구현하세요
//3번 틀리면 게임오버가 되며 그동안 맞춘 문제 개수가 출력되어야 합니다.

import java.util.Random;
import java.util.Scanner;

public class Test04 {
	
	public static void main(String[] args) {
		
		Random r = new Random();
		
		Scanner sc = new Scanner(System.in);
		
		int countO = 0;
		int countX = 3;	//누적 계산을 위한 데이터
		
		while(true) {
			
			int first = r.nextInt(9) + 1;
			int second = r.nextInt(9) + 1;
			
			System.out.print(first + " X " + second + " = ");
			int me = sc.nextInt();
			
			if(me == first * second) {
				countO += 1;	//countO는 맞춘 횟수를 의미
				System.out.println("정답, 남은 기회 : " + countX);
				System.out.println();
			}
			
			else {
				countX -= 1;	//countX는 틀린 횟수를 의미
				System.out.println("오답, 남은 기회 : " + countX);
				System.out.println();
			
				if(countX <= 0) {
					break;
				}
				
			}
			
		}
		
		sc.close();
		
		System.out.println("Game Over");
		System.out.println("맞춘 갯수 : " + countO);
		
		//System.out.println("Game Over!");
		
	}

}
