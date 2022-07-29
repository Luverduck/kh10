package loop;

import java.lang.*;

public class Test05 {
	public static void main(String[] args) {//main 쓰고 ctrl + space
		
		//(Q) 1부터 100까지 짝수/홀수를 출력
		
		//홀수 : 1, 3, 5, 7, 9, ...
		for(int i=1; i<=100; i=i+2){ //50번 실행 -> 규칙적인 상황에 유리 (사람이 증가폭 등의 요소를 고민해야함)
			System.out.print("홀수 = ");
			System.out.print(i + ",");
		}
		
		for(int i=1; i<=100; i=i+1) { //100번 실행 + 조건 검사 -> 복잡한 상황에 유리 (조건을 잘 설정하면 작업이 쉬움)
			if(i % 2 == 1) {
				System.out.print("홀수 = ");
				System.out.print(i + ",");
			}
		}
		
		//짝수 : 2, 4, 6, 8, ...
		for(int i=2; i<=100; i=i+2) {
			System.out.print("짝수 = ");
			System.out.print(i + ",");
		}
		
		for(int i=1; i<=100; i=i+1) {
			if(i % 2 == 0) {
				System.out.print("홀수 = ");
				System.out.print(i + ",");
			}
		}
		
	}

}
