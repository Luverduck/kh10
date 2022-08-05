package oop.modifier3;

import oop.modifier2.Score;		//oop.modifier2에 있는 score 클래스를 불러옴 (score가 공개(public)되어있다면)

public class Test01 {

	public static void main(String[] args) {
		
		//(Q) 다른 패키지에 있는 내용을 사용할 수 있는가??
		//(A) 그냥은 안된다. 자바는 기본 인식 범위가 패키지(Package)이다 -> import로 불러와야함
		//- import를 통해 외부 요소를 준비시켜 사용할 수 있다
		
		//(주의)
		//1. 클래스가 public이 아니면 import가 불가능하다
		//2. 구성 요소들도 public이 아니면 접근이 불가
		//(나중에 상속을 배우면 protected는 가능)
		
		
		Score a = new Score();		//oop.modifier2에서 Score() {}가 public 상태라면 객체 생성 가능
		
		a.print();
	}
	
}
