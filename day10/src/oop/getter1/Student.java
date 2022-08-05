package oop.getter1;

public class Student {

	//field
	String name;
	int score;
	
	//setter method : 값을 조건에 맞게 설정하는 메소드
	void setName(String name) {
		this.name = name;
	}
	
	void setScore(int score) {
		if(score >= 0 && score <= 100) {
			this.score = score;
		}
	}
	
	//getter method : 값을 반환하는 메소드	-> 존재하지 않는 값들을 계산해서 반환할 수 있다 ex) 합계, 평균 등
	//- 메소드는 실행 후 남겨지는 값을 이름 왼쪽에 명시
	//- 없으면 void로 작성해야함
	String getName() {
		//return; 		//메소드 중지
		//return ?; 	// 값 ?를 반환하면서 중지
		return this.name;
	}
	//메소드명 왼쪽에 쓰는 것은 반환할 때 어떤 값을 반환할 것인지
	//void : 결과 없음
	
	int getScore() {
		return this.score;
	}
	
	//가상의 항목에 대한 getter		//합격 불합격은 변수 필드에 없지만 출력하고싶을 때
	String getResult() {
		if(this.score >= 60) {
			return "합격";
		}
		else {
			return "불합격";
		}
	}
	
	
	//constructor
	Student(String name, int score) {
		this.setName(name);
		this.setScore(score);
	}
	
	//method
	void print() {
		System.out.println(this.name);
		System.out.println(this.score);
		System.out.println(this.getResult());
	}
	
}
