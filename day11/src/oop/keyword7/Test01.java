package oop.keyword7;

public class Test01 {

	public static void main(String[] args) {
		
		// 객체 생성 (기본 이율은 빼고 만듬)
		Account a = new Account("유재석", 0.3, 5000000);
		Account b = new Account("강호동", 0.5, 3500000);
		Account c = new Account ("신동엽", 0.2, 8000000);
		
		// 기본 이율을 설정하는 방법
		// 1. 메인 메소드에서 설정 - static이 붙은 값을 변경할 때 객채명.setter명(변경값);
		Account.setInterestN(-1.5);
		
		// 2. Account 클래스에서 직접 입력
		
		// 출력
		a.print();
		b.print();
		c.print();
	}
}
