package array;

//다음 규칙에 따라 정렬을 구현하세요.
//30, 10, 20, 50, 40을 저장할 배열을 만듭니다.
//배열의 위치를 변경하여 10, 20, 30, 40, 50 순으로 저장될 수 있도록 만든 뒤 출력합니다
//배열에서 가장 작은 값을 찾아 가장 왼쪽에 있는 데이터와 교체합니다
//교체된 데이터의 위치는 제외하고 나머지 위치에서 가장 작은 값을 찾아 좌측 데이터와 교체합니다
//데이터가 완전히 정렬될 때까지 반복합니다

//다음 사이트를 참고하여 구현하세요
//[https://visualgo.net/en/sorting](https://visualgo.net/en/sorting)
//1. 상단 메뉴에서 정렬 방식을 `SEL`(선택 정렬, SELECTION SORT)로 지정합니다
//2. 하단 `Create(A)` 버튼을 눌러 데이터 입력란에 `30, 10, 20, 50, 40`을 입력하고 Go를 누릅니다
//3. 하단 `Sort` 버튼을 누르면 정렬되는 과정을 시각적으로 확인할 수 있습니다 

public class Test12 {
	
	public static void main(String[] args) {
		
		int[] array = new int[] {30, 10, 20, 50, 40};
		
		System.out.print("정렬 전 배열 : ");
		for(int i = 0 ; i < array.length ; i++) {
			System.out.print(array[i] + ", ");
		}
		
		System.out.println();
		
		for(int j = 0 ; j < array.length ; j ++) {	//바꾸는 과정을 반복
			int minIndex = j;	//최소값의 자리를 지칭하는 index
			for(int i = minIndex + 1 ; i < array.length ; i ++) {
				int backup;		
				if(array[minIndex] > array[i]) {	//array[minIndex]에는 가장 작은 값이 와야 한다
					backup = array[minIndex];
					array[minIndex] = array[i];
					array[i] = backup;
				}
			}
		}
		
		System.out.println();
		
		System.out.print("정렬 후 배열 : ");
		for(int i = 0 ; i < array.length ; i ++) {
			System.out.print(array[i] + ", ");
		}
		
	}

}