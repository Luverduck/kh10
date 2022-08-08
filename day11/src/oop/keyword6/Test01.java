package oop.keyword6;

public class Test01 {

	public static void main(String[] args) {
	
		// 객체 생성
		Galaxy22s a = new Galaxy22s("아쿠아블루", "010-1212-3434", 256);
		Galaxy22s b = new Galaxy22s("실버", "010-2323-3434", 512);
		
		a.setMemory(512);				// a의 메모리를 512로 교체
		a.setNumber("010-1111-2222");	// a의 전화번호를 010-1111-2222로 교체
		a.setColor("블랙");				// a의 색상을 교체
		a.setCompany("애플");;			// a의 제조사를 교체
		Galaxy22s.setCompany("애플");	
		
		// 필드에도 일괄 관리해야 할 항목(제조사)과 개별 관리해야 할 항목(색상, 번호, 저장공간)이 있다
		// 일괄 관리 항목(변화가 모두에 반영이 되도록 하는 항목)에 static을 붙임
		
		// company에 static을 붙이면 제조사를 애플로 바꾸는 변화가 모두 반영이 된다
		// static이 붙으면 객체 둘 중 하나의 제조사를 바꾸더라도 둘다 바뀐다 (객체별로 데이터 관리 불가능 - 일괄 관리됨)
		// static이 붙으면 객체 안에서 company가 빠져 나와서 class의 company = "삼성"이 된다
		
		a.print();
		b.print();
	}
}
