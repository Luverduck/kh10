package api.util.calander;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

// 오늘 사귄 커플의 100일 기념일이 몇일인지 계산해서 출력

public class Test03_1 {

	public static void main(String[] args) {
		
		// Calendar 인스턴스 생성
		Calendar today = Calendar.getInstance();
		
		// 100일마다 알려주는 경우
		
		// 형식 변환
		Format f = new SimpleDateFormat("y년 M월 d일 E요일");
		
		// 계산
		for(int i = 100 ; i <= 1000 ; i += 100) {
			today.add(Calendar.DATE, -1);
			
			// 출력
			Date result = today.getTime();
			System.out.println(i + "일 - " + f.format(result));
		}
	}
}
