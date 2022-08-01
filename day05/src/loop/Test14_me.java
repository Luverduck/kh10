package loop;

//구구단
//숫자 입력시 해당 숫자의 x9까지
// 5 X 1 = ? (?에 사용자가 정답 입력하게 한다)
// 5 X 2 = ?
// 5 X 3 = ?
// 5 X 4 = ?
// 5 X 5 = ?
// 5 X 6 = ?
// 5 X 7 = ?
// 5 X 8 = ?
// 5 X 9 = ?
//끝날 때 정답 ?개 / 오답 ?개

import java.lang.*;

import java.util.Scanner;

public class Test14_me {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자를 입력하세요 : ");
		int num = sc.nextInt();
		
		int countO = 0;
		int countX = 0;
		for(int i=1; i<=9; i++) {
			System.out.print(num + " x " + i + " = : ");
			int ans = sc.nextInt();
			if(ans == num * i) {
				countO++;
			}
			else {
				countX++;
			}
		}
		sc.close();
		
		System.out.println();
		
		System.out.println("결과");
		System.out.println("맞은 갯수 : " + countO);
		System.out.println("틀린 갯수 : " + countX);
		
	}
}
