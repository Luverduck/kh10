package array;

import java.util.Arrays;

public class Test14_1 {
	
	public static void main(String[] args) {
		
		//정렬 라이브러리 사용
		
		int[] data = new int[] {30, 50, 20, 10, 40};
		
		System.out.print("정렬 전 배열 : ");
		for(int i = 0 ; i < data.length ; i ++) {
			System.out.print(data[i] + ", ");
		}
		
		//정렬 라이브러리 -> 원리는??
		Arrays.sort(data);
		
		System.out.println();
		
		//출력
		System.out.print("정렬 후 배열 : ");
		for(int i = 0 ; i < data.length ; i++) {
			System.out.print(data[i] + ", ");
		}
		
		//선택, 버블, 삽입 정렬 연습 많이
		
	}

}
