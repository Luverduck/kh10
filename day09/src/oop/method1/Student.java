package oop.method1;

public class Student {

	//member field : 데이터 저장소
	String name;
	int score;
	
	//member method : 코드 저장소
	//void 이름() {
	//	
	//}
	
	//설정 메소드(코드 저장소) : 생성된 객체에 자료를 입력하는 세팅
	//- 실행하려면 String과 int를 하나씩 전달해야하는 메소드
	//- 외부에서 전달된 값을 저장하는 변수를 "매개 변수"라고 합니다
	void setting(String name, int score) {
		this.name = name;
		this.score = score;	//this 때문에 뒤의 변수와 구분됨
	}
	
	//출력 메소드 (코드 저장소)
	void print() {
		System.out.println("이름 : " + this.name);		//this : 객체가 생성되면 그 객체 이름을 지칭 (자신)
		System.out.println("점수 : " + this.score);
	}
	
}
