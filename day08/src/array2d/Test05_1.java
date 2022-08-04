package array2d;

//Test03번과 동일하게 줄과 칸 수를 입력받아 2차원 배열을 생성하고 초기화는 세로 방향으로 하세요
//줄 수 3, 칸 수 4
// 1	4	7	10
// 2	5	8	11
// 3	6	9	12

import java.util.Scanner;

public class Test05_1 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		//int row = sc.nextInt();
		//int column = sc.nextInt();
		
		//준비
		int row = 3;
		int column = 4;
		
		int[][] array = new int[row][column];
		
		//계산	//값을 기준으로
		// 1 -> 2 -> 3 -> 4 -> ... - > 12(= row*colum)
		int x = 0, y = 0;
		for(int i = 1 ; i <= row * column ; i++) {
			array[x][y] = i;
			//System.out.println(i + " → (" + x + " , " + y + ")");	//좌표 이동부터 고려한 후 count로 데이터 입력
			if(x < row - 1) {	//마지막 열이 아니라면
				x++;			//다음 열로 
			}
			else {
				y++;			//다음 행 첫 번째 줄로
				x = 0;
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
