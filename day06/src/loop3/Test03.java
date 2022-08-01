package loop3;

//숫자 모래성 게임
//사용자에게 숫자를 입력받아서 입력한 숫자만큼 100에서 차감합니다
//계속적으로 입력을 받아서 감소시키다가 숫자가 음수가 되는 순간 게임 오버 메세지를 띄우고 종료
//게임오버 전까지 입력한 숫자의 갯수 출력

import java.util.Scanner;

public class Test03 {
	
	public static void main(String[] args) {
		
		int remain = 100;		//초기 남은 숫자
		System.out.println("초기 점수 : " + remain);
		
		Scanner sc = new Scanner(System.in);
		
		int count = 0;			//입력한 숫자의 갯수를 카운트하기 위한 변수
		while(true) {
			//System.out.println("남은 점수 : " + remain);
			System.out.print("입력 : ");
			int input = sc.nextInt();
			
			remain -= input;	//input의 값을 remain에서 빼는 연산
			count ++;			//입력한 숫자의 갯수 카운트
			
			System.out.println();
			
			if(remain < 0) {	//만약 remain이 0보다 작거나 같으면
				break;			//종료 (구문 탈출)
			}
			//else {			//else에 카운트를 하면 게임오버 직전 입력도 입력으로 포함하여 입력 숫자 횟수가 출력된다
				//count++
			//}
		}
		
		sc.close();	//무한 반복하는 while문에서 close를 쓰기 위해서는 종료 조건을 명시해야한다

		System.out.println("Game Over!");
		System.out.println("총 입력 횟수 : " + count);
		
	}

}
