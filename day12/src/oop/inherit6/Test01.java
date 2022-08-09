package oop.inherit6;

public class Test01 {

	public static void main(String[] args) {
		
		Galaxy22s a = new Galaxy22s("010-0000-0000", "검정");
		a.call();
		a.message();
		a.samsungPay();
		a.bixby();
		
		GalaxyFold3 b = new GalaxyFold3("010-0000-0001", "노랑");
		b.call();
		b.message();
		b.samsungPay();
		b.iris();
		
		IPhone12 c = new IPhone12("010-0000-0002", "파랑");
		c.call();
		c.message();
		c.siri();
		c.itunes();
		
		IPhone13 d = new IPhone13("010-0000-0003", "초록");
		d.call();
		d.message();
		d.siri();
		d.facetime();
	}
}
