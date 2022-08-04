package oop.method3;

public class Student {

	//멤버 필드
	String name;
	int korean;
	int english;
	int math;
	int sum;		//입력에 표시되지 않는 필드
	double avg;		//입력에 표시되지 않는 필드
	
	//세팅
	void setting(String name, int korean, int english, int math) {	//name, korean, english, math만 입력하면
		this.name = name;
		this.korean = korean;
		this.english = english;
		this.math = math;
		
		this.sum = korean + english + math;		//sum과 avg를 계산해서
		this.avg = this.sum / 3.0;
	}
	
	//출력
	void print() {	//최종 출력에 계산한 sum과 avg를 출력할 수 있다
		System.out.println(this.name + "\t" + this.korean + "\t" + this.english + "\t" + this.math + "\t" + this.sum + "\t" + this.avg);
	}
}
