package api.lang.String;

// 사용자에게 아이디와 비밀번호를 입력받아서 로그인을 처리하는 프로그램 구현
// 아이디는 khacademy, 비밃번호는 student일 경우에만 로그인 성공메세지 출력
// - 그 외에는 로그인 불가 메세지 출력

// (추가) 허용 아이디와 비밀번호 개수를 늘려보세요	>> 객체를 추가해서 객체가 같은지 비교

import java.util.Scanner;

public class Test02_1 {

	public static void main(String[] args) {
		
		// 준비 (로그인 정보가 담긴 있는 객체)
		Member admin1 = new Member("khacademy", "student");
		Member admin2 = new Member("nexon", "1111");
		Member admin3 = new Member("nc", "2222");
		Member admin4 = new Member("netmarble", "3333");
		
		Member[] array = new Member[] {admin1, admin2, admin3, admin4};		// 객체도 배열로 만들 수 있다
		
		
		Scanner sc = new Scanner(System.in);
		
		// 입력
		System.out.print("ID를 입력하세요 ");
		String userId = sc.next();
		
		System.out.print("비밀번호를 입력하세요 ");
		String userPassword = sc.next();
		
		System.out.println();
		
		sc.close();
		
		// 객체 생성
		Member user = new Member(userId, userPassword);
		
		// 판정
		int success = 0;
		for(int i = 0 ; i < array.length ; i ++) {
			if(array[i].equals(user)) {
				success ++;			//equals로 두 객체를 비교하여 같으면 로그인 가능하도록
			}
		}
		
		if(success == 1) {
			System.out.println("로그인 성공");
		}
		else {
			System.out.println("로그인 불가");
		}
		
	}
}
