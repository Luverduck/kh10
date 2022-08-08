package oop.modifier4;

public class Gun {

	// 멤버 필드
	private int bullet;
	
	// setter & getter
	public void setBullet(int bullet) {
		this.bullet = bullet;
	}
	
	public int getBullet() {
		return this.bullet;
	}
	
	// 권총 정보 출력
	public void print() {
		System.out.println("권총에 남은 총알 수 : " + this.bullet + "발");
	}
		
	public void fire() {
		if(this.bullet > 0) {
			this.bullet --;
			System.out.println("빵야!");
		}
		else {
			System.out.println("딸깍");
		}
	}
	
	// 생성자
	public Gun(int bullet) {
		this.setBullet(2);		// 권총 객체가 생성될 때 총알이이 2발이 되도록
	}							// this.setBullet과의 차이?
	
}
