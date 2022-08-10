package oop.multi2_1;

public class Test01 {

	public static void main(String[] args) {
		
		Drone a = new Drone();
		a.move();
		a.onoff();
		a.fly();
		
		System.out.println();
		
		Airplane b = new Airplane();
		b.move();
		b.fly();
		b.reserve();
		
		System.out.println();
		
		Train c = new Train();
		c.move();
		c.reserve();
		
		System.out.println();
		
		Bus d = new Bus();
		d.move();
		
		System.out.println();
		
		Kickboard e = new Kickboard();
		e.move();
		e.onoff();
	}
}
