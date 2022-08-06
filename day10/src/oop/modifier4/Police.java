package oop.modifier4;

import oop.modifier4.Gun;

public class Police {

	//field
	private String name;
	private String position;
	private String location;
	
	Gun a = new Gun(2);

	
	//setter
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPosition(String position) {
		this.position = position;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}
	
	
	//getter
	public String getName() {
		return this.name;
	}
	
	public String getPosition() {
		return this.position;
	}
	
	public String getLocation() {
		return this.location;
	}
	
	Police(String name, String position, String location) {
		this.setName(name);
		this.setPosition(position);
		this.setLocation(location);
	}
	
	
	//method
	public void shoot() {
		a.fire();
	}

	public void print() {
		System.out.println("이름 : " + this.name);
		System.out.println("직급 : " + this.position);
		System.out.println("근무지역 : " + this.location);
		a.printGun();
		System.out.println();
	}
}
