package oop.basic1;		//package 이름에 .을 붙이면 oop 파일 속에 basic1 파일이 생기는 방식
						//최상위 패키지 파일을 oop로 하고 하위로 basic1, basic2, ...이 생기는 방식

//객체 지향(OOP)
//ex) 메세지라는 객체 : 제목 / 내용 / 시간 / 안읽었을 때 숫자 등

public class Message {
	
	//자바에게 메세지라는 것을 알려주기 위해 만든 클래스
		
	String writer;		//메세지에는 writer라는 구성 요소가 있다 (메세지 제목)
			
	String content;		//메세지에는 content라는 구성 요소가 있다 (메세지 내용)
		
	String time;		//메세지에는 time라는 구성 요소가 있다 (보낸 시간)
		
	int remain;			//메세지에는 remain라는 구성 요소가 있다 (안읽었을 때 숫자)

}
