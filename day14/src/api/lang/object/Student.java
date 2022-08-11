package api.lang.object;

import java.util.Objects;

// 내가 만든 클래스
public class Student {

	// 멤버 필드
	private String name;
	private int score;
	
	// 생성자
	public Student(String name, int score) {
		super();
		this.name = name;
		this.score = score;
	}
	
	public Student() {
		
	}
	
	// getter & setter
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
		this.score = score;
	}

	// hashCode와 equals 재정의
	@Override
	public int hashCode() {
		return Objects.hash(name, score);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(name, other.name) && score == other.score;
	}
	
	
}
