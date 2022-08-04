package oop.method3;

public class Test01 {

	public static void main(String[] args) {
		
		Student a = new Student();
		a.setting("피카츄", 90, 90, 90);
		a.print();
		
		Student b = new Student();
		b.setting("라이츄", 80, 90, 85);
		b.print();
		
		Student c = new Student();
		c.setting("꼬부기", 100, 90, 90);
		c.print();
	}
}
