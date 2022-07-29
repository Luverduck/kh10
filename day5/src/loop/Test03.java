package loop;

import java.lang.*;

public class Test03 {
	public static void main(String[] args) {
		
		//반복수의 활용
		
		//ex) 1부터 100까지 출력
		
		for(int i=1 ; i<=100 ; i=i++) {
			System.out.println(i);
		}
		
		//ex) 100부터 1까지 출력
		for (int i=100; i>=1 ; i=i--) {//위에서 i를 써도 아래도 i를 써도 됨, 반복수는 독립적이다
			System.out.println(i);
		}
		
	}

}
