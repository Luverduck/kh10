package oop.poly2_me;

public class GalaxyFold3 extends Phone  {

	@Override
	public void camera() {
		System.out.println("갤럭시 폴드3 사진촬영 실행");
	}

	@Override
	public void gallary() {
		System.out.println("갤럭시 폴드3 갤러리보기 실행");
	}

	@Override
	public void call() {
		System.out.println("갤럭시 폴드3 전화 실행");
	}

	@Override
	public void sms() {
		System.out.println("갤럭시 폴드3 문자 실행");
	}

}
