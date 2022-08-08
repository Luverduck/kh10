package oop.keyword5;

public class Test01 {

	public static void main(String[] args) {
	
		// 객체 생성
		Galaxy22s a = new Galaxy22s("아쿠아블루", "010-1212-3434", 256);
		Galaxy22s b = new Galaxy22s("실버", "010-2323-3434", 512);
		
		// a의 메모리를 512로 교체
		a.setMemory(512);
		a.setNumber("010-1111-2222");
		a.setColor("블랙");
		a.setCompany("애플");
		
		// 필드에도 일괄 관리해야 할 항목(제조사)과 개별 관리해야 할 항목(색상, 번호, 저장공간)이 있다
		// 일괄 관리 항목(변화가 모두에 반영이 되도록 하는 항목)에 static을 붙임
		
		a.print();
		b.print();
	}
}
