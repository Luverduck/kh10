package random;

//다음 랜덤값을 구하여 화면에 출력
//1. 주사위 1개를 던진 결과
//2. 로또 번호 1개를 추첨한 결과 (1~45)
//3. OTP번호 1개를 생성한 결과 (6자리 정수)
//4. 동전을 던졌을 때 예사되는 결과 앞 또는 뒤

import java.util.Random;

public class Test02 {
	
	public static void main(String[] args) {
	
		//1. 주사위 1개를 던진 결과
		Random r1 = new Random();						//Random으로 변수가 만들어질 때 소수점 첫째자리 숫자는 0에서 9 중 하나
		int dice = r1.nextInt(6) + 1;					//0.0xxx...에서 0.9xxx...까지의 숫자에 6을 곱하면 0.0xxx...에서 5.xxx...까지 중 하나
		System.out.println("주사위 결과 : "+ dice);		//int로 바꾸면 소수점 이하를 버림하여 0부터 5까지 중 하나
		System.out.println();							//이 범위의 숫자에 1을 더하면 1부터 6까지 중 하나
	
		//2. 로또 번호 1개를 추첨한 결과 (1~45)
		Random r2 = new Random();
		int lotto = r2.nextInt(45) + 1;
		System.out.println("로또 번호 1개 : "+ lotto);
	
		System.out.println();
	
		//3. OTP번호 1개를 생성한 결과 (6자리 정수)
		Random r3 = new Random();
		int OTP = r3.nextInt(1000000) + 1;				// 0부터 999999까지
		//int OTP = r.nextInt(900000) + 100000;			//100000부터 999999까지
		System.out.println("OTP 번호 : " + OTP);
		
		System.out.println();
		
		//4. 동전을 던졌을 때 예사되는 결과 앞 또는 뒤
		Random r4 = new Random();
		int coin = r4.nextInt(2);		//0부터 2개, 
		
		switch(coin) {					//0일때와 1일때 각각 무엇을 의미할 것인지 정해야 한다
		case 0:
			System.out.println("앞");
			break;
		default:
			System.out.println("뒤");
			break;
		}
		
		System.out.println();
		
		if(coin == 0) {
			System.out.println("앞");
		}
		else {
			System.out.println("뒤");
		}
	
	}

}
