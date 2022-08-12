package api.lang.etc;

import java.io.IOException;

public class Test03 {

	public static void main(String[] args) throws IOException {	// 예외처리
		
		// Runtime 클래스
		// - 객체를 하나만 만들어서 공유하는 방식(singleton 방식)
		// - 객체의 일관성을 유지할 수 있다
		// - 외부 환경에 명령을 전송할 수 있다
		
		//Runtime run = new Runtime();	// 불가능		// 생성 코드
		Runtime run = Runtime.getRuntime();			// 대여 코드
		
		// 윈도우 명령
		//run.exec("notepad");		// 외부 환경에 notepad라는 명령을 전송해라 -> 실행시 메모장이 열림
		//run.exec("calc");			// 계산기
		//run.exec("mspaint");		// 그림판
		
		// mac 명령
		//run.exec("open -a TextEdit.app");
		
		if(System.getProperty("os.name").startsWith("Windows")) {	// OS 이름이 windows로 시작한다면
			run.exec("notepad");	// 메모장이 열림
		}
		else if(System.getProperty("os.name").startsWith("Mac")) {
			run.exec("open -a TextEdit.app");
		}
		
	}
}
