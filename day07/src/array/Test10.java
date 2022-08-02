package array;

//점심 메뉴 추첨 프로그램
//사용자에게 입력할 메뉴의 개수를 입력받아 해당 크기만큼의 배열을 생성합니다
//생성된 배열에 점심메뉴를 입력합니다
//입력이 완료되면 입력된 메뉴 중에서 랜덤으로 한 개의 메뉴를 추첨한 뒤 출력합니다

import java.util.Scanner;
import java.util.Random;

public class Test10 {
	
	public static void main(String[] args) {
		
		//문제를 잘못 이해함
		
		//배열의 크기 설정
		int size = 3;
		
		//배열 생성
		System.out.println("메뉴를 입력하세요");
		String[] menu = new String[size];
		//menu.length는 size와 같다
		
		//입력
		Scanner sc = new Scanner(System.in);
		for(int i = 0 ; i < size ; i++) {	//입력을 size번 반복
			menu[i] = sc.next();
		}
		
		//난수 발생 (1부터 3 사이로 제한)
		Random r = new Random();
		int index = r.nextInt(size);
		System.out.println("index = " + index);
		
		//
		System.out.println("오늘 점심은 " + menu[index] + "로 갑시다");
		
		sc.close();
		
	}

}