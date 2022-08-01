package loop2;

public class Test01 {

	public static void main(String[] args) {
		
		//중첩 반복문 (for 안에 for 구조)
		//1시간 시간을 출력
		//하루 동안 출력은 for 안에 다음의 구문을 24번 반복
		for(int min = 0 ; min < 60 ; min++) {			//60분 = 1시간
			for(int sec = 0 ; sec < 60 ; sec++) {		//60초 = 1분
				System.out.println(min + "분 " + sec + "초");
			}
		}
		
		//반복문 2개까지는 허용, 그 이상부터는 비효율적
		for(int hour = 0; hour < 24 ; hour++) {
			for(int min = 0; min < 60; min++) {
				for(int sec = 0; sec < 60; sec++) {
					System.out.println(hour + "시 " + min + "분 " + sec + "초");
				}
			}
		}
		
		
	}
	
}
