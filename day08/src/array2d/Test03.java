package array2d;

//사용자에게 줄 수와 칸 수를 입력 받아 해당하는 크기 만큼의 2차원 배열을 생성하고
//좌측 상단에 1부터 채워 넣어 끝까지 1씩 증가하며 숫자가 채워지도록 구현하세요

import java.util.Scanner;

public class Test03 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		//준비
		int row = sc.nextInt();
		int column = sc.nextInt();
		
		int[][] array = new int[row][column];
		//array.length는 row와 같다
		//array[?].length는 col과 같다
		
		//계산
		int count = 1;
		for(int j = 0 ; j < array.length ; j++) {
			for(int i = j ; i < array[j].length ; i++) {
				array[j][i] = count;
				count++;
				//array[j][i] = (column * j) + i + 1;	->	column의 수를 c라 할 때 (c+1)진법 원리를 이용
				
				//array[j][i] = count++;	//대입한 후  증가시킴
				//array[j][i] = ++count;	//증가시킨 후 대입
			}
		}
		
		//출력
		for(int j = 0; j < array.length ; j ++) {
			for(int i = 0 ; i < array[j].length ; i++ ) {
				System.out.print(array[j][i]);
				System.out.print("\t");
			}
			System.out.println();
		}
		
		
	}

}
