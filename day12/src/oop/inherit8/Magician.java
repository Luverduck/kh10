package oop.inherit8;

public class Magician extends Class {

	// 생성자 - Class 상속
	public Magician(String id) {
		super(id);
	}

	// 오버라이딩
	@Override
	public void attack() {
		System.out.println("마법사가 마법으로 공격합니다!");
	}

	@Override
	public void move() {
		System.out.println("마법사가 날아서 이동합니다!");
	}

	@Override
	public void print() {
		System.out.println("ID : " + super.id);
		System.out.println("LV : " + super.lv);
	}
}
