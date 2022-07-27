package condition;

//NCS 능렫단위인 프로그래밍 언어 활용 평가를 진행했습니다.
//서술형, 문제해결 시나리오 두 과목을 응시한 학생의 점수가 다음과 같습니다.
//-서술형 : 85점
//-문제해결 시나리오 : 52점
//평균 60점 이상이면 통과라고 했을 때 이 학생이 통과인지 재시험인지 판정하여 출력

import java.lang.*;

public class Test02 {
	public static void main(String[] args) {
		
		//준비
		int test1 = 85;
		int test2 = 52;
		
		//계산
		double average = (test1 + test2) / 2.0;
		//double average = (double)(test1 + test2) / 2;
		System.out.println("평균 점수 : " + average);
		
		boolean pass = average >= 60;
		//System.out.println(pass);
		
		if(average >= 60) {
			System.out.println("통과");
		}
		
		if(average < 60) {
			System.out.println("재시험");
		}
		
		if(pass == true) {//평균 60점 이상이라면
			System.out.println("통과");
		}
		
		if(pass == false) {//평균 60점 미만이라면
			System.out.println("재시험");
		}
		
	}

}
