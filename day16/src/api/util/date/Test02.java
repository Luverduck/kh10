package api.util.date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test02 {

	public static void main(String[] args) {
		
		// Date의 형식(format) 바꾸기
		Date a = new Date();
		
		System.out.println(a);
		
		// java.text.SimpleDateFormat 클래스를 사용하면 형식을 바꿀 수 있다
		SimpleDateFormat f = new SimpleDateFormat("yyy-MM-dd");
		System.out.println(f.format(a));
		
		// y (소문자) : year
		// - 2개 쓸 경우 : 2자리로 년도 표시
		// - 그 외 : 4자리로 년도 표시
		
		// M (대문자) : Month in year (1년 중 몇월)
		// - 1개 쓸 경우 : 1자리로 월 표시
		// - 2개 쓸 경우 : 2자리로 월 표시
		
		// d (소문자) : Day in month (1달 중 몇일)
		
		SimpleDateFormat f2 = new SimpleDateFormat("y년 M월 d일");
		System.out.println(f2.format(a));
	}	
}
