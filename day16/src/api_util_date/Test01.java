package api_util_date;

import java.util.Date;

public class Test01 {

	public static void main(String[] args) {
		
		// 시간 다루기 
		Date a = new Date();		// 시스템의 현재 시간
		Date b = new Date(2022, 8, 16);
		Date c = new Date(22, 8, 16);		// 8월을 입력하고 싶으면 7을 입력 (월은 0부터 11까지)
		
		System.out.println("a = "  + a);
		System.out.println("b = " + b);
		System.out.println("c = " + c);
		
		// java.text 패키지 : data를 formating 해줌
	}
}
