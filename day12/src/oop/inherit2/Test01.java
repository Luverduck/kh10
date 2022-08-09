package oop.inherit2;

public class Test01 {

	public static void main(String[] args) {
		
		// 상속이 잘 되었는지 확인하기 위한 코드 작성
		
		// Galaxy22s 객체 생성
		Galaxy22s a = new Galaxy22s();	// a는 stack에, Galaxy22s는 heap에 저장
		
		// 공통 method (상속)
		a.call();
		a.camera();
		
		// 고유 method
		a.samsungPay();
		
		
		// IPhone13 객체 생성
		IPhone13 b = new IPhone13();
		
		// 공통 method (상속)
		b.call();
		b.camera();
		
		// 고유 method
		b.itunes();
	}
}
