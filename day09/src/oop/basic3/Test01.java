package oop.basic3;

public class Test01 {

	public static void main(String[] args) {
		
		//객체 생성
		Telecom a = new Telecom();
		Telecom b = new Telecom();
		Telecom c = new Telecom();
		
		//데이터 입력
		a.telName = "SKT";
		a.serviceName = "5G언텍트 52";
		a.servicePrice = 52000;
		a.data = 200;
		a.min = 1000;
		a.message = 2000;
				
		b.telName = "KT";
		b.serviceName = "5G세이브";
		b.servicePrice = 45000;
		b.data = 100;
		b.min = 900;
		b.message = 1500;
		
		
		c.telName = "LG";
		c.serviceName = "5G시그니쳐";
		c.servicePrice = 130000;
		c.data = 500;
		c.min = 2000;
		c.message = 2500;
		
		System.out.println("통신사 요금제 정보");
		System.out.println(a.telName + "\t" + a.serviceName + "\t" + a.servicePrice + "\t" + a.data + "\t" + a.min + "\t" + a.message);
		System.out.println(b.telName + "\t" + b.serviceName + "\t\t" + b.servicePrice + "\t" + b.data + "\t" + b.min + "\t" + b.message);
		System.out.println(c.telName + "\t" + c.serviceName + "\t" + c.servicePrice + "\t" + c.data + "\t" + c.min + "\t" + c.message);
		
	}
}
