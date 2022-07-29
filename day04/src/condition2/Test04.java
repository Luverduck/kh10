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

public class Test04 {
	public static void main(String[] args) {
		
		//준비
		int year = 2022;
		int month = 3;
		
		//계산
		//System.out.println("4로 나눈 나머지 = " + year % 4);
		//System.out.println("100으로 나눈 나머지 = " + year % 4);
		//System.out.println("400으로 나눈 나머지 = " + year % 4);
		
		//boolean leap = true or false;
		boolean leap = year % 4 == 0 && year % 100 != 0 || year % 400 == 0;;
		if(year % 4 != 0) {//year가 4의 배수가 아니면
			leap = false;
		}
		//여기서부터는 4의 배수인 경우
		else if(year % 100 == 0 && year % 400 != 0) {//year가 100의 배수이지만 400의 배수는 아니라면
			leap = false;
		}
		else if (year % 400 == 0) {//year가 400의 배수라면
			leap = true;
		}
		else {//나머지 4의 배수
			leap = true;
		}
		
		int day;
		switch(month) {
		case 2:
			//day = 29 or 29;
			if(leap == true) {
				day = 29;
			}
			else {
				day = 28;
			}
			break;
		case 4: case 6: case 9: case 11:
			day = 30;
			break;
		default:
			day = 31;
			break;
		}
		
		System.out.println(year+"년 "+month+"월은 "+day+"일까지 있습니다");
		
		//if() {
		//	System.out.println("윤년입니다");
		//}
		//else {
		//	System.out.println("윤년이 아닙니다");
	}
	
}
		