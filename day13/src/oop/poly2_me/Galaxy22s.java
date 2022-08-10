package oop.poly2_me;

public class Galaxy22s extends Phone {

	@Override
	public void camera() {
		System.out.println("갤럭시22s 사진촬영 실행");
	}

	@Override
	public void gallary() {
		System.out.println("갤럭시22s 갤러리보기 실행");
	}

	@Override
	public void call() {
		System.out.println("갤럭시22s 통화 실행");
	}

	@Override
	public void sms() {
		System.out.println("갤럭시22s 문자 실행");
	}

}
