package oop.inherit2;

// 하위(서브, 자식) 클래스
// extends Phone 이라고 작성하면 Phone 클래스의 모든 모든 내용을 '상속'받는다는 뜻
// 1개 클래스만 상속 가능
public class Galaxy22s extends Phone {	

	// Phone에 있는 field 2개와 method 2개는 이미 가지고 시작
	
	// 고유 기능만 구현하면 끝
	public void samsungPay() {
		System.out.println("삼성페이");
	}
	
	// 총 field 2개, method 3개(공용 2개 + 고유 1개)
}
