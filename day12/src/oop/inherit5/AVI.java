package oop.inherit5;

public class AVI extends MediaFile {
	
	// 생성자
	// - fileName 뿐만 아니라 다른 항목들도 반드시 설정하게 구현하려면
	// - 배속을 설정하지 않으면 기본 배속(x1)로 구현
	AVI(String fileName, long fileSize) {
		super(fileName);
		this.setFileSize(fileSize);
		this.setSpeed(1);		// speed를 설정하지 않으면 1배속이 되도록
	}
	
	// 생성자 (speed가 입력됬을 경우의
	public AVI(String fileName, long fileSize, double speed) {
		super(fileName);
		this.setFileSize(fileSize);
		this.setSpeed(speed);
	}
	
	// AVI 고유 필드
	private double speed;

	// getter & setter
	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		if(speed > 0) {
			this.speed = speed;
		}
	}
	
	// 메소드
	
}
