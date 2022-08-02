package array;

public class Test06 {

	public static void main(String[] args) {
		
		//배열의 활용 - 최대 / 최소 구하기
		
		float[] data = new float[] {70f, 55f, 60f, 85f, 75f};
		
		//(Q) 가장 몸무게가 많이 나가는 사람의 몸무게는?
		
		//1. 제일 앞에 있는 값이 가장 크다고 치자
		float max = data[0];
		
		//2. 배열을 스캔하면서 더 큰 값이 있는지 찾는다 
		for(int i = 1; i < data.length ; i++) {
			if(max < data[i]) {
				max = data[i];		//data[0]보다 큰 값을 발견하면 그 값으로 변경
			}
		}
		
		System.out.println(max);
		
		System.out.println();
				
		//(Q) 가장 몸무게가 크게 나가는 사람의 위치는?
		//1. 0번 위치가 가장 큰 값이 있을 것이라고 가정한다
		int index = 0;
		
		//2. 1번 위치부터 배열 전체를 스캔하여 더 큰 값의 위치를 탐색
		for(int i = 1 ; i < data.length ; i++) {
			//System.out.println(data[index] + "," + data[i]);
			//if(알고있는 위치의 값보다 더 큰 값이 나타난다면)
			if(data[index] < data[i]) {
				index = i;
			}
		}
		
		System.out.println("큰 값의 위치 : " + index);
		
		
	}
}
