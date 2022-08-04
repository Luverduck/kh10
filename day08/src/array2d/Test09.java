package array2d;

//다음은 우리반 학생의 과목별 성적 정보입니다
//이름을 제외한 나머지 정보들을 단 하나의 2차원 배열로 저장하고 싶습니다.
//총점과 평균과 순위는 최초 0으로 설정한 뒤 계산을 통해서 채운 뒤 출력하려고 합니다
//프로그래밍 코드를 작성하여 모든 정보를 채우고 출력하세요

public class Test09 {
	
	public static void main(String[] args) {
		
		int[][] array = new int[3][6];
		
		array[0][0] = 100;
		array[0][1] = 90;
		array[0][2] = 80;
		array[0][3] = 0;
		array[0][4] = 0;
		array[0][5] = 0;
		
		
		array[1][0] = 95;
		array[1][1] = 92;
		array[1][2] = 93;
		array[1][3] = 0;
		array[1][4] = 0;
		array[1][5] = 0;
		
		
		array[2][0] = 70;
		array[2][1] = 95;
		array[2][2] = 95;
		array[2][3] = 0;
		array[2][4] = 0;
		array[2][5] = 0;
		
		
		//합계 및 평균
		for(int j = 0 ; j < array.length ; j ++) {	//위에서 아래로 1번
			
			int sum = 0;
			int avg = 0;
			for(int i = 0 ; i < array[j].length - 3 ; i++) {
				sum += array[j][i];										//합계와 평균을 동시에?
				avg = sum / 3;
				array[j][3] = sum;
				array[j][4] = avg;
			}
		}

		
		//출력
		for(int j = 0 ; j < array.length ; j ++) {
			for(int i = 0 ; i < array[j].length ; i++) {
				System.out.print(array[j][i]);
				System.out.print("\t");
			}
			System.out.println();
		}
		
	}

}
