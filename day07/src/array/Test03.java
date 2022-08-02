package array;

public class Test03 {

	public static void main(String[] args) {
		
		//배열에 반복문을 사용
		
		//배열 입력 간소화
		int[] score = new int[] {55, 75, 80, 65, 99};	
		//score =======> [55][75][80][65][99]
		
		//배열의 갯수가 달라질 때 아래 반복문에 자동으로 반영되도록 반복수의 범위를 변경??
		System.out.println(score.length);	
		//만들어진 score라는 배열의 길이를 출력 -> 반복수에 넣으면 자동으로 배열의 길이를 바꿀 때 반영
		
		//반복문을 사용하여 출력 간소화 : 반복수를 1에서 5로 하여 위치를 지정
		for(int i = 0 ; i < score.length ; i++) {
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
		for(int i = 0; i < score.length ; i++) {
			sum += score[i];
		}
		System.out.println("합계 :" + sum);
		
		System.out.println();
		
		//평균
		double avg = (double)sum / score.length;
		System.out.println("평균 :" + avg);
		
	}
}
