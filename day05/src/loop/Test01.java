package loop;
import java.lang.*;
public class Test01 {
	public static void main(String[] args) {
		
		//반복(loop)			//횟수는 추상적인 개념
		
		//ex) 화면에 Hello를 10번 출력하세요
		
		//x10 
		
		//for 구문
		//for(1 ; 2 ; 3) (;로 코드 구분)
		//1번 영역 : 반복에 필요한 변수(반복수)를 만드는 영역 (선언부)
		//2번 영역 : 반복이 실행되어야 하는 조건을 지정하는 영역, 언제까지 반복을 진행할 것인지 (조건부)
		//3번 영역 : 반복수를 변화시키는 영역 (증감부)
		
		//for 구문을 나타내는 방법 3가지
		//for(int i=0 ; i<10 ; i=i+1) {
		//for(int i=0 ; i<10 ; i+=1) {
		for(int i=0 ; i<10 ; i++) {			//++i : 전위 증감
			System.out.println("Hello");
		}
		
	}

}
