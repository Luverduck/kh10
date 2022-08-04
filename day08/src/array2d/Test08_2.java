package array2d;

//다음 규칙에 따라 지뢰찾기를 만드세요
//- 9x9 크기의 정수 배열을 준비합니다
//- 지뢰는 9로 표시하며, 배열 내에 무작위로 20개가 배치됩니다
//- 배치된 이후 전체 지도를 출력하세요

//아래의 내용은 추가 문제이며 따로 풀이하지 않습니다
//- 지뢰를 제외한 나머지 칸은 자신을 제외한 반경 8칸의 지뢰 개수를 세어 숫자를 기록해야 합니다
//- 가장자리에 있는 칸의 경우 배열을 벗어나는 부분을 제외하고 계산해야 합니다
//- 반경에 지뢰가 하나도 없다면 0이 설정됩니다

import java.util.Random;

public class Test08_2 {
	
	public static void main(String[] args) {
		
		int number = 9;
		
		int[][] array = new int[number][number];		//9x9 배열	//총 칸 수 81개
		
		Random r = new Random();
		
		while(true) {
			int count9 = 0;
			for(int j = 0 ; j < array.length ; j++) {
				for(int i = 0 ; i < array[j].length ; i++) {
					int numR = r.nextInt(8) + 1;	//1에서 9까지 랜덤수
					array[j][i] = numR;
					if(array[j][i] == 9) {
						count9++;
					}
				}
			}
			if(count9 == 20) {
				break;
			}
		}
		
		for(int j = 0 ; j < array.length ; j ++) {
			for(int i = 0 ; i < array[j].length ; i++) {
				System.out.print(array[j][i]);
				System.out.print("\t");
			}
			System.out.println();
		}
	}

}
