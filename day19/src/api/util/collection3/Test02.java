package api.util.collection3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test02 {

	// 다음 아이디와 비밀번호를 Map에 저장해두고 로그인 프로그램을 구현
	// 아이디 : testuser , 비밀번호 : testuser1234
	// 아이디 : student , 비밀번호 : student1234
	// 아이디 : manager , 비밀번호 : manager1234
	
	// 사용자에게 아이디와 비밀번호를 입력받는다
	// 저장소에 있는 아이디 = 비밀번호 정보와 일치하는 항목이 있다면 로그인 성공 출력
	// 일치하는 항목이 없으면 로그인 실패 출력

	public static void main(String[] args) {

		// 유저 정보에 대한 Map 생성
		Map<String, String> user = new HashMap<>();
		user.put("testuser", "testuser1234");
		user.put("student", "student1234");
		user.put("manager", "manager1234");

		// 아이디, 비밀번호 입력
		Scanner sc = new Scanner(System.in);
		
		// 시험 입력
		String inputID = "testuser";
		String inputPW = "testuser1234";
		
		//System.out.print("ID 입력 : ");
		//String inputID = sc.next();
		
		//System.out.print("PW 입력 : ");
		//String inputPW = sc.next();
		
		// 판정 - 입력한 아이디과 같은 아이디가 존재(contains)하며 그 아이디의 비밀번호(user.get(inputID))가 입력 비밀번호와 일치(equals)
		boolean isLogin = user.containsKey(inputID) && inputPW.equals(user.get(inputID));
		
		// 출력
		if(user.get(inputID).equals(inputPW)) {
			System.out.println("로그인 성공");
		}
		else {
			System.out.println("로그인 실패");
		}
	}
}
