package oop.inherit8;

public abstract class Class {

	// 필드
	protected String id;
	protected int lv;
	
	// getter & setter
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getLv() {
		return lv;
	}

	public void setLv(int lv) {
		if(lv <= 0) {
			return;
		}
		this.lv = lv;
	}
	
	// 생성자
	public Class(String id) {
		this.id = id;
		this.lv = 1;
	}

	// 추상 메소드
	public abstract void attack();		// 공격
	public abstract void move();		// 이동
	public abstract void print();		// 정보 출력
}
