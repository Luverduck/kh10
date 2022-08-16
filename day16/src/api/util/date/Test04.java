package api.util.date;

import java.text.DecimalFormat;
import java.text.Format;

public class Test04 {

	public static void main(String[] args) {
		
		// 숫자 형식 제어
		// - 0은 해당 자리에 숫자가 없으면 그 자리에 0을 출력(자리를 고정하는 역할) ex) 000275같이 0을 앞에 꼭 써야 하는 경우
		// - #은 해당 자리에 숫자가 없으면 출력하지 않음
		// - 패턴을 인식하므로 콤마는 하나만 작성해도 된다
		
		int a = 1234567890;
		double b = 1234.567890;
		
		Format f1 = new DecimalFormat("0,000,000,000");
		System.out.println(f1.format(a));
		System.out.println(f1.format(b));
		
		System.out.println();
		
		Format f2 = new DecimalFormat("#,###,###,###");
		System.out.println(f2.format(a));
		System.out.println(f2.format(b));
		
		System.out.println();
		
		Format f3 = new DecimalFormat("#,##0.00");	// 공식처럼 암기
		System.out.println(f3.format(a));
		System.out.println(f3.format(b));
		System.out.println(f3.format(0.12));
	}
}
