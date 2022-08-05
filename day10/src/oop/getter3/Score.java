package oop.getter3;

public class Score {
	
	//필드
	String name;
	int level;
	int korean, english, math;
	
	//이름
	void setName(String name) {		//외부의 데이터를 받아
		this.name = name;			//나에게 설정
	}
	
	String getName() {
		return this.name;
	}
	
	//학년
	void setLevel(int level) {
		if(level <= 0) {
			return;
		}
		this.level = level;
	}
	
	int getLevel() {
		return this.level;
	}
	
	//국어 성적
	void setKorean(int korean) {
		//if(korean >= 0 && korean <= 100) {	
		//	this.korean = korean;
		//}
		if(korean < 0 || korean > 100) return;		//괄호가 하나만 있을 때 사용 가능
		this.korean = korean;
	}
	
	int getKorean() {
		return this.korean;
	}
	
	//영어 성적
	void setEnglish(int english) {
		if(english >= 0 && english <= 100) {
			this.english = english;
		}
	}
	
	int getEnglish() {
		return this.english;
	}
	
	//수학 성적
	void setMath(int math) {
		if(math >= 0 && math <= 100) {
			this.math = math;
		}
	}
	
	int getMath() {
		return this.math;
	}
	
	//총합
	int getSum() {	
		return this.korean + this.english + this.math;
	}
	
	//평균
	float getAvg() {	
		return this.getSum() / 3f;
	}
	
	//등급
	String getGrade() {	
		float avg = this.getAvg();
		if(this.getAvg() < 70) {	//this를 쓸 것
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
	
	//constructor
	Score(String name, int level, int korean, int english, int math) {
		this.setName(name);
		this.setLevel(level);
		this.setKorean(korean);
		this.setEnglish(english);
		this.setMath(math);
	}
	
	//출력 메소드
	void print() {
		System.out.println("<성적 정보>");
		System.out.println("이름 : " + this.name);
		System.out.println("학년 : " + this.level);
		System.out.println("국어점수 : " + this.korean);
		System.out.println("영어점수 : " + this.english);
		System.out.println("수학점수 : " + this.math);
		System.out.println("총합 : " + getSum());
		System.out.println("평균 : " + getAvg());
		System.out.println("등급 : " + getGrade());
		System.out.println();
	}
	
}
