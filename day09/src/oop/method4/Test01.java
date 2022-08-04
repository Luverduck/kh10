package oop.method4;

public class Test01 {

	public static void main(String[] args) {
		
		Menu a = new Menu();
		//a.name = "아메리카노";
		//a.type = "음료";
		//a.price = 2500;
		//a.eventTF = true;
		a.setting("아메리카노", "음료", 2500, true);
		
		Menu b = new Menu();
		//b.name = "모카라떼";
		//b.type = "음료";
		//b.price = 3500;
		//b.eventTF = false;
		b.setting("모카라떼", "음료", 3500, false);
		
		Menu c = new Menu();
		//c.name = "치즈케이크";
		//c.type = "디저트";
		//c.price = 5000;
		//c.eventTF = true;
		c.setting("치즈케이크", "디저트", 5000, true);
		
		Menu d = new Menu();
		d.name = "마카롱";
		d.type = "디저트";
		d.price = 3000;
		d.eventTF = false;	
		
		a.print();
		b.print();
		c.print();
		d.print();
		
	}
}
