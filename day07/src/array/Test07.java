package array;

//반 학생 5명의 신장을 측정한 결과는 다음과 같습니다
//[150.5, 185.2, 177.9, 175.4, 163.6]

//1. 전체 학생들의 신장을 배열에 저장하고 출력하세요
//2. 반 평균 신장을 출력하세요
//3. 가장 작은 학생의 위치와 신장을 출력하세요
//4. 평균에 가장 가까운 학생의 신장을 출력하세요

public class Test07 {

	public static void main(String[] args) {
		
		//1. 전체 학생들의 신장을 배열에 저장하고 출력하세요
		//데이터 준비
		float[] data = new float[] {150.5f, 185.2f, 177.9f, 175.4f, 163.6f};
		
		//출력
		System.out.print("1. 전체 반 학생의 신장 : ");
		for(int i = 0 ; i < data.length ; i ++) {
			if(i == data.length - 1) {
				System.out.println(data[i] + "[cm]");
			}
			else {
				System.out.print(data[i] + "[cm], ");
			}
		}
		
		System.out.println();
		
		
		//2. 반 평균 신장을 출력하세요
		double sum = 0;
		for(int i = 0 ; i < data.length ; i ++) {	//배열 전체 반복문
			sum += data[i];
		}
		
		double avg = sum / data.length;
		//System.out.println("합계 : " + sum);
		System.out.println("2. 평균 : " + avg);
		
		System.out.println();
		
		
		//3. 가장 작은 학생의 위치와 신장을 출력하세요
		int minIndex = 0;
		for(int i = 0 ; i < data.length ; i++) {
			if(data[minIndex] > data[i]) {
				minIndex = i;			//index = i로 변경 (갱신)
			}
		}
		
		System.out.println("3. 가장 작은 학생의 위치 : " + minIndex + ", 신장 : " + data[minIndex] );
		
		System.out.println();
		
		
		//4. 평균에 가장 가까운 학생의 신장을 출력하세요
		//평균에 근접하게 -> 평균과의 차이가 가장 작은 값을 찾아라
		
		//평균에 가장 가까운 데이터
		//1. 새로운 배열을 같은 크기로 준비한다
		//2. 모든 데이터를 평균에서 뺀 다음 저장한다
		//3. 비교를 통해 가장 작은 값을 찾는다
		
		double[] gap = new double[data.length];		//위에 data의 배열 크기를 그대로 가져오는 방법
		for(int i = 0 ; i < data.length ; i ++ ) {	
			if(data[i] > avg) {
				gap[i] = data[i] - avg;				//위에 data의 각 위치의 값에서 avg만큼 빼서 새로운 배열을 만드는 방법
			}
			else {
				gap[i] = avg - data[i];
			}
		}
		
		int devIndex = 0;
		for(int i = 1 ; i < gap.length ; i++) {
			if(gap[devIndex] > gap[i]) {
				devIndex = i ;
			}
		}
		System.out.println("평균과 가장 가까운 데이터는 " + devIndex + "위치에 있습니다");
		System.out.println("데이터 : " + data[devIndex] + "[cm]");
		
		System.out.println();
		
		//절대값 라이브러리 : Math.abs()
		//double a = Math.abs(data[i]- avg);
		
		
		//4_me.
		int index = 0;
		double initial = (data[0] - avg) * (-1);
		//System.out.println("0번째 배열의 편차 : " + initial);
		
		for(int i = 1 ; i < data.length ; i++) {
			double deviation = data[i] - avg;
			
			double deviationFixed;		//편차가 음수일 경우 양수로 환산(절댓값)
			if(deviation < 0) {
				deviationFixed = deviation * (-1);
				//System.out.println(i + "번째 배열의 편차 : " + deviationFixed);
			}
			else {
				deviationFixed = deviation;
				//System.out.println(i + "번째 배열의 편차 : " + deviationFixed);
			}
			
			if(deviationFixed < initial) {
				initial = deviationFixed;
				index = i;
			}
			
		}
		System.out.println("4_me. 평균에 가장 가까운 학생의 키 : " + data[index]);
		
	}
}
