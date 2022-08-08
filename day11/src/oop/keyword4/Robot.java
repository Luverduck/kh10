package oop.keyword4;

public class Robot {

	// static은 1회성 메소드에 유용하다
	
	// 1. 제곱 구하기
	public static int square(int number) {	// 메소드 이름이 반드시 get으로 시작할 필요는 없다
		return number * number;
	}
	
	// 2. BMI 구하기 (체중, 키 순)
	public static double bmi(double weight, double height) {		// getBmi 앞의 double : 메소드의 반환형 (실행 후의 결과물 형태)
		return weight / (height / 100) / (height / 100);			// double weight, double height : 매개변수
	}							// 제곱을 나누는 방법 : (height / 100)을 2번 나눈다
		// 1번의 getSquare 메소드를 가져다 쓸 수도 있다
		// return weight / getSquare(height / 100);		(자료형이 일치해야함)
	
	// 3. 지하철 요금 구하기
	public static int price(int birth) {
		int age = 2022 - birth + 1;
		if(age <= 7 || age >= 65) {
			return 0;
		}
		else if(age <= 13) {
			return 450;
		}
		else if(age <= 19) {
			return 720;
		}
		else {
			return 1250;
		}
	}
	
	// 4. 삼각형의 넓이 (밑변, 높이 순)
	public static double triangle(int width, int height) {
		return width * height / 2.0;
	}
	
	// 5. 원의 넓이
	public static double circle(int radius) {
		return radius * radius * 3.14;
	}
}
