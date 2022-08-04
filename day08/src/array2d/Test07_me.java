package array2d;

//다음 규칙에 따라 빙고판을 만드세요
//- 5x5 크기의 정수 배열을 준비합니다
//- 1부터 25까지의 숫자를 무작위 위치에 배치합니다
//- 한 칸에는 한 번만 값을 배치할 수 있습니다
//- 크기가 달라질 경우에도 달라진 크기에 맞게 빙고판이 만들어져야 합니다
//ex
// 20	13	5	14	19
// 6	12	1	8	25
// 21	2	9	15	18
// 22	10	16	3	7
// 11	24	4	17	23

import java.util.Random;
import java.util.Scanner;

public class Test07_me {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		//System.out.println("숫자를 입력하세요");
		//int number = sc.nextInt();
		
		int number = 5;
	
		int[][] array = new int[number][number];
		
		Random r = new Random();
		
		//중복 번호에 대해서 어떻게 해결할 것인지?
		
		for(int j = 0 ; j < array.length ; j ++) {
			for(int i = 0 ; i < array[j].length ; i ++) {
				int numR = r.nextInt(25) + 1;		//1~25번호 생성
				array[j][i] = numR;
			}
		}
		
		for(int j = 0 ; j < array.length ; j ++) {
			for(int i = 0 ; i < array[j].length ; i++) {
				System.out.print(array[j][i]);
				System.out.print("\t");
			}
			System.out.println();
			System.out.println();
		}
	
	}

}
