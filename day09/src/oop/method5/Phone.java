package oop.method5;

public class Phone {
	
	//멤버 필드
	String name;		//필수
	String tel;			//필수
	int price;			//필수
	int duration;		//선택 (있을 수도 있고 없을 수도 있고)
	
	//설정 메소드	//duration에 값을 입력하지 않으면 0으로 해서 보냄
	void setting(String name, String tel, int price) {
		this.setting(name, tel, price, 0);
	}
	
	void setting(String name, String tel, int price, int duration) {
		this.name = name;
		this.tel = tel;
		if(price >= 0) {
			this.price = price;
		}
		switch(duration) {
		case 0:
		case 24:
		case 30:
		case 36:
			this.duration = duration;
		}
	}
	
	//출력 메소드
	void print() {		
		//if(duration == 0) {
		//	System.out.println(this.name + "\t\t" + this.tel + "\t" + (this.price * (100 - 5) / 100) + "(약정없음)");
		//}
		//else {
		//	int installment = this.price / this.duration;	//월 할부금
		//	System.out.println(this.name + "\t\t" + this.tel + "\t" + this.price + "\t\t" + this.duration + "개월" + "\t\t" + installment);
		//}
		if(this.duration > 0) {	//약정 기간이 있는 경우
			int pricePerMonth = this.price / this.duration;	//약정기간이 있는 경우에만 정의하는 변수
			System.out.println("<휴대폰 정보>");
			System.out.println("이름 : " + this.name);
			System.out.println("통신사 : " + this.tel);
			System.out.println("가격 : " + this.price + "원 (월 " + pricePerMonth + ")");
			System.out.println("약정개월 : " + this.duration + "개월");
			System.out.println();
		}
		else {
			int discountPrice = this.price * (100 - 5) / 100;
			System.out.println("<휴대폰 정보>");
			System.out.println("이름 : " + this.name);
			System.out.println("통신사 : " + this.tel);
			System.out.println("가격 : " + discountPrice + "원 (원 가격 : " + this.price + "원)");
			System.out.println("약정개월 : " + this.duration + "개월");
			System.out.println("(약정 없음)");
			System.out.println();
		}
	}
	
}
