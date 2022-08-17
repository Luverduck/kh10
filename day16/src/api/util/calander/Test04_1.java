package api.util.calander;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

// 사용자에게 연, 월을 입력받아서 해당하는 달의 달력을 보여주세요

// ex : 2022, 3을 입력한 경우

//	일		월		화		수		목		금		토
//	27		28		1		2		3		4		5
//	6		7		8		9		10		11		12
//	13		14		15		16		17		18		19
//	20		21		22		23		24		25		26
//	27		28		29		30		31		1		2
//	3		4		5		6		7		8		9

// 첫 번째 일요일을 찾아야함

import java.util.Scanner;

public class Test04_1 {

	public static void main(String[] args) {
		
		// 준비
		int year = 2022;
		int month = 8;
		
		// 계산
		// 1. 해당 월의 1일로 설정해서 무슨 요일인지를 알아야 한다
		// 2. 앞에 날짜를 몇 개 더 출력해야 하는지 알 수 있다
		// - 1일이 일요일이면 앞에 출력할 날짜가 0개
		// - 1일이 월요일이면 앞에 출력할 날짜가 1개
		// - 1일이 화요일이면 앞에 출력할 날짜가 2개
		// - 1일이 수요일이면 앞에 출력할 날짜가 3개
		// - 1일이 목요일이면 앞에 출력할 날짜가 4개
		// - 1일이 금요일이면 앞에 출력할 날짜가 5개
		// - 1일이 토요일이면 앞에 출력할 날짜가 6개
		
		// 1. 해당 월의 1일로 설정해서 무슨 요일인지를 알아야 한다
		Calendar c = Calendar.getInstance();
		c.set(year, month - 1, 1);
		
		// 2. 앞에 날짜를 몇 개 더 출력해야 하는지 알 수 있다
		int week = c.get(Calendar.DAY_OF_WEEK);	
		//System.out.println("week = " + week);		// 출력 : 2(월요일)
		//System.out.println("앞에 출력해야 할 날짜 수 : " + (week - 1));
		
		// 2번에서 계산한 날짜 수만큼 앞으로 이동
		c.add(Calendar.DATE, - (week - 1)); 	
		
		// 출력
		System.out.println(year + "년 " + month + "월 달력 출력");
		System.out.println();
		
		System.out.println("일\t월\t화\t수\t목\t금\t토");
		
		for(int i = 0 ; i < 42 ; i ++) {
			System.out.print(c.get(Calendar.DATE));
			System.out.print("\t");
			
			if(i % 7 == 6) {
				System.out.println();
			}
			
			c.add(Calendar.DATE, 1);
		}
	}
}

