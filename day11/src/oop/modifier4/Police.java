package oop.modifier4;

public class Police {

	// 멤버 필드
	private String name;
	private String rank;
	private String area;
	
	// 권총 객체 생성 -> 총알은 생성자에 넣는다
	private Gun gun;
	
	// setter & getter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	
	// 경찰 정보 출력
	public void print() {
		System.out.println("<경찰 정보>");
		System.out.println("이름 : " + this.name);
		System.out.println("직급 : " + this.rank);
		System.out.println("근무지 : " + this.area);
		this.gun.print();		// 권총의 정보 출력을 메소드를 출력하는 방식으로 하기
		System.out.println();
	}		
	
	// shoot 메소드
	public void shoot() {
		System.out.println(this.name + "의 총을 발사합니다!");
		this.gun.fire();
	}
	
	// 생성자
	public Police(String name, String rank, String area) {
		this.name = name;
		this.rank = rank;
		this.area = area;
		this.gun = new Gun(2);
	}
}
