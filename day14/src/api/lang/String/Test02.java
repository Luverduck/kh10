package api.lang.String;

// 사용자에게 아이디와 비밀번호를 입력받아서 로그인을 처리하는 프로그램 구현
// 아이디는 khacademy, 비밃번호는 student일 경우에만 로그인 성공메세지 출력
// - 그 외에는 로그인 불가 메세지 출력

// (추가) 허용 아이디와 비밀번호 개수를 늘려보세요

import java.util.Scanner;

public class Test02 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// 입력
		System.out.print("ID를 입력하세요 ");
		String userId = sc.next();
		System.out.print("비밀번호를 입력하세요 ");
		String userPassword = sc.next();
		System.out.println();
		
		sc.close();
		
		// 설정값
		String id = "khacademy";
		String pw = "student";
		
		// 판정
		// boolean isLogin = 아이디가 khacademy이고 비밀번호가 student인가요?
		// boolean isLogin == userId == "khacademy" && userPassword == "student";	
		boolean isLogin = userId.equals("khacademy") && userPassword.equals("student");		//객체는 equals로 비교하자
		
		if(isLogin == true) {
			System.out.println("로그인 성공");
		}
		else {
			System.out.println("로그인 불가");
		}
	}
}
