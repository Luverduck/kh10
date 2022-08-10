package oop.poly2_me;

import java.util.Scanner;

public class Test01 {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		// 기종 선택(kind)
		System.out.print("기종 선택 : ");
		int kind = sc.nextInt();
		
		// 기능 선택(task)
		System.out.print("기능 선택 : ");
		int task = sc.nextInt();
		
		// kind의 값에 따라 해당 기종 객체 생성
		Phone phone;
		switch(kind) {
		case 1:
			phone = new Galaxy22s();
			break;
		case 2:
			phone = new GalaxyFold3();
			break;
		case 3:
			phone = new IPhone12();
			break;
		default:
			phone = new IPhone13();
			break;
		//case 4:
		//	phone = new IPhone13();
		//	break;
		//default:
		//	System.out.println("1에서 4 사이의 숫자를 입력해주세요");
		//	break;,
		// 객체가 
		}
		
		// task의 값에 따라 해당 기종의 기능 실행
		switch(task) {
		case 1:
			phone.camera();
			break;
		case 2:
			phone.gallary();
			break;
		case 3:
			phone.call();
			break;
		default:
			phone.sms();
			break;
		//case 4:
		//	phone.sms();
		//	break;
		//default:
		//	System.out.println("1에서 4 사이의 숫자를 입력해주세요");
		//	break;
		}
	}
}
