package io;

//사용자에게 신장(cm)과 체중(kg)을 입력받아서 BMI 지수를 계산하여 출력
//BMI 지수가 24.5가 넘으면 "비만", 아니면 "정상"으로 표시
//공식 : BMI = 체중(kg) / 키(m)^2

import java.util.Scanner;

import java.lang.*;

public class Test05 {
	public static void main(String[] args) {
		
		//준비 (사용자 입력)
		Scanner sc = new Scanner(System.in);
		
		System.out.print("신장 입력 :");
		double cm = sc.nextDouble();
		
		System.out.print("체중 입력 :");
		double kg = sc.nextDouble();
		
		//계산
		double m = cm / 100;
		double bmi = kg / (m * m); //또는 double bmi = kg / m / m;
		
		//출력
		System.out.println("BMI : " + bmi);
		
		if(bmi > 24.5) {
			System.out.println("비만입니다");
		}
		else {
			System.out.println("정상입니다");
		}
		
	}

}
