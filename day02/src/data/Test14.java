package data;

//BMI 계산기
//BMI는 체질량지수(비만지수)를 말합니다.
//구하는 공식은 'BMI = 체중(kg) / 키(m)^2' 입니다.
//키가 180cm이고, 체중이 80kg인 사람의 BMI 지수를 구하여 출력

import java.lang.*;

public class Test14 {
	public static void main(String[] args) {
		
		//준비
		int kgWeight = 80;
		int cmHeight = 180;
		
		//float mHeight = (float)cmHeiht / 100;
		//float mHeight = cmHeight / 100f;
		double mHeight = (double)cmHeight / 100;
		double mHeightSquare = mHeight * mHeight;

		//계산
		//float bmi = (float)kgWeight / mHeightSquare;
		double bmi = (double)kgWeight / mHeightSquare;
		
		//출력
		System.out.println(bmi);
		
	}

}
