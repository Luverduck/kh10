package oop.modifier4;

public class Gun {

	//총알
	private int bullet;
	
	//setter
	public void setBullet(int bullet) {
		this.bullet = bullet;
	}
	
	//getter
	public int getBullet() {
		return this.bullet;
	}
	
	//생성자
	Gun(int bullet) {
		this.bullet = bullet;
	}
	
	
	//발사 메소드
	public void fire() {
		if(bullet <= 0) {	//0발 이하가 되면 
			System.out.println("딸깍");
		}
		else {				//0발 이상이면
			System.out.println("빵야");
			bullet--;
		}
	}
	
	//남은 총알 메소드
	public void printGun() {
		System.out.println("남은 총알 : " + this.bullet);
	}
}