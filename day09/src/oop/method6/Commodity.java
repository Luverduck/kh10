package oop.method6;

public class Commodity {
	
	//멤버 필드
	String name;
	String type;
	int price;
	boolean deliveryTF;		//String deliveryTF;
	boolean eventTF;		//String eventTF;

	//설정 메소드
	//오버로딩 주의사항 : 메소드 오버로딩은 형태까지 같은 경우는 불가능하다 (2개 이상이 형태가 같으면 불가능 (boolean 2개가 구분이 안됨))
	//void setting(String name, String type, int price) {
	//	this.setting(name, type, price, false, false);
	//}
	
	//void setting(String name, String type, int price, boolean ) {
	//	
	//}
	
	void setting(String name, String type, int price, boolean deliveryTF, boolean eventTF) {
		this.name = name;
		this.type = type;
		this.price = price;
		this.deliveryTF = deliveryTF;
		this.eventTF = eventTF;
	}
	
	//출력 메소드
	void print() {
		System.out.print("<상품 정보>");
		if(this.deliveryTF) {
			System.out.print("새벽배송");
		}
		if(this.eventTF) {
			System.out.print("행사상품");
		}
		System.out.println();
		
		System.out.println("이름 : " + this.name);
		System.out.println("분류 : " + this.type);
		
		if(this.eventTF) {
			int discountPrice = this.price * (100 - 10) / 100;
			System.out.print("가격 : " + discountPrice + "원(원래가격 " + this.price + "원)");
		}
		else {
			System.out.print("가격 : " + this.price + "원");
		}
		
		if(this.deliveryTF) {
			System.out.print("(+2500원)");
		}
		System.out.println();
		System.out.println();
		
	}
	
	
	//void print (){
	//	if(deliveryTF == true) {	//만약 새벽배송 가능이라면
	//		if(eventTF == true) {
	//			System.out.println(this.name + "\t\t" + this.type + "\t\t" + (this.price * (100 - 10) / 100) + "(할인중)" + "\t" + this.deliveryTF + "(+2500원)");
	//		}
	//		else {
	//			System.out.println(this.name + "\t\t" + this.type + "\t\t" + this.price + "\t\t" + this.deliveryTF + "(+2500원)");
	//		}
	//	}
	//	else {		//만약 새벽 배송 불가능이라면
	//		if(eventTF == true) {
	//			System.out.println(this.name + "\t\t" + this.type + "\t\t" + (this.price * (100 - 10) / 100) + "(할인중)" + "\t" + this.deliveryTF);
	//		}
	//		else {
	//			System.out.println(this.name + "\t\t" + this.type + "\t\t" + this.price + "\t" + this.deliveryTF);
	//		}
	//	}
	//}
	
}
