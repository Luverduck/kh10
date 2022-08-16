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

public class Test04_me_explain {

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
			
			// 총 표시할 날짜의 수
			int row = 6;	// 6개의 주
			int column = 7;	// 7개의 요일
			
			int sunday = 1;	// 일요일일 때 DAY_OF_WEEK의 값은 1이다
			
			// 입력한 년, 월의 1일이 무슨 요일인지
			int dayOfWeek = input.get(Calendar.DAY_OF_WEEK);
			
			System.out.println(year + "년 " + month + "월 달력");
			
			// 입력한 년, 월의 1일이 일요일이라면 (dayOfWeek == 1)
			if(dayOfWeek == 1) {
				for(int i = 1 ; i <= row ; i ++) {
					for(int j = 1 ; j <= column ; j++) {
						// 일요일부터 1일을 입력한 후
						System.out.print(input.get(Calendar.DATE));
						// Calendar의 인스턴스인 input의 일(DATE) 값을 +1만큼 증가시킨다 
						// (다음 회차에 해당 DATE 값을 입력할 수 있도록)
						input.set(Calendar.DATE, input.get(Calendar.DATE) + 1);
						System.out.print("\t");
					}
					System.out.println();
				}
			}
			
			// 입력한 년, 월의 1일이 일요일(1)이 아니라면 (dayOfWeek != 1)
			else {
				// 해당 년, 월의 첫째 주 일요일의 날짜에 해당하는 숫자를 출력할 수 있도록 
				// 숫자 1(일요일의 DAY_OF_WEEK)에서 dayOfWeek(해당 년, 월의 1일의 요일)을 뺀 값(음수)을 더한다
				input.set(Calendar.DATE, sunday - input.get(Calendar.DATE));
				for(int i = 1 ; i <= row ; i ++) {
					for(int j = 1 ; j <= column ; j++) {
						// 첫째 주 일요일에 해당하는 일(DATE)의 숫자를 입력한 후
						System.out.print(input.get(Calendar.DATE));
						// Calendar의 인스턴스인 input의 일(DATE) 값을 +1만큼 증가시킨다 
						// (다음 회차에 해당 DATE 값을 입력할 수 있도록)
						input.set(Calendar.DATE, input.get(Calendar.DATE) + 1);
						System.out.print("\t");
					}
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
