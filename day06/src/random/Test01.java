package random;
//import java.lang.*;

import java.util.Random;

public class Test01 {

	public static void main(String[] args) {
		
		//랜덤 (random)
		//- 무엇이 나올지 예측이 되지 않는 값 (난수)
		//- 주사위, 로또, 게임 아이템 뽑기, ...
		//- 확률적인 형태가 구현 가능함
		//- 구현 방법은 여러가지가 있지만 크게 3가지로 나뉜다
		//(1) Math.random(); : 내장 명령 사용
		//(2) Random 도구 사용
		//(3) SecureRandom 도구 사용
		
		//(1) Math.random()
		//- 0 이상 1미만의 double을 무작위로 만드는 명령	//0.xxxxx (0.0포함)
		//System.out.println(Math.random());
		
		//0부터 9까지 중 하나를 랜덤으로 할 때
		double a = Math.random();
		System.out.println("a = " + a);
		
		double b = a * 10;	//0.xxx ~ 9.xxx : 1의 자리가 0부터 9까지 중 하나가 나옴
		System.out.println("b = " + b);
		
		int c = (int)b;		//0 ~ 9
		System.out.println("c = " + c);
		
		//1부터 10까지 중 하나를 랜덤으로 할 때
		int d = c + 1;
		System.out.println("d = " + d);
		
		
		//공식 유도 : 변수가 있던 자리에 윗 식을 대입하면 변수의 갯수를 줄일 수 있다
		//double d = (int)(Math.random() * 10) + 1;		//숫자 1의 의미 : /* 부터 */까지
														//숫자 10의 의미 : 갯수
														//ex) 1 ~ 6 : 1부터 6까지, 1부터 6개
														//ex) 10 ~ 99 : 10부터 99까지, 10부터 90개
		//double a = Math.random();
		//double b = a * 10;
		//int c = (int)b;
		//int d = c + 1;
		
		//(2) random이라는 도구를 만들어서 값 생성
		//- 주의사항 : Random은 close()가 없다 (close는 입출력에서만 나옴)
		Random r = new Random();		//import java.util.Random; 이 필요
		
		int number2 = r.nextInt(10) + 1;	//숫자 1의 의미 : 1부터 (/* 부터 */까지)
											//숫자 10의 의미 : 갯수
		System.out.println("number2 = " + number2);
	}
	
}
