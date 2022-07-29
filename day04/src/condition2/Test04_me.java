package condition2;

//사용자에게 연도와 월을 입력받아서 날짜 수를 구하는 프로그램을 구현
//윤년은 다음과 같은 규칙에 의해서 정해진다
//-1년은 정확히 365일이 아니라 365.24xxx일이다
//-대충 4년정도면 하루 조금 모자라게 시간이 늘어난다 (4년에 약 하루 정도 늘어난다)
//-4년마다 하루를 더 주면 시간이 약간 느려진다
//-100년마다 하루를 덜 주고
//-400년마다 하루를 더 주면 정확히는 아니어도 날짜가 엇비슷해진다

//정리하면
//1. 연도가 4의 배수이면 윤년이다 (ex : 2020, 2024, 2028년은 윤년)
//2. 4의 배수이지만 100의 배수이면 윤년이 아니다 (ex : 2100년은 윤년이 아니다)
//3. 2번에 해당되더라도 400의 배수이면 윤년이다 (ex : 2000년은 윤년)

import java.lang.*;

import java.util.Scanner;

public class Test04_me {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("년도를 입력하세요");
		int year = sc.nextInt();
		
		System.out.println("월을 입력하세요");
		int month = sc.nextInt();
		
		sc.close();
		
		//int year = 2000;
		
		int logic1 = year % 4;
		
		
		int logic3TF;
		switch(logic1) {
		case 0:
			int logic2 = year % 100;
			switch(logic2) {
			case 0:
				if(year % 400 == 0) {
					System.out.println(year + "년은 윤년이 맞습니다");
					logic3TF = 1;
				}
				else {
					System.out.println(year + "년은 윤년이 아닙니다");
					logic3TF = 0;
				}
				break;
			default:
				System.out.println(year + "년은 윤년이 맞습니다");
				logic3TF = 1;
				break;
			}
			
			break;
			
		default:
			System.out.println(year + "년은 윤년이 아닙니다");
			logic3TF = 0;
		}
		
		switch(month) {
		case 4: case 6: case 9: case 11:
			System.out.println(month + "월의 일 수는 30일 입니다");
			break;
		case 1: case 3: case 5: case 7: case 8: case 10: case 12:
			System.out.println(month + "월의 일 수는 31일 입니다");
			break;
		case 2:
			if(logic3TF == 0) {
				System.out.println(month + "월의 일 수는 28일 입니다");
			}
			else {
				System.out.println(month + "월의 일 수는 총 29일 입니다");
			}
		}
		
	}

}

//실제 지구가 태양을 공전하여 시작점으로 회귀하는데 걸리는 시간은 약 365일 + 6시간
//4년동안 지구가 태양을 공전하는데 걸리는 실제 시간은 약 365*4일 + 1일
//2월을 28일로 정할 때 4년마다 실제 지구가 태양을 공전한 시간과 율리우스력 사이의 오차를 보정하기 위해
//2월에 1일을 추가해야 하는 년도
//평년 : 2월의 날짜가 28일인 해
//윤년 : 2월의 날짜가 29일인 해 