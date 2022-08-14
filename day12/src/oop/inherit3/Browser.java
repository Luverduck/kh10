package oop.inherit3;

// 상위 클래스
public class Browser {
	
	// 공용 필드
	private String url;

	// setter & getter
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	// 공통 method
	public void refresh() {
		System.out.println("새로고침 기능 실행");
	}
	public void move() {
		System.out.println("페이지 이동 기능 실행");
	}
	
	// 공통특성을 이용해 상위 클래스를 알아내는 추상화가 중요하다
}
