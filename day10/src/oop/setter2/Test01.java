package oop.setter2;

public class Test01 {

	public static void main(String[] args) {
		
		Lecture a = new Lecture("자바 마스터 과정", 90, 1000000, "온라인");
		Lecture b = new Lecture("파이썬 기초", 60, 600000, "온라인");
		Lecture c = new Lecture("웹 개발자 단기완성", 120, 1200000, "오프라인");
		
		a.print();
		b.print();
		c.print();
		
	}
}
