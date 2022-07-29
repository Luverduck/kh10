package loop;

//369 게임
//다음 규칙에 따라 369 게임을 시뮬레이션 하세요
//-1부터 순차적으로 숫자가 증가하여 출력됨
//-3 또는 6 또는 9가 들어있는 숫자라면 해당 숫자 갯수만큼 "짝"이라고 출력
//-ex) 36 - 짝짝, 35 - 짝
//-범위는 99까지 출력합니다

import java.lang.*;

import java.util.Scanner;

public class Test07 {
	public static void main(String[] args) {
		
		//1의 자리에 3, 6, 9일 때 짝
		//1의 자리와 10의 자리 모두가 3, 6, 9일 때 짝짝
		
		
		for(int i=1; i<=99; i++) {
			if(i / 10 == 3 || i / 10 == 6 || i / 10 == 9) {//10의 자리가 3, 6, 9인 경우
				if(i % 10 == 3 || i % 10 == 6 || i % 10 == 9) {//그 경우 중 1의 자리가 3, 6, 9인 경우
					System.out.print("짝짝, ");
				}
				else {//10의 자리에 3, 6, 9가 있는 경우 중 1의 자리에는 3, 6, 9가 아닌 경우
					System.out.print("짝, ");	
				}
			}
			else if(i % 10 == 3 || i % 10 == 6 || i % 10 == 9) {
				System.out.print("짝, ");	
			}
			else {
				System.out.print(i + ", ");
			}
				
		}
		//부족했던 점
		//일의 자리가 3,6,9인 중복코드 발생
		//boolean으로 논리를 따로 빼두면 아래처럼 더 간결
		
		System.out.println();
		System.out.println();
		System.out.println();
		
		for(int i=1; i<=99; i++) {
			
			//십의 자리
			boolean ten = i / 10 == 3 || i / 10 == 6 || i / 10 == 9;
			boolean one = i % 10 == 3 || i % 10 == 6 || i % 10 == 9;
			
			if(ten && one) {
				System.out.print("짝짝, ");
			}
			else if(ten || one) {
				System.out.print("짝, ");
			}
			else {
				System.out.print(i + ", ");
			}
		}
	
		
	}

}
