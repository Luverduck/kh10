package array;

public class Test14 {
	
	public static void main(String[] args) {
		
		//삽입 정렬 (insertion sort)
		//- 모든 자리의 값을 순차적으로 백업 후 들어갈 자리를 만들어 삽입하는 정렬
		
		//now데이터를 백업 후 now의 이전 순서의 데이터 전부를를 순차적으로 비교하여 now의 데이터보다 크면 한칸씩 옆으로 밀어
		//1. now 위치(1부터)의 데이터를 백업한다
		//2. now 위치 이전 데이터와 비교하여 크면(if) 밀고 작으면(else) 놔둔다
		//3. 마지막에 민 데이터 장소에 백업데이터를 삽입한다
		
		//데이터의 맞교환을 할 필요가 없다
		
		int[] data = new int[] {30, 50, 20, 10, 40};
		
		System.out.print("정렬 전 배열 : ");
		for(int i = 0 ; i < data.length ; i ++) {
			System.out.print(data[i] + ", ");
		}
		
		System.out.println();
		
		//1회 정렬 
		for(int j = 0 ; j < data.length ; j++) {
		
			int backup = data[j];			//현재 위치(j)의 데이터를 백업
			int index = j;					//현재 위치(j)를 들어갈 위치로 설정
			
			for(int i = j - 1 ; i >= 0 ; i --) {	
				if(backup < data[i]) {		//앞 부분을 스캔하기 위한 반복문
					data[i + 1] = data[i];	//데이터를 한 칸 우측으로 복사
					index--;				//들어갈 위치를 한 칸 왼쪽으로 조정
				}
				else {
					break;					//for에도 break 사용 가능
				}
			}
			
			data[index] = backup;
			
		}
		
		System.out.println();
		
		//출력
		System.out.print("정렬 후 배열 : ");
		for(int i = 0 ; i < data.length ; i++) {
			System.out.print(data[i] + ", ");
		}
		
		//선택, 버블, 삽입 정렬 연습 많이
		
	}

}
