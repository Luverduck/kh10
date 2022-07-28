package io;

//사용자에게 신장(cm)과 체중(kg)을 입력받아서 BMI 지수를 계산하여 출력
//BMI 지수가 24.5가 넘으면 "비만", 아니면 "정상"으로 표시
//공식 : BMI = 체중(kg) / 키(m)^2

import java.lang.*;
import java.util.Scanner;

public class Test05_me {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("신장[cm]을 입력하세요");
		double cmHeight = sc.nextDouble(); 	//오른쪽의 값을 왼쪽 변수공간에 저장하는 개념이므로 공간의 크기를 잘 고려할 것
		double mHeight = cmHeight / 100.0; 	//int 뒤에 nextDouble은 불가능하지만 double 뒤에 nextInt는 가능
		
		System.out.println("체중[kg]을 입력하세요");
		double kgWeight = sc.nextDouble();
		
		sc.close();
		
		double bmi = kgWeight / (mHeight * mHeight);
		double bmi2 = (int)(bmi * 100) / 100.0; //(복습) 소수점 2째 자리까지 남기는 방법
		
		System.out.println("BMI 지수는 " + bmi2 + "입니다");

		if(bmi2 >= 24.5) {
			System.out.println("비만");
		}
		else {
			System.out.println("정상");
		}
		
	}

}
