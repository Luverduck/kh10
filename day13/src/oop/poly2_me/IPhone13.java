package oop.poly2_me;

public class IPhone13 extends Phone  {
	
	@Override
	public void camera() {
		System.out.println("아이폰 13 사진촬영 실행");
	}

	@Override
	public void gallary() {
		System.out.println("아이폰 13 갤러리보기 실행");
	}

	@Override
	public void call() {
		System.out.println("아이폰 13 전화 실행");
	}

	@Override
	public void sms() {
		System.out.println("아이폰 13 문자 실행");
	}
}
