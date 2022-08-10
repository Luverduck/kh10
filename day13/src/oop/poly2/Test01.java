package oop.poly2;

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
		if(kind == 1) {
			phone = new Galaxy22s(); 	// 갤럭시 22s 생성
		}
		else if(kind == 2) {
			phone = new GalaxyFold3();	// 갤럭시 폴드 3 생성
		}
		else if(kind == 3) {
			phone = new IPhone12();		// 아이폰 12 생성
		}	
		else {
			phone = new IPhone13();		// 아이폰 13 생성
		}
		
		// task의 값에 따라 해당 기종의 기능 실행
		if(task == 1) {
			phone.camera();
		}
		else if(task == 2) {
			phone.gallary();
		}
		else if(task == 3) {
			phone.call();
		}
		else {
			phone.sms();
		}
	}
}
