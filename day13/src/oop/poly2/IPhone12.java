package oop.poly2;

public class IPhone12 extends Phone  {

	@Override
	public void camera() {
		System.out.println("아이폰 12 사진촬영 실행");
	}

	@Override
	public void gallary() {
		System.out.println("아이폰 12 갤러리보기 실행");
	}

	@Override
	public void call() {
		System.out.println("아이폰 12 전화 실행");
	}

	@Override
	public void sms() {
		System.out.println("아이폰 12 문자 실행");
	}
}
