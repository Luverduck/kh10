package oop.method4;

public class Menu {
	
	//멤버 필드
	String name;
	String type;
	int price;
	boolean eventTF;	//String eventTF; 도 가능
	
	//세팅 메소드 (오버로딩 - boolean을 입력하지 않는 경우를 false로 처리하기 위해 새로운 메소드를 만들 때 중복코드를 제거하기위한)
	void setting(String name, int price, String type) {
		this.setting(name, type, price, false);
	}
	
	//세팅 메소드
	void setting(String name, String type, int price, boolean eventTF) {
		this.name = name;
		this.type = type;
		this.price = price;
		this.eventTF = eventTF;
	}
	
	
	//출력 메소드
	void print() {
		System.out.println("<메뉴 정보>");
		System.out.println("이름 : " + this.name);
		System.out.println("구분 : " + this.type);
		System.out.println("가격 : " + this.price + "원");
		if(eventTF == true) {
			System.out.print("행사 상품");
		}
		
	}
	
}
