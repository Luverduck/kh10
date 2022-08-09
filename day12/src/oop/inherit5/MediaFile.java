package oop.inherit5;

public class MediaFile extends File {

	// 생성자 - 부모 클래스(File)에서 파일명을 반드시 필요로 하므로 맞춰준다
	// - 상속받기 위한 생성자 (부모 클래스에서 생성자에 fileName이 반드시 입력하도록 설정했으므로)
	public MediaFile(String fileName) {
		super(fileName);	// fileName 값이 super(부모 클래스)로 전달된다
	}
	
	// MP3와 AVI의 공용 메소드
	public void forward() {
		System.out.println("빨리감기");
	}
	
	public void rewind() {
		System.out.println("되감기");
	}
}
