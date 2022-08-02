package array;

public class Test01 {
	
	public static void main(String[] args) {
		
		//배열(Array)의 필요성
		
		//ex : 5개의 정수에 대한 처리
		int score1 = 50;
		int score2 = 75;
		int score3 = 80;
		int score4 = 65;
		int score5 = 99;
		
		//출력
		System.out.println("점수 : " + score1);
		System.out.println("점수 : " + score2);
		System.out.println("점수 : " + score3);
		System.out.println("점수 : " + score4);
		System.out.println("점수 : " + score5);
		
		System.out.println();
		
		//총점, 평균
		int sum = score1 + score2 + score3 + score4 + score5;
		System.out.println("총점 : " + sum);
		
		double avg = (score1 + score2 + score3 + score4 + score5) / 5.0;
		System.out.println("평균 : " + avg);
		
		//이렇게 같은 종류의 데이터가 많을 때 코드가 길어지지 않도록 하기 위해 사용하는 것이 배열
		
		
	}
}
