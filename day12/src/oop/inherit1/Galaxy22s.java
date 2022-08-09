package oop.inherit1;

public class Galaxy22s {

	// field - 정보
	private String color;
	private String number;
	
	// method - 기능
	public void call() {
		System.out.println("통화 기능");
	}
	public void camera() {
		System.out.println("카메라 기능");
	}
	public void samsungPay() {
		System.out.println("삼성페이");
	}
	
	// Galaxy22s 클래스와 IPhone13 클래스는 겹치는 요소가 많다
	// 각각은 고유의 기능(삼성페이와 아이튠즈)이 있으므로 두 클래스는 서로 나누되 
	// 두 클래스의 공통 부분(통화, 카메라)의 코드를 줄이기 위해 '상속' 사용
}
