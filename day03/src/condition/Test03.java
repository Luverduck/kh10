package condition;

import java.lang.*;

public class Test03 {
	public static void main(String[] args) {
	
		//조건끼리 계산 (논리 연산)
		//-and 연산 : && 형태로 사용하며 양쪽 다 true가 되어야 true 출력
		//-or 연산 : || - shift + 역슬레시(\)
		
		//(Q) 나이가 주어져 있을 때 청소년인지 판정해서 출력
		//-청소년이란 중1(14살)부터 고3(19살)까지를 말한다
		
		//준비
		int age = 21;
		
		//계산
		//boolean teen = 14 <= age <= 19 (이항 연산) //14살 이상 19살 미만
		boolean teen = 14 <= age && age <= 19; //컴퓨터 연산은 순서대로 진행한다
		System.out.println(teen);
		
		if(teen == true) {
			System.out.println("청소년 입니다");
		}
		
		if(teen == false) {
			System.out.println("청소년이 아닙니다");
		}
		
		if(teen != true) {//같지 않다(!=)를 이용
			System.out.println("청소년이 아닙니다");
		}
		
		
	}

}
