package condition2;

import java.lang.*;

public class Test02 {
	public static void main(String[] args) {
		
		//Test01을 Switch ~ case 구문으로 변경
		//예를 들어 2,4,6,8을 방향키라고 하며 아래쪽 방향 키가 입력되었다고 할 때
		
		int direction = 8;
		
		switch(direction) {
		case 2:
			System.out.println("아래쪽으로 한 칸 이동");
			break; //더이상 실행을 멈추고 나가세요
		case 4:
			System.out.println("왼쪽으로 한 칸 이동");
			break;
		case 6:
			System.out.println("오른쪽으로 한 칸 이동");
			break;
		case 8:
			System.out.println("아래로 한 칸 이동");
			break;
		default:
			System.out.println("잘못된 입력");
			break;
		}
		
		//switch ~ case의 좋은 점은 동시처리이기 떼문에 실행 속도가 빠르지만
		//매 case마다 break 코드를 작성해야 함
		
	}

}
