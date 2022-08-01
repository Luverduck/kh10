package loop3;

public class Test01 {
	
	public static void main(String[] args) {
		
		//while 반복문
		//-특정 시점까지 반복하는 반복문
		//-for 반복문은 횟수나 범위가 주어졌을 때의 반복문
		
		//ex) 1부터 10까지 출력
		for(int i=1; i<=10; i++) {
			System.out.print(i + ", ");
		}
		
		System.out.println();
		System.out.println();
		
		//
		int n=1;	//선언부
		while(n <= 10) {//조건부
			System.out.print(n + ", ");	//초기값인 n=1을 출력하기 위해 출력식을 먼저 작성
			n++;	//증감부
		}
		
		System.out.println(n); //밖에서 n을 출력할 수 있다
		
	}

}
