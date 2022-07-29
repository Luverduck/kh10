package loop;

//다음의 값을 화면에 출력
//(1) 1부터 99 사이의 7의 배수
//(2) 1부터 99 사이의 5가 들어간 숫자

import java.lang.*;

public class Test06 {
	public static void main(String[] args) {
		
		//1부터 99사이의 7의 배수
		//-7, 14, 21, 28, ... , 77, 84, 91, 98 
		for(int i=1; i<=99; i++) {
			if(i % 7 == 0) {
				System.out.print(i);
				System.out.print(", ");
			}
		}
		
		System.out.println();
		System.out.println();
		
		//(2) 1부터 99 사이의 5가 들어간 숫자 출력
		//-나누기와 나머지를 통해 10의 자리와 1의 자리를 분리해서 비교
		for(int i=1; i<=99; i++) {
			//if(5가 들어있다면) {
			//if(10의 자리에 5 또는 1의 자리에 5) {
			if(i / 10 == 5||i % 10 == 5) {
				System.out.print(i);
				System.out.print(", ");
			}
		}
		
		System.out.println();
		System.out.println();
		
		for(int i=1; i<=99; i++) {
			boolean ten = i/10 == 5;
			boolean one = i % 10 == 5;
			if(ten||one) {
				System.out.print(i+", ");
			}
		}
		
	}

}
