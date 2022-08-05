package oop.getter2;

public class Exam {
	
	//필드
	String name;
	String course;
	int score, scoreC;
	
	
	//생성자 (순서 상관 x)
	Exam(String name, String course, int score, int scoreC) {
		this.setName(name);
		this.setCourse(course);
		this.setScore(score);
		this.setScoreC(scoreC);
	}
	
	
	//출력 메소드
	void print() {
		System.out.println("<시험 결과>");
		System.out.println("이름 : " + this.name);
		System.out.println("과목 : " + this.course);
		System.out.println("서술형점수 : " + this.score);
		System.out.println("평가자체크리스트점수 : " + this.scoreC);
		System.out.println("합계 : " + getSum());
		System.out.println("평균 : " + getAvg());
		System.out.println("P/F : " + getPass());
		System.out.println();
	}
	
	
	//이름 setter, getter
	void setName(String name) {
		this.name = name;
	}
		
	String getName() {
		return this.name;
	}
		
		
	//과목명 setter, getter
	void setCourse(String course) {
		this.course = course;
	}
		
	String getCourse() {
		return this.course;
	}
		
		
	//서술형 점수 setter, getter
	void setScore(int score) {
		if(score < 0 || scoreC > 100) {		//0 미만 또는 100 초과일 때 중지
			return;
		}
		this.score = score;
	}
		
	int getScore() {
		return this.score;
	}
		
		
	//평가자체크리스트 점수 setter, getter
	void setScoreC(int scoreC) {
		if(scoreC < 0 || scoreC > 100) {	//0 미만 또는 100 초과일 때 중지
											//조건 앞에 !로 표시하면 뒤에 조건 전부다 부정 - if(!scoreC >= 0 && scoreC <= 100) {}
			return;
		}
		this.scoreC = scoreC;
	}
		
	int getscoreC() {
		return this.scoreC;
	}
		
	
	//가상의 getter - 합계, 평균, 통과여부
	//합계 getter
	int getSum() {
		return this.score + this.scoreC;
	}
		
	//평균 getter
	double getAvg() {
		//return (this.essay + this.checklist) / 2.0;
		return this.getSum() / 2;		//메소드 중첩시 반드시 this를 쓰자 (이전의 getSum을 가져올 때 앞에 this 붙이기)
	}
		
		
	//P/F getter
	String getPass() {
		if((this.score >= 40 && this.scoreC >= 40) && getAvg() >= 60) {	
			return "통과";				//각 과목 40점 이상(score 40이상 '이고' scoreC 40이상) '이고' 평균이 60 이상
		}
		else {
			return "재평가";
		}
	}
	
}
