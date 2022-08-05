package oop.modifier1;

public class Student {
	
	//필드
	private String name;		//private : 접근 제한 - 클래스 외부의 접근을 차단
	private int score;			//클래스 내부에서 접근은 가능 (this.name = name;)
	
	//getter, setter
	//메소드는 조건 등이 사용가능하므로 외부에 공개해야 한다
	//- public 키워드 추가
	//- 아무데서나 접근 가능
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		if(score >= 0 && score <= 100) {
			this.score = score;	
		}
	}
	
	//출력 메소드
		void print() {	
			System.out.println(this.name);
			System.out.println(this.score);
		}
	
	//생성자는 외부에서 객체를 생성하기 위한 구문 - 생성자를 private 하면 객체를 만들 수 없으므로 public
	//- 외부의 접근이 가능하도록 public으로 설정
	public Student(String name, int score) {
		this.name = name;
		this.score = score;
	}
	
	//이제부터 변수는 private, 메소드는 public으로 한다
	
}
