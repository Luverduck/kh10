package array2d;

//사용자에게 줄 수와 칸 수를 입력받아 해당하는 크기만큼의 2차원 배열을 생성하고
//좌측 상단에 1부터 채워넣어 끝까지 1씩 증가하며 숫자가 채워지도록 구현하세요
//구현 후 배열을 출력하세요
//줄 수 : 3, 칸 수 : 4
//1	2	3	4
//5	6	7	8
//9	10	11	12
//추가> 줄별로 합계를 구하세요

import java.util.Scanner;

public class Test04_1 {
	public static void main(String[] args) {
		//준비
		Scanner sc = new Scanner(System.in);
		System.out.print("줄 수 : ");
		int row = sc.nextInt();
		System.out.print("칸 수 : ");
		int col = sc.nextInt();
		sc.close();
		
		int[][] arr = new int[row][col];
		
		//계산
		//- (줄,칸) 기준
		//(0,0)→(1,0)→(2,0)→(0,1)→(1,1)→(2,1)→(0,2)→(1,2)→(2,2)→(0,3)→(1,3)→(2,3)
		int n = 1;
		for(int i=0; i < col; i++) {
			for(int k=0; k < row; k++) {
				arr[k][i] = n;
				n++;
			}
		}
		
		//출력
		for(int i=0; i < arr.length; i++) {
			for(int k=0; k < arr[i].length; k++) {
				System.out.print(arr[i][k]);
				System.out.print("\t");
			}
			System.out.println();
		}
	}
}
