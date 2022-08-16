package api.util.calander;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test01 {

	public static void main(String[] args) {
		
		// Calendar 클래스
		// - 추상 클래스이므로 객체 생성 불가능
		
		// Calendar c = new Calendar();			// 직접 생성
		Calendar c = Calendar.getInstance();	// 생성 메소드 (환경 분석 후 생성)
		
		System.out.println(c);
		
		// 정보가 다 필요한 것이 아니므로 원하는 형태만 뽑을 수 있어야 한다
		// 1. Date로 변환한 뒤 출력 -> .getTime()
		Date d = c.getTime();
		Format f1 = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(f1.format(d));
		
		// 2. 직접 원하는 정보를 꺼내서 출력 (년도 or 월 or 일)
		//int year = c.get(1);	// 1은 년도를 출력
		int year = c.get(Calendar.YEAR);		// Calendar의 YEAR(상수)를 불러오기
		System.out.println("year = " + year);	// YEAR : Field number for get and set indicating the year.
		
		// 월(month) 추출
		// (주의) 월은 실제 값보다 1만큼 작으므로(0~11) +1을 한다 
		int month = c.get(Calendar.MONTH);
		System.out.println("month = " + month);
		
		// 일(day) 추출
		// 1) DATE 사용
		int day = c.get(Calendar.DATE);
		System.out.println("day = " + day);
		// 2) DAY_OF_MONTH 사용
		int day1 = c.get(Calendar.DAY_OF_MONTH);
		System.out.println("day = " + day1);
		
		// 시(hour) 추출
		int hour = c.get(Calendar.HOUR_OF_DAY);
		System.out.println("hour = " + hour);
		
		// (참고) 요일
		int week = c.get(Calendar.DAY_OF_WEEK);		// 일요일이 1에 해당한다
		System.out.println("week = " + week);
	}
}
