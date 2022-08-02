package array;

public class Test02 {

	public static void main(String[] args) {
		
		//Test01을 배열을 이용하여 처리
		//- 배열은 생성 과정이 필요하다
		
		int[] score = new int[5];	
		//new는 자료형에 맞게 초기값을 설정한다	
		//int의 경우 0, double의 경우 0.0, boolean의 경우 false
		
		//int가 5개 들어갈 공간을 만들어라	//int[] : int 배열 참조형
		//score =======> [?][?][?][?][?] (int 5개가 들어갈 공간)
		//				 +0 +1 +2 +3 +4 기준점(score의 시작점)부터 몇 칸 떨어져 있는지
		//score 기준점에서 0칸 떨어진 위치 : score[0]
		//score 기준점에서 1칸 떨어진 위치 : score[1]
		//score 기준점에서 2칸 떨어진 위치 : score[2]
		//...
		
		score[0] = 55;	//score의 기준점에서 0칸 떨어진 위치에 55 저장
		score[1] = 75;
		score[2] = 80;
		score[3] = 65;
		score[4] = 99;
		//score =======> [55][75][80][65][99]
		
		System.out.println(score);		// 참조 해시코드 (리모컨 일련번호같은 것)

		
		System.out.println();
		
		System.out.println(score[0]);
		System.out.println(score[1]);
		System.out.println(score[2]);
		System.out.println(score[3]);
		System.out.println(score[4]);
		
		System.out.println();
		
		//합계
		int sum = score[0] + score[1] + score[2] + score[3] + score[4];
		System.out.println("합계 :" + sum);
		
		System.out.println();
		
		//평균
		double avg = (double)sum / 5;
		System.out.println("평균 :" + avg);
		
		//배열과 반복문을 합칠 방법?
		
	}
}
