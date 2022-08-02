package array;

//배열 뒤집기
//30, 10, 20, 50, 40을 배열에 저장합니다
//배열의 데이터를 순차적으로 출력합니다
//배열의 모든 데이터의 위치를 반대로 변경합니다(result : 40, 50, 20, 10, 30)
//변경된 데이터를 순차적으로 출력합니다

public class Test11 {
	
	public static void main(String[] args) {
		
		//배열의 데이터를 순차적으로 출력합니다
		int[] array = new int[] {30, 10, 20, 50, 40};
		
		for(int i = 0 ; i < array.length ; i++) {
			System.out.print(array[i] + ", ");
		}
		
		System.out.println();
		
		//배열의 모든 데이터의 위치를 반대로 변경합니다(result : 40, 50, 20, 10, 30)
		//바꾸는 행위를 배열의 길이 / 2 만큼 시행
		//int backup = data
		int backup;
		for(int i = 0 ; i <= (array.length / 2) ; i ++) {
			backup = array[i];
				array[i] = array[(array.length - 1) - i];	// 'array.length - i'까지 생각했으나 -1은 생각하지 못함
				array[(array.length - 1) - i] = backup;		// 반복수 범위의 최대값은 배열의 길이 - 1
		}
		
		for(int i = 0 ; i < array.length ; i++) {
			System.out.print(array[i] + ", ");
		}
		
		
	}

}