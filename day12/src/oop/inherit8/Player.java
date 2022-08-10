package oop.inherit8;

public abstract class Player {

	// 필드
	protected String id;
	protected int lv;		// private로 하면 오직 Player 클래스에서만 레벨을 조정할 수 있다
	
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
	public Player(String id) {
		this.setId(id);		// id를 setId에 대입하여 얻는 반환값
		this.setLv(1);		// lv에 1을 대입한 후 setLv에 대입하여 얻는 반환값
	}
	
	// 메소드 - 사용자 정보 출력 (공용필드인 id와 lv을 출력할 것이므로 재정의할 필요가 없다)
	public final void print() {	// final을 붙여 재정의가 불가능하도록 만든다
		System.out.println("<플레이어 정보>");
		System.out.println("아이디 : " + this.id);	// 이 클래스가 super이므로 this로 할 것
		System.out.println("레벨 : " + this.lv);
	};
	
	// 추상 메소드
	public abstract void attack();		// 공격
	public abstract void move();		// 이동
	
}
