package oop.inherit2;

//상위(슈퍼) 클래스
// - 여러 클래스에서 공통적으로 발생하는 코드(필드, 메소드 등)들을 보관하는 클래스
// - 객체를 만드는 목적이 아님
// - 기존에 만들던 객체들의 상위 객체 개념

public class Phone {
	
	// Galaxy22s와 IPhone의 공통 부분을 정의
	
	// 공용 field
	private String color;
	private String number;
	
	// 공용 method
	public void call() {
		System.out.println("통화 기능");
	}
	public void camera() {
		System.out.println("카메라 기능");
	}
}
