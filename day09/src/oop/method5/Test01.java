package oop.method5;

public class Test01 {
	
	public static void main(String[] args) {
		
		Phone a = new Phone();
		a.setting("갤럭시22s", "SK", 1800000);
		
		Phone b = new Phone();
		b.setting("갤럭시22s", "KT", 1750000, 24);
		
		Phone c = new Phone();
		c.setting("아이폰13", "LG", 2000000, 30);
		
		Phone d = new Phone();
		d.setting("아이폰13", "SK", 1990000);
		
		a.print();
		b.print();
		c.print();
		d.print();
		
	}

}
