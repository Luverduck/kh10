package oop.method2;

import java.util.Scanner;

public class Test01 {
	
	public static void main(String[] args) {
		
		//객체 생성 및 세팅
		Player a = new Player();
		a.setting("진종오", "사격", "하계", 4, 2, 0);
		
		Player b = new Player();
		b.setting("김수녕", "양궁", "하계", 4, 1, 1);
		
		Player c = new Player();
		c.setting("전이경", "쇼트트랙", "동계", 4, 0, 1);
		
		//출력 (method를 이용)
		a.print();
		b.print();
		c.print();
		
	}
}
