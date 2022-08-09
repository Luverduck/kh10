package oop.inherit5;

public class MP3 extends MediaFile {
	
	// 생성자 - 부모 클래스(MediaFile)의 상속을 받기 위한
	public MP3(String fileName) {
		super(fileName);
	}
	
	// 생성자를 하나 더 만들 경우 (파일명은 기본으로 설정하며 사이즈, 파일 지속시간을 추가로 설정하는 경우)
	public MP3(String fileName, long fileSize, int duration) {
		super(fileName);
		super.setFileSize(fileSize);
			// 부모 클래스의 필드를 super로 정확하게 명시하거나 this.fileSize = fileSize;
		this.setDuration(duration);
	}

	// MP3 고유 필드
	private int duration;		
	
	// getter & setter
	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	// 메소드
	
}
