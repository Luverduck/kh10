package oop.inherit8_1;

public class Warrior extends Player {

	// 생성자 - Class 상속
	public Warrior(String id) {
		super(id);
	}

	// 오버라이딩
	@Override
	public void attack() {
		System.out.println("전사가 칼로 공격합니다!");
	}

	@Override
	public void move() {
		System.out.println("전사가 뛰어서 이동합니다!");
	}
}
