package random;

//업다운 게임
//숫자를 하나 정해두고 랜덤으로 1에서 1000 사이의 숫자를 하나 정합니다
//사용자가 범위 내에서 숫자를 입력합니다
//프로그램은 사용자가 입력한 값과 정답을 비교해서 업, 다운, 정답 세 개중 하나를 알려줍니다.
//- 업은 정답이 입력값보다 크다는 의미입니다.
//- 다운은 정답이 입력값보다 작다는 의미입니다.
//- 정답은 정답과 입력값이 같은 경우를 말하며, 게임이 종료되어야 합니다.
//업다운 게임을 구현하시고 정답을 맞추면 몇번 만에 맞췄는지 계산해서 출력해주세요.

import java.util.Random;
import java.util.Scanner;

public class Test07 {
	
	public static void main(String[] args) {
		
		Random r = new Random();
		
		int selected = r.nextInt(1000) + 1;
		//int selected = r.nextInt(900) + 100;	//100부터 999까지
		System.out.println(selected);			//테스트용 출력을 해볼 것
		
		Scanner sc = new Scanner(System.in);	//import 구문 자동완성 : ctrl + shift + 숫자 5
		//System.out.println(selected);
		int count = 0;
		while(true) {	//맞출 때까지 계속 반복해야 하므로 while 반복문 사용
			System.out.println("입력 (1~1000까지의 숫자 중 하나)");
			int me = sc.nextInt();
			
			count++;
			
			if(me > selected) {
				System.out.println("다운");
				System.out.println();
			}
			else if(me == selected) {
				System.out.println("정답");
				System.out.println();
				break;
			}
			else {
				System.out.println("업");
				System.out.println();
			}
		}
		
		sc.close();
		
		System.out.println("소요된 횟수 = " + count);
		
	}

}
