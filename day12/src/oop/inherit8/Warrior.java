package oop.inherit8;

public class Warrior extends Class {

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

	@Override
	public void print() {
		System.out.println("ID : " + super.id);
		System.out.println("LV : " + super.lv);
	}
}
