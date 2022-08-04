package oop.method2;

public class Player {

	//멤버 필드
	String name;
	String game;
	String season;
	int gold;
	int silver;
	int bronze;
	
	//세팅 메소드 : 외부 데이터를 this에 입력
	void setting(String name, String game, String season, int gold, int silver, int bronze) {
		this.name = name;
		this.game = game;
		this.season = season;
		this.gold = gold;
		this.silver = silver;
		this.bronze = bronze;
	}
	
	//출력 메소드 : 입력된 this 데이터를 출력
	void print() {
		System.out.println(this.name + "\t" + this.game + "\t" + this.season + "\t" + this.gold + "\t" + this.silver + "\t" + this.bronze);
	}
	
}
