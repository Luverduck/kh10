package loop;

import java.util.Scanner;

public class Test14 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("단수 : ");
		int dan = sc.nextInt();
		
		//정답과 오답을 카운트하는 변수를 생성
		int countO = 0;
		int countX = 0;
		
		for(int i= 1 ; i <= 9 ; i++) {
		
			System.out.print(dan + " X " + i + " = ");
			int user = sc.nextInt();
			
			if(dan * i == user) {
				//System.out.println("정답");
				countO++;
			}
			
			else {
				//System.out.println("오답");
				countX++;
			}
			
		}
		
		sc.close();
		
		System.out.println("정답 : " + countO + "개");
		System.out.println("오답 : " + countX + "개");
	}

}
