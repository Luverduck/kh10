package oop.keyword9;

import java.util.Scanner;

public class Test01 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// 입력 방법 1.
		User a = new User(sc.next(), sc.next(), sc.next());
		
		// 입력 방법 2.
		//final String id = sc.next();		// final을 안써도 상관없지만 쓰는게 좋다
		//String password = sc.next();
		//String nickname = sc.next();
		
		sc.close();
		
		//User a = new User(id, password, nickname);
		
		// a.setid("pdpdpe");				// 객체 생성시 설정된 id는 바꿀 수 없다 
		a.setPassword("ㅇㅇㄹㄹ");
		
		a.print();
	}
}
