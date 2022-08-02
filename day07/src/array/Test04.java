package array;

public class Test04 {

	public static void main(String[] args) {
		
		//배열에 반복문을 사용
		
		int[] score = new int[5];	
		
		//반복문 사용 불가능
		score[0] = 55;
		score[1] = 75;
		score[2] = 80;
		score[3] = 65;
		score[4] = 99;
		//score =======> [55][75][80][65][99]
		
		//반복문을 사용하여 출력 간소화 : 반복수를 1에서 5로 하여 위치를 지정
		for(int i = 0 ; i <= 4 ; i++) {
			System.out.println(score[i]);
		}
		
		System.out.println();
		
		//반복문을 사용하여 합계 간소화
		//int total = 0;
		//total += score[0];
		//total += score[1];
		//total += score[2];
		//total += score[3];
		//total += score[4];
		
		int sum = 0;
		for(int i = 0; i <= 4 ; i++) {
			sum += score[i];
		}
		System.out.println("합계 :" + sum);
		
		System.out.println();
		
		//평균
		double avg = (double)sum / 5;
		System.out.println("평균 :" + avg);
		
	}
}
