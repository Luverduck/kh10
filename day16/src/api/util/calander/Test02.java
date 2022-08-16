package api.util.calander;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test02 {

	public static void main(String[] args) {
		
		// Calendar의 장점 - 시간 설정
		// - 연도 설정이 Date보다 편하다 (월은 그대로)
		// - 일자가 벗어나도 자동 계산된다
		// - 윤년 등이 자동으로 계산된다
		
		Calendar c = Calendar.getInstance();
		
		// 설정 (수동으로 설정)
		// c.set(무엇을, 얼마로);
		//c.set(Calendar.YEAR, 2020);		// 년도를 2020으로 설정
		//c.set(2020, 1, 1);	// 년, 월, 일 (단, 월은 실제보다 1만큼 작다 (0~11)
		//c.set(2020, Calendar.JANUARY, 1);
		
		int year = 2020, month = 1, date = 31;	// date의 범위를 초과하면 자동으로 월을 올려준다
		c.set(year,  month-1, date); 			// 입력할 때는 1만큼 빼고 한다
		
		// 출력
		Date d = c.getTime();
		Format f1 = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(f1.format(d));
	}
}
