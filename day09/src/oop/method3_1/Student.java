package oop.method3_1;

public class Student {

	//멤버 필드
	String name;
	int korean;
	int english;
	int math;			//합과 평균 없이
	
	//세팅
	void setting(String name, int korean, int english, int math) {	//name, korean, english, math만 입력하면
		this.name = name;
		this.korean = korean;
		this.english = english;
		this.math = math;
	}
	
	//출력
	void print() {	//최종 출력에 계산한 sum과 avg를 출력할 수 있다
		int sum = this.korean + this.english + this.math;		//최종 출력에서 직접 계산하는 방식
		double avg = sum / 3.0;									//최종 출력에서 직접 계산하므로 값의 수정이 편리하다
		System.out.println(this.name + "\t" + this.korean + "\t" + this.english + "\t" + this.math + "\t" + sum + "\t" + avg);
	}
}
