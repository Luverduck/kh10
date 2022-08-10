package oop.inherit8;

public class Test01 {

	public static void main(String[] args) {
		
		// 객체 생성
		Warrior a = new Warrior("전사");
		a.setLv(-3);
		a.attack();
		a.move();
		a.print();
		
		Magician b = new Magician("마법사");
		b.attack();
		b.move();
		b.print();
		
		Elf c = new Elf("엘프");
		c.attack();
		c.move();
		c.print();
	}
}
