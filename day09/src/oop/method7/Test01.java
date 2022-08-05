package oop.method7;

public class Test01 {
	
	public static void main(String[] args) {
		
		Song a = new Song();
		a.setting("그때 그 순간 그대로(그그그)", "WSG워너비", "WSG워너비 1집", 104250, 91835);
		
		Song b = new Song();
		b.setting("보고싶었어", "WSG워너비", "WSG워너비 1집", 83127, 90805);
		
		Song c = new Song();
		c.setting("Love Dive", "IVE(아이브)", "LOVE DIVE", 64590, 174519);
		
		Song d = new Song();
		d.setting("POP!", "나연(TWICE)", "IM NAYEON", 58826, 70313);
		
		a.print();
		b.print();
		c.print();
		d.print();
	}
}
