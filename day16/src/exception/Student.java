package exception;

import java.util.regex.Pattern;

public class Student {

	// 필드
	private String name;
	private int korean, english, math;
	
	// getter & setter
	public String getName() {
		return name;
	}
	
	// throw - 예외를 발생시키는 코드
	// throws - 예외가 발생할 것이라고 경고하는 코드
	
	// throws Exception이 없다면 try ~ catch에서 호출 불가능
	
	public void setName(String name) throws Exception {	// throws Exception : 예외처리를 하지 않겠다 (경고)
		if(Pattern.matches("[가-힣]{2,7}", name)) {
			this.name = name;	
		}
		else {
			throw new Exception("이름은 한글 2~7자로 작성하세요");
		}
	}
	
	public int getKorean() {
		return korean;
	}
	
	public void setKorean(int korean) throws Exception {// throws Exception : 예외처리를 하지 않겠다 (경고)
		if(korean < 0 || korean > 100) {
			//return;
			throw new Exception("국어점수는 0~100점으로만 설정 가능합니다");
		}
		this.korean = korean;	// else도 가능
	}
	
	public int getEnglish() {
		return english;
	}
	
	public void setEnglish(int english) throws Exception {
		if(english < 0 || english > 100) {
			throw new Exception("영어점수는 0~100점으로만 설정 가능합니다");
		}
		this.english = english;	// else도 가능
	}
	
	public int getMath() {
		return math;
	}
	
	public void setMath(int math) throws Exception {
		if(math < 0 || math > 100) {
			throw new Exception("수학점수는 0~100점으로만 설정 가능합니다");
		}
		this.math = math;
	}
	
	// 생성자
	public Student() {}
	
	public Student(String name, int korean, int english, int math) throws Exception {
		this.setName(name);
		this.setKorean(korean);
		this.setMath(math);
		this.setEnglish(english);
	}
	
	// 1) try ~ catch 예외를 즉석에서 처리
	// 2) throws Exception 예외처리가 있을 경우에만 메소드 호출 가능

	// toString : 인스턴스의 필드 정보를 알려준다
	@Override
	public String toString() {
		return "Student [name=" + name + ", korean=" + korean + ", english=" + english + ", math=" + math + "]";
	}
}
