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

public class Test04 {

	public static void main(String[] args) {
		
		// 준비
		int year = 2022;
		int month = 8;
		
		// 계산
		// 1. 해당 월의 1일로 설정해서 무슨 요일인지를 알아야 한다		
		// 2. 앞에 날짜를 몇 개 더 출력해야 하는지 알 수 있다
		
		// 1. 해당 월의 1일로 설정해수 무슨 요일인지를 알아야 한다
		Calendar c = Calendar.getInstance();
		c.set(year, month - 1, 1);
		
		// 출력
		Date d = c.getTime();
		Format f = new SimpleDateFormat("yyyy-MM-dd E");
		System.out.println(f.format(d));
	}
}

