package array2d;

//Test03번과 동일하게 줄과 칸 수를 입력받아 2차원 배열을 생성하고 초기화는 대각선 방향으로 하세요
// 1	3	6	9		
// 2*	5	8	11		0,2에서 2,0로 갈 때 초기화
// 4*	7*	10*	12		0,2에서 2,1로 갈 때 초기화 / 2,2로 갈 때 초기화 / 2,3로 갈 때 초기화

public class Test06 {
	
	public static void main(String[] args) {
		
		//준비
		int row = 4;
		int column = 3;
		
		int[][] array = new int[row][column];
		
		// 0,0	-> 합계 0
		
		// 0,1		1,0	-> 합계 1
		
		// 0,2		1,1		2,0	-> 합게 2
		
		// 0,3		1,2		2,1		3,0*	->	합계 3
		
		// 0,4*		1,3		2,2		3,1*		4,0*	-> 합계 4
		
		// 0,5*		1,4*	2,3		3,2*		4,1*		5,0*	-> 합계 5
		
		
		//계산
		//- x의 위치와 y의 위치의 합계가 0부터 5까지인 경우를 찾아서 대입 (벗어나는 경우 빼교)
		int count = 1;
		for(int i = 0 ; i <= 5 ; i++) {
			//System.out.println("합계 : " + i);
			for(int k = i ; k >= 0 ; k--) {
				//if(줄이 범위를 벗어나지 않으면서 칸이 범위를 벗어나지 않는다면) {
				if(k < row && (i-k) < column) {
					System.out.println("(" + k + " , " + (i-k) + ")");
					array[k][i-k] = count++;
				}
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
