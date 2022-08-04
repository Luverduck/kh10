package oop.method6;

public class Test01 {
	
	public static void main(String[] args) {
		
		Commodity a = new Commodity();
		a.setting("참이슬", "주류", 1200, true, true);
		
		Commodity b = new Commodity();
		b.setting("클라우", "주류", 3000, false, true);
		
		Commodity c = new Commodity();
		//c.setting("바나나킥", "과자", 1500, false); 로 할 경우 false가 무엇을 지칭하는지 애매 (메소드 오버로딩 단점)
		c.setting("바나나킥", "과자", 1500, false, true);
		
		Commodity d = new Commodity();
		d.setting("허니버터칩", "과자", 2000, true, false);
		
		
		a.print();
		b.print();
		c.print();
		d.print();
		
	}
}
