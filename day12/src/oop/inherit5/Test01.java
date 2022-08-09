package oop.inherit5;

public class Test01 {
	
	public static void main(String[] args) {
		
		// 객체 생성 및 기능 출력
		MP3 a = new MP3("Test.mp3",1L*1024L*1024L, 180);
		a.execute();
		a.forward();
		a.rewind();
		
		// 객체 생성 및 기능 출력
		AVI b = new AVI("Test.avi", 100L*1024*1024);
		b.execute();
		b.forward();
		b.rewind();
		
		// 객체 생성 및 기능 출력
		PPT c = new PPT("PPT", 5L*1024L*1024L, 25);
		c.execute();
		c.information();
	}
}
