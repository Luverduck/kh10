package loop;

//오늘부터 30일간 다이어트를 하기로 했습니다
//매일매일 갯수를 늘려가면서 푸시업을 할 계획입니다.
//첫째날은 힘드니까 3개만 합니다.
//둘째날부터는 전날보다 3개씩 더 합니다.

//(1) 30일 동안 일자별로 하게 되는 푸시업 개수를 출력
//(2) 30일 동안 하게 되는 푸시업 개수의 총 합계를 출력

import java.lang.*;

public class Test12 {
	public static void main(String[] args) {
		
		int pushup = 3;
		int total = 0;
		for(int day=1; day<=30; day++) {
			System.out.println(day + "일자 - " + pushup + "개");
			total += pushup; // total을 pushup 개수만큼 증가시켜라
			pushup += 3; //첫날부터 0개가 되게 하기 위해서 아랫줄에 입력 (컴퓨터는 순서대로 처리한다)
		}
		
		System.out.println("총 갯수 : " + total + "개");
		
		System.out.println();
		System.out.println();
		System.out.println();
		
		
		for(int i=1; i<=30; i++) {
			int num = 0;									//일자별로 하나씩 나열하기 위해 안에 정의
			num = 3*i;
			System.out.println(i + "일 : " + num + "개");	//일자별로 출력하려고 할 때는 for 내부에서 출력
		}
		
		int sum = 0;										//계산해서 최종 출력을 내기 위해 밖에 정의
		for(int i=1; i<=30; i++) {
			sum += 3*i;		
		}
		System.out.println("총 갯수 : " + sum + "개");		//최종적으로 한번만 출력하고자 할 때는 for 외부에 출력
				
		
	}

}
