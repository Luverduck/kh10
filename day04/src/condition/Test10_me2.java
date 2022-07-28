package condition;

//작성한 게시글이 몇 초 전에 작성되었는지에 대한 값이 주어진다고 가정합니다.

//'''java
//int second = 150;
//'''

//시간을 다음 규칙에 따라 변환하여 출력하는 프로그램을 구현
//-방금 전 : 작성한지 10초 이내인 글
//-?초 전 : 작성한지 1분이 되지 않은 글
//-?분 전 : 작성한지 1분 이상이면서 1시간이 되지 않은 글
//-?시간 전 : 작성한지 1시간 이상이면서 24시간이 되지 않은 글
//-?일 전 : 나머지

import java.lang.*;

public class Test10_me2 {
	public static void main(String[] args) {
		
		int minToSec = 60;
		int hourToSec = 60 * 60;
		int dayToSec = 24 * 60 * 60;
		
		int writeDay = 0;
		int writeHour = 0;
		int writeMinute = 0;
		int writeSec = 0;
		int totalWriteSec = writeDay * dayToSec + writeHour * hourToSec + writeMinute * minToSec + writeSec;
		
		int nowDay = 0;
		int nowHour = 0;
		int nowMinute = 0;
		int nowSec = 59;
		int totalNowSec = nowDay * dayToSec + nowHour * hourToSec + nowMinute * minToSec + nowSec;
		
		int totalDifference = totalNowSec - totalWriteSec;
		//System.out.println("작성 후 흐른 시간 : " + totalDifference + "[sec]");
		
		//String을 이용하여 최적화하는 방법
		String message;
		if(totalDifference <= 10) {
			message = "방금 전";
		}
		
		else if(totalDifference < minToSec) {
			message = totalDifference + "초 전";
		}
		
		else if(totalDifference < hourToSec) {
			message = totalDifference / minToSec + "분 전";
		}
		
		else if(totalDifference < dayToSec) {
			message = totalDifference / hourToSec + "시간 전";
		}
		
		else {
			message = totalDifference / dayToSec + "일 전";
		}
		
		System.out.println(message);
		
		
	}

}
