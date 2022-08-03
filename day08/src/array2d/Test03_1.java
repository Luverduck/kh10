package array2d;

//사용자에게 줄 수와 칸 수를 입력 받아 해당하는 크기 만큼의 2차원 배열을 새엇ㅇ하고
//좌측 상단에 1부터 채워 넣어 끝까지 1씩 증가하며 숫자가 채워지도록 구현하세요

import java.util.Scanner;

public class Test03_1 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int row = 2;
		int column = 3;
		
		int[][] array = new int[row][column];
		//array.length는 row와 같다
		//array[?].length는 column과 같다
		
		//계산
		//- 기준을 (줄, 칸)이 아니라 숫자로 보면?	-> 1부터 (row * column)까지
		int x = 0, y = 0;
		for(int i = 1 ; i <= row * column ; i ++) {
			//System.out.println(i + "를 (" + x +" , " + y + ")에 대입합니다");
			array[x][y] = i;
			if(y < column - 1) {
				y++;	//다음 칸
			}
			else {
				x++;	//다음 줄
				y = 0;	//첫 칸
			}
		}
		
		//출력
		for(int j=0; j < array.length; j++) {
			for(int i=0; i < array[j].length; i++) {
				System.out.print(array[j][i]);
				System.out.print("\t");
			}
			System.out.println();
		}
		
	}

}
