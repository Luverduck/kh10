package oop.constructor2;

public class Player {
	
	//멤버 필드
	String name;
	String type;
	int level;
	
	//기본 생성자
	//- 클래스는 객체를 만들기 위해 존재한다
	//- 생성자를 안만들어도 하나는 만들어준다
	//- 마음에 안들면 다른 생성자를 만든다
	//Player() {}
	Player(String name, String type){					//level을 입력받지 않았을 경우에 자동으로 1이 되도록
		this(name, type, 1);	//this가 생성자를 지칭하게됨
	}
	
	Player(String name, String type, int level){		//생성자를 오버로딩해서 level을 입력받을 경우에 대해서도 고려
		this.name = name;
		this.type = type;
		this.level = level;
	}
	
	//레벨업 메소드
	void levelUP() {
		this.level++;
	}
	
	//출력 메소드
	void print() {
		System.out.println("닉네임 : " + this.name);
		System.out.println("직업 : " + this.type);
		System.out.println("레벨 : " + this.level);
		System.out.println();
	}
}
