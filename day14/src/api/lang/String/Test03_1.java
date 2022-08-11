package api.lang.String;

// 사용자에게 프로그램에 사용할 닉네임을 입력받을 예정입니다
// - 닉네임은 2글자 이상 10글자 이내로 설정해야 합니다
// - 닉네임에는 절대로 '운영자'라는 글자가 포함될 수 없습니다
// - 위의 경우에 해당한다면 '잘못된 닉네임 형식입니다' 출력, 아니면 '닉네임 설정 완료' 출력

import java.util.Scanner;

public class Test03_1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		// 입력
		System.out.print("사용할 닉네임을 입력하세요 ");
		String nickname = "테스트운영자운영자";
		//String nickname = sc.next();
		System.out.println();
		
		sc.close();
		
		// 판정 
		// (1) 글자수 - .length()
		boolean first = nickname.length() >= 2 && nickname.length() <= 10;
		//System.out.println("first = " + first);
		
		// (2) 운영자의 포함 여부 - .indexof() : index를 반환
		// .indexOf : 앞에서부터 문자열을 조사해서 해당 문자열이 포함되어 있으면 그 시작점 index를 출력
		System.out.println("indexOf = " + nickname.indexOf("운영자"));
		
		// .lastindexOf : 앞에서부터 문자열을 조사해서 해당 문자열이 한 개 이상 포함되어 있으면 가장 마지막 문자열의 시작점 index 출력
		// - 만약 해당 문자열이 없다면 -1을 반환
		System.out.println("lastindexOf = " + nickname.lastIndexOf("운영자"));	
		boolean second = nickname.indexOf("운영자") == -1;
		
		// 출력
		//if(first && second) {
		//	System.out.println("닉네임 설정 완료");
		//}
		//else {
		//	System.out.println("잘못된 닉네임 형식입니다");
		//}
	}
}
