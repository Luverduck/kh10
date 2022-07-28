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

public class Test10_me {
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
		int nowSec = 0;
		int totalNowSec = nowDay * dayToSec + nowHour * hourToSec + nowMinute * minToSec + nowSec;
		
		int totalDifference = totalNowSec - totalWriteSec;
		//System.out.println("작성 후 흐른 시간 : " + totalDifference + "[sec]");
		
		int time;
		if(totalDifference <= 10) {
			time = 10;
			System.out.println("방금 전");
		}
		
		else if(totalDifference < minToSec) {
			time = totalDifference;
			System.out.println(time + "초 전");
		}
		
		else if(totalDifference < hourToSec) {
			time = totalDifference / minToSec;
			System.out.println(time + "분 전");
		}
		
		else if(totalDifference < dayToSec) {
			time = totalDifference / hourToSec;
			System.out.println(time + "시간 전");
		}
		else {
			time = totalDifference / dayToSec;
			System.out.println(time + "일 전");
		}
		
		
	}

}
