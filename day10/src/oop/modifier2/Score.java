package oop.modifier2;

//oop.getter3에서 풀었던 문제를
//접근제한 키워드와 사용자 입력을 추가해서 1명의 정보를 생성 후 출력

public class Score {

	private String name;			//은닉화
	private int level;
	private int korean;
	private int english;
	private int math;
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setLevel(int level) {
		if(level >= 1 && level <= 3) {
			this.level = level;
		}
	}
	
	public void setKorean(int korean) {
		if(korean >= 0 && korean <= 100) {
			this.korean = korean;
		}
	}
	
	public void setEnglish(int english) {
		if(english >= 0 && english <= 100) {
			this.english = english;
		}
	}
	
	public void setMath(int math) {
		if(math >= 0 && math <= 100) {
			this.math = math;
		}
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getLevel() {
		return this.level;
	}
	
	public int getKorean() {
		return this.korean;
	}
	
	public int getEnglish() {
		return this.english;
	}
	
	public int getMath() {
		return this.math;
	}
	
	public int getSum() {
		return this.korean + this.english + this.math;
	}
	
	public float getAvg() {
		return this.getSum() / 3f;
	}
	
	public String getGrade() {
		if(this.getAvg() < 70) {
			return "F";
		}
		else if(this.getAvg() < 80) {
			return "C";
		}
		else if(this.getAvg() < 90) {
			return "B";
		}
		else {
			return "A";
		}
	}
	
	public Score(String name, int level, int korean, int english, int math) {
		this.setName(name);
		this.setLevel(level);
		this.setKorean(korean);
		this.setEnglish(english);
		this.setMath(math);
	}
	
	//기본 생성자 - Test02에서 생성자를 먼저 만들고 입력을 받기 위해서
	public Score() {}
	
	public void print() {
		System.out.println("이름 : " + this.name);
		System.out.println("학년 : " + this.level);
		System.out.println("국어 점수 : " + this.korean);
		System.out.println("영어 점수 : " + this.english);
		System.out.println("수학 점수 : " + this.math);
		System.out.println("총점 : " + getSum());
		System.out.println("평균 : " + getAvg());
		System.out.println("등급 : " + getGrade());
	}
}
