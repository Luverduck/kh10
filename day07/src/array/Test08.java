package array;

public class Test08 {

	public static void main(String[] args) {
		
		//배열 데이터 교체 (swap)
		int[] data = new int[] {30, 20, 10, 50, 40};
		System.out.println("배열 교체 전 데이터");
		for(int i = 0 ; i < data.length ; i++) {
			System.out.print(data[i] + " ");
		}
		
		System.out.println();
		System.out.println();
		
		//20과 40의 데이터 순서를 바꾼다고 할 때 {30, 40, 10, 50, 20}
		
		//20과 40을 교체 (맞교환 불가능)
		//data[1] = data[4];
		//data[4] - data[1];
		
		int backup = data[1];	//임시 저장
		data[1] = data[4];		//0번 데이터를 4번 데이터의 값으로 교체
		data[4] = backup;		//4번 데이터를 backup의 데이터 값으로 교체
		
		//출력
		System.out.println("배열 교체 후 데이터");
		for(int i = 0 ; i < data.length ; i++) {
			System.out.print(data[i] + " ");
		}
		
	}
	
}
