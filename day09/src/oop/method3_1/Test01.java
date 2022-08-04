package oop.method3_1;

public class Test01 {

	public static void main(String[] args) {
		
		Student a = new Student();
		a.setting("피카츄", 90, 90, 90);
		
		Student b = new Student();
		b.setting("라이츄", 80, 90, 85);
		
		Student c = new Student();
		c.setting("꼬부기", 100, 90, 90);
		
		a.korean = 0;
		
		a.print();
		b.print();
		c.print();
	}
}
