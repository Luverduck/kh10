package array2d;

public class Test02 {
	
	public static void main(String[] args) {
		
		//2차원 배열
		
		//생성
		//1) 길이만 아는 경우
		int[][] a = new int[2][3];
		//a -------> a[0] --------> [ 0 ][ 0 ][ 0 ]
		//			 a[1] --------> [ 0 ][ 0 ][ 0 ]
		System.out.println("2차원 배열의 길이 : " + a.length);
		System.out.println("1차원 배열의 길이 : " + a[0].length);
		System.out.println("1차원 배열의 길이 : " + a[1].length);
		System.out.println();
		
		//2) 데이터를 아는 경우
		int[][] b = new int[][] {
			{10, 20, 30}, 
			{40, 50, 60}
		};
		//또는 int[][] b = new int[][] {{10, 20, 30}, {40, 50, 60}};
		//a -------> a[0] --------> [ 10 ][ 20 ][ 30 ]
		//			 a[1] --------> [ 40 ][ 50 ][ 60 ]
		System.out.println("2차원 배열의 길이 : " + b.length);
		System.out.println("1차원 배열의 길이 : " + b[0].length);
		System.out.println("1차원 배열의 길이 : " + b[1].length);

		System.out.println();
		
		//30을 불러올 때
		System.out.println(b[0][2]);

		System.out.println();
		
		//전체 출력
		System.out.print(b[0][0]);
		System.out.print("\t");
		System.out.print(b[0][1]);
		System.out.print("\t");
		System.out.print(b[0][2]);
		System.out.print("\t");
		
		System.out.println();
		
		System.out.print(b[1][0]);
		System.out.print("\t");
		System.out.print(b[1][1]);
		System.out.print("\t");
		System.out.print(b[1][2]);
		System.out.print("\t");
		
		System.out.println();
		System.out.println();
		
		//2차원 배열을 시각화
		for(int j = 0 ; j < b.length ; j++) {
			for(int i = 0 ; i < b[i].length ; i ++) {	//b[i].length에서 [] 안에 i를 쓴 것은 가변 배열을 고려하지 않기 위함
				System.out.print(b[j][i]);
				System.out.print("\t");
			}
			System.out.println();
		}	
		
	}

}
