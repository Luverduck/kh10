package data;

//BMI 계산기
//BMI는 체질량지수(비만지수)를 말합니다.
//구하는 공식은 'BMI = 체중(kg) / 키(m)^2' 입니다.
//키가 180cm이고, 체중이 80kg인 사람의 BMI 지수를 구하여 출력

import java.lang.*;
import java.text.DecimalFormat;

public class Test14 {
	public static void main(String[] args) {
		
		//준비 (나)
		int kgWeight = 80;
		int cmHeight = 180;
		
		//float mHeight = (float)cmHeiht / 100;
		//float mHeight = cmHeight / 100f;
		double mHeight = (double)cmHeight / 100;
		double mHeightSquare = mHeight * mHeight;

		//계산 (나)
		//float bmi = (float)kgWeight / mHeightSquare;
		double bmi = (double)kgWeight / mHeightSquare;
		
		//출력 (나)
		System.out.println(bmi);
		
		//추가 : 소수점 자릿수를 2자리까지만 표시하는 방법
		//(1) 직접 구현
		double bmi2 = (int)(bmi * 100) / 100.0;
		System.out.println(bmi2);
		
		//(2) 라이브러리 사용
		DecimalFormat fm = new DecimalFormat("0.00");
		System.out.println(fm.format(bmi));
		
		
		//준비
		//double height = 180;
		//double weight = 80;
		
		//계산
		//(공식) BMI = 체중(kg) / 키(cm)^2
		
		//double heightMeter = height / 100;
		
	
		//double bmi = weight / 키 / 키;
		//double bmi = weight / (키 * 키);	//괄호를 먼저 계산함
		//double bmi = weight / (heightMeter * heightMeter);
		
		//출력
		//System.out.println("BMI 지수는 다음과 같다");
		//System.out.println(bmi);
		
		
		
	}

}
