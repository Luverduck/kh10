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

public class Test04_revise {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		try {
			// 사용자 입력
			System.out.print("년도 입력 : ");
			int year = sc.nextInt();
			
			System.out.print("월 입력 : ");
			int month = sc.nextInt();
			if(month < 1 && month > 12) {
				throw new Exception("월은 1~12 사이의 숫자로 입력해야 합니다");
			}
			
			// Calendar 인스턴스 생성
			Calendar input = Calendar.getInstance();
			
			// 입력한 년, 월의 1일로 설정
			input.set(year, month - 1, 1);
			
			// 입력한 년, 월의 1일이 무슨 요일인지 (일요일일 때 DAY_OF_WEEK의 값은 1이다)
			int dayOfWeek = input.get(Calendar.DAY_OF_WEEK);
			
			// 출력
			System.out.println();
			System.out.println(year + "년 " + month + "월 달력");
			System.out.println("일\t월\t화\t수\t목\t금\t토");
			
			int rowChange = 0;
			for(int i = 1 ; i <= 42 ; i ++) {
				if(i == 1) {									// 맨 첫 번째 입력(i==1, 일요일)의 일자가 1일이 아닌 경우
					input.add(Calendar.DATE, i - dayOfWeek);	// 1일에 보정치(i - dayOfWeek)를 더한다
				}
				else {
					input.add(Calendar.DATE, 1);
				}
				System.out.print(input.get(Calendar.DATE )+ "\t");
				
				rowChange ++;
				
				if(rowChange % 7 == 0) {
					System.out.println();
				}
			}
		}	

		catch(Exception e) {
			if(e.getMessage() == null) {
				System.err.println("입력이 잘못되었습니다");
			}
			else {
				System.out.println("오류 : " + e.getMessage());
			}
		}
		
		finally {
			sc.close();
		}
	}
}

