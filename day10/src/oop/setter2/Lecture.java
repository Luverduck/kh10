package oop.setter2;

public class Lecture {
	
	String course;
	int time;
	int price;
	String type;
	
	void setCourse(String course) {
		this.course = course;
	}
	
	void setTime(int time) {
		if(time < 30) {	//수강 시간은 30시간 단위로만 할 수 있다
			return;
		}
		//else if(time % 30 == 0) {
		//	this.time = time;
		//}
		if(time % 30 != 0) {
			return;
		}
		this.time = time;
	}
	
	void setPrice(int price) {	//수강료가 0보다 작을수는 없다
		if(price < 0) {
			return;
		}
		this.price = price;
	}
	
	void setType(String type) {
		//if(type == "온라인") {		//문자열은 비교 연산이 힘들다(안될 경우가 존재)
		//	this.type = type;
		//}
		//else if(type == "오프라인") {
		//	this.type = type;
		//}
		//else if(type == "혼합강의") {
		//	this.type = type;
		//}
		//else {
		//	return;
		//}
		
		switch(type) {
		case "온라인":
		case "오프라인":
		case "혼합":
			this.type = type;
		}
		
	}
	
	
	Lecture(String course, int time, int price, String type) {
		this.setCourse(course);
		this.setTime(time);
		this.setPrice(price);
		this.setType(type);
	}
	
	void print() {
		System.out.println("과정명 : " + this.course);
		System.out.println("총시간 : " + this.time);
		System.out.println("수강료 : " + this.price);
		System.out.println("구분 : " + this.type);
	}
	
}
