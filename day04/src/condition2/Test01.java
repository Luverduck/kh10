package condition2;

import java.lang.*;

public class Test01 {
	public static void main(String[] args) {
		
		//switch ~ case 의 필요성
		//-if문은 순차적으로 검사해서 실행하는 특징을 가진다
		//-동일한 실행속도가 필요한 상황이라면 (ex : 키보드, 마우스 처리) 문제가 된다

		//if로 작성시 
		//검사 횟수가 다르므로 아래와 위의 속도가 차이남 (위로 올라갈 때가 아래로 갈 때보다 느림)
		int direction = 7; //예를 들어 2,4,6,8을 방향키라고 하며 아래쪽 방향 키가 입력되었다고 할 때
		
		if(direction == 2) {
			System.out.println("아래로 한 칸 이동");
		}
		else if(direction == 4) {
			System.out.println("왼쪽으로 한 칸 이동");
		}
		else if(direction == 6) {
			System.out.println("오른쪽으로 한 칸 이동");
		}
		else if(direction == 8) {
			System.out.println("위로 한 칸 이동");
		}
		else {
			System.out.println("잘못된 입력");
		}
	}

}
