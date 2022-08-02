package array;

//우리반 학생들의 시험 성적은 다음과 같습니다
//- 75점 / 92점 / 86점 / 65점 / 79점 / 95점 / 88점 / 86점 / 72점 / 77점
//1. 전체 학생의 점수를 배열에 저장한 뒤 출력하세요
//2. 전체 학생의 평균을 구하여 출력하세요
//3. 성적 우수자(90점 이상)의 숫자를 카운트하여 출력하세요
//4. 만약 이 반에 85점 이상이 전학을 왔다면 이 학생의 예상 등수는 몇등인지 출력하세요

public class Test05 {
	
	public static void main(String[] args) {
		
		int[] score = new int[] {75, 92, 86, 65, 79, 95, 88, 86, 72, 77};
		
		System.out.println(score.length);
		
		System.out.println();
		
		//1. 
		for(int i = 0; i < score.length ; i ++) {
			System.out.print(score[i] + ", ");
			if(i == (score.length - 1)) {
				System.out.println(score[i]);		//마지막 숫자는 ,을 떼도록
			}
		}
		
		System.out.println();
		
		
		
		//2.
		int sum = 0;
		for(int i = 0; i < score.length ; i ++) {
			sum += score[i]; 
		}
		
		double avg = (double)sum / score.length;
		
		System.out.println("합계 : " + sum);
		System.out.println("평균 : " + avg);
		
		System.out.println();
		
		
		
		//3. 
		int count = 0;
		for(int i = 0 ; i < score.length ; i ++) {
			if(score[i] >= 90) {
				count++;
			}
		}
		
		System.out.println("성적 우수자의 숫자 : " + count);
		
		System.out.println();
		
		
		
		//4. 만약 이 반에 85점 이상이 전학을 왔다면 이 학생의 예상 등수는 몇등인지 출력하세요
		int newby = 100;
		int newbyRank = 1;
		for(int i = 0 ; i < score.length ; i ++) {
			if(newby < score[i]) {						//왜 0등이 나오는지?
				newbyRank ++;							//int newbyRank = 1; 로 설정한다
			}
		}
		System.out.println("예상되는 등수 : " + newbyRank);
		
		System.out.println();
		
		
		
		//#. 만약 이 반에 85점 이상이 전학을 왔다면 이 학생의 예상 등수는 몇등인지 출력하세요
		int[] scoreAfter = new int[] {75, 92, 86, 65, 79, 95, 88, 86, 72, 77, 100};
		
		int position = 1;
		for(int i = 0 ; i < (scoreAfter.length - 1) ; i ++) {
			if(scoreAfter[(scoreAfter.length - 1)] < scoreAfter[i]) {
				position++;
			}
		}
		
		System.out.println("예상되는 등수 : " + position);
		
	}

}
