package loop3;

import java.util.Scanner;

public class Test02 {

	public static void main(String[] args) {
		
		//while은 종료 시점(조건)을 알 때 유용하게 사용할 수 있다
		
		//ex) 사용자가 0을 입력할 때까지 숫자를 반복적으로 입력받는 프로그램
		
		//자동 import 단축키 : ctrl + shift + O
		Scanner sc = new Scanner(System.in);
		
		while(true) {	//while(true)는 무한 반복문 (반복이 끝나지않음)
			System.out.print("입력 : ");
			int number = sc.nextInt();
			
			if(number == 0) {	//만약 number가 0이라면
				break;			//나가기 (구문 탈출 명령)
			}
		}
		
		sc.close();
		
	}
	
}
