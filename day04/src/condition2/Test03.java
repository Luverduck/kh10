package condition2;

//switch ~ case
//사용자에게 월을 입력받아 해당 월의 마지막 날짜를 구하여 출력하는 프로그램을 구현하세요
//-2월은 28일까지 있다고 가정합니다 (윤년은 고려하지 않습니다)
//-4, 6, 9, 11월은 30일까지 있습니다
//-1. 3, 5, 7, 8, 10, 12월은 31까지 있습니다

import java.lang.*;

public class Test03 {
	public static void main(String[] args) {
		
		int month = 12;
		
		//switch ~ case를 사용하는 경우
		switch(month) {//switch()의 () 부분에는 논리식을 쓸 수 없다
		case 2:
			System.out.println("28");
			break;
		case 4:
			System.out.println("30");
			break;
		case 6:
			System.out.println("30");
			break;
		case 9:
			System.out.println("30");
			break;
		case 11:
			System.out.println("30");
			break;
		case 1:
			System.out.println("31");
			break;	
		case 3:
			System.out.println("31");
			break;
		case 5:
			System.out.println("31");
			break;
		case 7:
			System.out.println("31");
			break;
		case 8:
			System.out.println("31");
			break;
		case 10:
			System.out.println("31");
			break;
		case 12:
			System.out.println("31");
			break;
		default:
			System.out.println("잘못된 입력"); //자동완성 명령 : ctrl + space //ex)sysout -> System.out.println();
			break;
		}
		
	}

}
