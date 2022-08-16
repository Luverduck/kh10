package api.util.calander;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

// 오늘 사귄 커플의 100일 기념일이 몇일인지 계산해서 출력

public class Test03 {

	public static void main(String[] args) {
		
		// Calendar 인스턴스 생성
		Calendar today = Calendar.getInstance();
		
		// 설정
		int date = today.get(Calendar.DATE);
		today.set(Calendar.DATE, date + 99);
		//today.add(Calendar.DATE, 99);		// .add를 사용
		
		// Date 생성
		Date result = today.getTime();
		
		// 형식 변환
		Format f = new SimpleDateFormat("y년 M월 d일 E요일");
		
		// 결과
		System.out.println(f.format(result));
	}
}
