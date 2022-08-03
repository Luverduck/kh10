package array;

//Test12과 같은 데이터를 버블정렬(BUBBLE SORT)을 통해 오름차순으로 정렬하고 출력해보세요

public class Test13 {
	
	public static void main(String[] args) {
		
		int[] array = new int[] {50, 40, 30, 20, 10};
		
		System.out.print("정렬 전 배열 : ");
		for(int i = 0 ; i < array.length ; i++) {
			System.out.print(array[i] + ", ");
		}
		
		System.out.println();
		
		//다음꺼랑 비교하여 데이터를 교체하는 과정을 반복하여 정렬
		
		for(int j = array.length - 2 ; j >= 0 ; j --) {
		
			for(int i = 0 ; i <= j ; i ++) {
				int nowIndex = i;
				int backup;
				if(array[nowIndex] > array[nowIndex + 1]) {
					backup = array[nowIndex];
					array[nowIndex] = array[nowIndex + 1];
					array[nowIndex + 1] = backup;
				}
			}
		}
		
		System.out.print("정렬 후 배열 : ");
		for(int i = 0 ; i < array.length ; i ++) {
			System.out.print(array[i] + ", ");
		}
		
	}

}