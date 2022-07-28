package condition2;

//switch ~ case
//사용자에게 월을 입력받아 해당 월의 마지막 날짜를 구하여 출력하는 프로그램을 구현하세요
//-2월은 28일까지 있다고 가정합니다 (윤년은 고려하지 않습니다)
//-4, 6, 9, 11월은 30일까지 있습니다
//-1. 3, 5, 7, 8, 10, 12월은 31까지 있습니다

import java.lang.*;

public class Test03_3 {
	public static void main(String[] args) {
		
		int month = 2;
		
		//if로 하는 경우
		if(month == 2) {
			System.out.println("28");
		}
		else if(month == 4 || month == 6 || month == 9 || month == 11) {
			System.out.println("30");
		}
		else if(month ==1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
			System.out.println("31");
		}
		else {
			System.out.println("잘못된 입력");
		}
		
	}

}
