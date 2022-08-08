package oop.modifier4;

public class Test01 {

	public static void main(String[] args) {
		
		// 객체 생성
		Police a = new Police("포돌이", "순경", "영등포경찰서");
		Police b = new Police("포순이", "경장", "당산파출소");
		Police c = new Police("포그리", "순경", "마포경찰서");
		
		// 총 발사
		a.shoot();
		a.shoot();
		
		b.shoot();
		
		c.shoot();
		c.shoot();
		c.shoot();
		
		// 발사 후 정보 출력
		a.print();
		b.print();
		c.print();
	}
}
