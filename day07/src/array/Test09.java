package array;

//1. 사용자에게 숫자 5개를 입력받아 배열에 저장합니다
//2. 입력받은 모든 숫자를 출력합니다
//3. 입력받은 모든 숫자의 합계와 평균을 구하여 출력합니다

import java.util.Scanner;

public class Test09 {
	
	public static void main(String[] args) {
		
		//1. 숫자 입력 5개를 받아 배열에 저장
		Scanner sc = new Scanner(System.in);
		
		int[] inputArray = new int[5];
		
		for(int i = 0 ; i < 5 ; i ++) {
			int input = sc.nextInt();
			inputArray[i] = input;
		}
		
		System.out.println();
		
		//2. 입력받은 모든 숫자를 출력
		System.out.print("입력 받은 숫자 : ");
		for(int i = 0 ; i < inputArray.length ; i++) {
			System.out.print(inputArray[i] + ", ");
		}
		
		System.out.println();
		
		//3. 입력받은 모든 숫자의 합계와 평균을 구하여 출력
		int sum = 0;
		for(int i = 0 ; i < 5 ; i ++) {
			sum += inputArray[i];
		}
		
		double avg = (double)sum / inputArray.length;
		
		System.out.println("합계 : " + sum);
		System.out.println("평균 : " + avg);
		
		System.out.println();
		
		
		sc.close();
		
	}

}
//12번 selection sort
//13번 bublesort