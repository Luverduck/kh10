package oop.multi2;

public class Kickboard implements Transportation, Electronic {

	@Override
	public void onoff() {
		System.out.println("킥보드의 전원을 켭니다 / 끕니다");
	}

	@Override
	public void move() {
		System.out.println("킥보드가 이동합니다");
	}
}
