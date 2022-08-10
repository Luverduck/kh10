package oop.inherit8;

public class Elf extends Player {

	// 생성자 - Class 상속
	public Elf(String id) {
		super(id);
	}

	// 오버라이딩
	@Override
	public void attack() {
		System.out.println("엘프가 활로 공격합니다");
	}

	@Override
	public void move() {
		System.out.println("엘프가 이동합니다");
	}
}
