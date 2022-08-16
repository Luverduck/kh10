package api.util.date;

import java.text.Format;
import java.text.SimpleDateFormat;

// 다음 형식으로 시간을 출력하세요
// 1. 2022년 8월 16일 화
// 2. 오후 12시 2분
// 3. 12:03:35
// 4. 2022-08-16 화 12:02:35

import java.util.Date;

public class Test03 {

	public static void main(String[] args) {
		
		// Data 생성
		Date a = new Date();
		System.out.println(a);
		
		// 1) 2022년 8월 16일 화
//		SimpleDateFormat f1 = new SimpleDateFormat("y년 M월 d일 E");
		Format f1 = new SimpleDateFormat("y년 M월 d일 E");	// 업 캐스팅 : 하위 자료형을 상위 자료형으로 보관
		System.out.println(f1.format(a));		
		
		// 2) 오후 12시 2분	// 오전오후가 붙을 때는 12시간제를 사용한다
//		SimpleDateFormat f2 = new SimpleDateFormat("a H시 m분");
		Format f2 = new SimpleDateFormat("a h시 m분");		// 업 캐스팅 : 하위 자료형을 상위 자료형으로 보관
		System.out.println(f2.format(a));
		
		// 3) 12:03:35
//		SimpleDateFormat f3 = new SimpleDateFormat("HH:mm:ss");
		Format f3 = new SimpleDateFormat("HH:mm:ss");
		System.out.println(f3.format(a));
		
		// m (소문자) : Minute in hour (1시간 중 몇분)
		// - 1개 쓸 경우 : 1자리로 분 표시 -> 8분
		// - 2개 쓸 경우 : 2자리로 분 표시 -> 08분
		
		// 4) 2022-08-16 화 12:02:35
//		SimpleDateFormat f4 = new SimpleDateFormat("yyyy-MM-dd E HH:mm:ss");
		Format f4 = new SimpleDateFormat("yyyy-MM-dd E HH:mm:ss");
		System.out.println(f4.format(a));
	}
}
